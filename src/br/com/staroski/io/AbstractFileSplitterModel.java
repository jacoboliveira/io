package br.com.staroski.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is a partial implementation of interface {@link FileSplitterModel}.
 * 
 * @author Ricardo Artur Staroski
 */
public abstract class AbstractFileSplitterModel implements FileSplitterModel {

    // the enclosed input file
    private File file;

    // The number of lines of the input file.
    private int lines;

    // The desired number of parts the input file should be splitted.
    private int parts;

    // The calculated size for each part file.
    private int partSize;

    /**
     * Default constructor
     */
    protected AbstractFileSplitterModel() {
        this(null);
    }

    /**
     * Constructor that accepts an input {@link File} as parameter.
     * 
     * @param file
     *            The input file.
     */
    protected AbstractFileSplitterModel(File file) {
        this.file = file;
    }

    /**
     * This implementation returns <code>true</code> if the <code>line</code> parameter is equal to the value of {@link AbstractFileSplitterModel#getPartSize()
     * getPartSize()}.
     * 
     * @param line
     *            The line number.
     * 
     * @param content
     *            The line content.
     * 
     * @see FileSplitterModel#canSplit(int, String)
     */
    @Override
    public boolean canSplit(int line, String content) throws Exception {
        return line == getPartSize();
    }

    /**
     * @see FileSplitterModel#getFile()
     */
    @Override
    public File getFile() {
        return file;
    }

    /**
     * This implementation returns the name of the file with the suffix <code>.part</code> followed by the <t>number</> parameter.
     * 
     * @see FileSplitterModel#getPartName(int)
     */
    @Override
    public String getPartName(int number) {
        File file = getFile();
        String partName = file == null ? "part" : file.getName() + ".part";
        return partName + number;
    }

    /**
     * This implementation initializes the values returned by the {@link #getLines()}, {@link #getParts()} and {@link #getPartSize()} methods.
     * 
     * @param lines
     *            The number of lines of the input file.
     * 
     * @param parts
     *            The number of parts the input files should be splitted.
     * 
     * @see FileSplitterModel#initialize(int, int)
     */
    @Override
    public void initialize(int lines, int parts) {
        this.lines = lines;
        this.parts = parts;
        this.partSize = (int) Math.ceil(lines / (double) parts);
    }

    /**
     * @see FileSplitterModel#startWriting(File, PrintWriter)
     */
    @Override
    public PrintWriter startWriting(File partFile) throws IOException {
        return new PrintWriter(new BufferedWriter(new FileWriter(partFile)));
    }

    /**
     * @see FileSplitterModel#stopWriting(File, PrintWriter)
     */
    @Override
    public void stopWriting(File partFile, PrintWriter writer) throws IOException {}

    /**
     * Returns the number of lines of the input file.<br>
     * This value is initialized on the {@link #initialize(int, int)} method.
     * 
     * @return The number of lines of the input file.
     */
    protected int getLines() {
        return lines;
    }

    /**
     * Returns the desired number of parts the input file should be splitted.<br>
     * This value is initialized on the {@link #initialize(int, int)} method.
     * 
     * @return The desired number of parts the input file should be splitted.
     */
    protected int getParts() {
        return parts;
    }

    /**
     * Returns the calculated size for each part file.<br>
     * This value is initialized on the {@link #initialize(int, int)} method.
     * 
     * @return The calculated size for each part file.
     */
    protected int getPartSize() {
        return partSize;
    }
}