package br.com.staroski.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class allows a file to be splitted in parts.<br>
 * It is possible to instantiate a {@link FileSplitter} with the following constructors:
 * <ul>
 * <li>{@link #FileSplitter(File)} providing a physical file;</li>
 * <li>{@link #FileSplitter(String)} providing the path of a physical file;</li>
 * <li>{@link #FileSplitter(FileSplitterModel)} providing an {@link FileSplitterModel} for custom behaviour.</li>
 * </ul>
 * 
 * @author Ricardo Artur Staroski
 */
public final class FileSplitter {

    /**
     * Default implementation of {@link FileSplitterModel} used when calling the {@link FileSplitter#FileSplitter(File) FileSplitter(File)} constructor.
     * 
     * @param file
     *            The input file.
     */
    private final class DefaultSplitterModel extends AbstractFileSplitterModel {

        // the enclosed reader
        private BufferedReader reader;

        DefaultSplitterModel(File file) {
            super(file);
        }

        @Override
        public String readLine() throws IOException {
            return reader == null ? null : reader.readLine();
        }

        @Override
        public void startReading() throws IOException {
            stopReading();
            reader = new BufferedReader(new FileReader(getInputFile()));
        }

        @Override
        public void stopReading() throws IOException {
            if (reader != null) {
                reader.close();
                reader = null;
            }
        }
    }

    /**
     * Used internally to prevent <t>null</t> parameters.
     * 
     * @param parameter
     *            The parameter to be validated.
     * @return The parameter itself.
     * @throws IllegalArgumentException
     *             if parameter is <t>null</t>.
     */
    private static <T> T avoidNull(T parameter, String message) {
        if (parameter == null) {
            throw new IllegalArgumentException(message);
        }
        return parameter;
    }

    // the model used by this file splitter
    private final FileSplitterModel model;

    // the output folder
    private File outputFolder;

    /**
     * Creates an {@link FileSplitter} for the given {@link File} object.
     * 
     * @param file
     *            File to be splitted.
     */
    public FileSplitter(final File file) {
        this.model = new DefaultSplitterModel(avoidNull(file, "The 'file' parameter cannot be null"));
    }

    /**
     * Creates an {@link FileSplitter} for the given {@link FileSplitterModel} object.
     * 
     * @param model
     *            The model that provides the file to be splitted.
     */
    public FileSplitter(FileSplitterModel model) {
        this.model = avoidNull(model, "The 'model' parameter cannot be null");
    }

    /**
     * Creates an {@link FileSplitter} for the file located on the given path.
     * 
     * @param path
     *            Path of file to be splitted.
     */
    public FileSplitter(String path) {
        this(new File(avoidNull(path, "The 'path' parameter cannot be null")));
    }

    /**
     * Returns the input {@link File}.
     * 
     * @return the input file.
     */
    public File getInputFile() {
        return avoidNull(model.getFile(), "Method " + model.getClass().getName() + ".getFile() returned null");
    }

    /**
     * Returns the output folder into where the parts will be generated.<br>
     * By default it returns the enclosed file's parent file.<br>
     * Can be changed through the {@link #setOutputFolder(File)} method.
     * 
     * @return The output folder into where the parts will be generated.
     * 
     * @see #setOutputFolder(File)
     */
    public File getOutputFolder() {
        if (outputFolder == null) {
            outputFolder = getInputFile().getParentFile();
        }
        return outputFolder;
    }

    /**
     * Sets the output folder into where the parts will be generated.<br>
     * Affect the result of {@link #getOutputFolder()} method.
     * 
     * @param directory
     *            The output folder.
     * 
     * @return This object itself, allowing enchained calls.
     * 
     * @see #getOutputFolder()
     */
    public FileSplitter setOutputFolder(File directory) {
        if (directory != null && directory.exists() && !directory.isDirectory()) {
            throw new IllegalArgumentException("\"" + directory.getAbsolutePath() + "\" is not a directory");
        }
        this.outputFolder = directory;
        return this;
    }

    /**
     * Sets the output folder into where the parts will be generated.<br>
     * Affect the result of {@link #getOutputFolder()} method.
     * 
     * @param path
     *            The path of the output folder.
     * 
     * @return This object itself, allowing enchained calls.
     * 
     * @see #getOutputFolder()
     */
    public FileSplitter setOutputFolder(String path) {
        return setOutputFolder(path == null ? (File) null : new File(path));
    }

    /**
     * Splits the enclosed file into the specified number of parts.<br>
     * Writes the parts into the {@link #getOutputFolder() output folder}.<br>
     * Returns the {@link File} objects created for each part.
     * 
     * @param parts
     *            The number of parts that the enclosed file will be splitted.
     * 
     * @return An array of {@link File} objects for each part.
     * 
     * @see #setOutputFolder(File)
     */
    public File[] split(int parts) throws Exception {
        int lines; // start counting the amount of lines of the input file
        model.startReading(); // open the input file reader
        for (lines = 0; model.readLine() != null; lines++) { /* read whole file to count lines */ }
        model.stopReading(); // close the input file reader
        model.initialize(lines, parts); // notify that the lines were read and it's ready to split in parts
        model.startReading(); // open the input file reader
        File[] partFiles = prepareParts(parts); // prepare the File objects for each part
        int currentPart = 0; // open the current part file writer
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(partFiles[currentPart])));
        int line = 0; // reset the line counter
        model.startWriting(partFiles[currentPart], writer); // notify start writing the part file
        String content = null; // read the content of the input file
        while ((content = model.readLine()) != null) {
            line++; // increment line number
            writer.println(content); // copy the content from the input file to the current part file
            if (model.canSplit(line, content)) { // check if can close the current part and open the next
                model.stopWriting(partFiles[currentPart], writer); // notify stop writing on the part file
                writer.flush(); // flush the current part file writer
                writer.close(); // close the current part file writer
                currentPart++; // open the next part file writer
                writer = new PrintWriter(partFiles[currentPart]);
                line = 0; // reset the line counter
                model.startWriting(partFiles[currentPart], writer); // notify start writing the part file
            }
        }
        model.stopReading(); // close the input file reader
        model.stopWriting(partFiles[currentPart], writer); // notify stop writing on the part file
        writer.flush(); // flush the current part file writer
        writer.close(); // close the current part file writer
        return partFiles; // return the part files to the caller
    }

    /**
     * Creates an {@link File} array for the specied amount of parts.
     * 
     * @param parts
     *            The number of parts.
     * 
     * @return An {@link File} array.
     */
    private File[] prepareParts(int parts) {
        File[] partFiles = new File[parts];
        File folder = getOutputFolder();
        folder.mkdirs(); // ensure that the output directory tree exists
        String namePrefix = getInputFile().getName() + ".part";
        for (int number = 0; number < parts; number++) {
            partFiles[number] = new File(folder, namePrefix + number);
        }
        return partFiles;
    }
}
