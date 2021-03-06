package br.com.staroski.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A model interface that gives more flexibility to the {@link FileSplitter} class.<br>
 * Allows it to work with any implementation of this interface and not only pure {@link File} objects.<br>
 * After calling the {@link FileSplitter#split(int)} method the {@link FileSplitterModel} will be used in the following order:<br>
 * <ol>
 * <li>{@link #startReading()} method will be called to start counting the lines of input file;</li>
 * <li>{@link #readLine(BufferedReader)} will be called for each line read;</li>
 * <li>{@link #stopReading(BufferedReader)} will be called to stop the line counting;</li>
 * <li>{@link #initialize(int, int)} will be called passing the number of lines and desired number of parts the input file should be splitted;</li>
 * <li>{@link #startReading()} will be called to start reading the content of the input file;</li>
 * <li>{@link #getPartName(int)} will be called to get the name of each part file;</li>
 * <li>{@link #startWriting(File)}</li> will be called to notify start writing the current part file</li>
 * <li>{@link #readLine()} will be called for each line read;</li>
 * <li>{@link #canSplit(int, String)} will be called after each line read passing the line number and the content of that line;<br>
 * if it return <code>true</code> then:
 * <ul>
 * <li>{@link #stopWriting(File, PrintWriter)}</li> will be called to notify stop writing the current part file</li>
 * <li>{@link #startWriting(File)}</li> will be called to notify start writing the next part file</li>
 * </ul>
 * </li>
 * <li>{@link #stopReading(BufferedReader)} will be called when the file read has finished.</li>
 * <li>{@link #stopWriting(File, PrintWriter)}</li> will be called to notify stop writing the current part file</li>
 * </ol>
 * 
 * @author Ricardo Artur Staroski
 */
public interface FileSplitterModel {

    /**
     * Called by the {@link FileSplitter} to check if it should create a new part file after the given line was read.
     * 
     * @param line
     *            The number of the last line read.
     * 
     * @param content
     *            The content of the last line read.
     * 
     * @return <code>true</code> if a new part file should be created and <code>false</code> if not.
     * 
     * @throws Exception
     *             If something goes wrong.
     */
    public boolean canSplit(int line, String content) throws Exception;

    /**
     * Returna the name to give to the speficied part file.
     * 
     * @param number
     *            The number of the part file.
     * 
     * @return The name that file should have.
     */
    public String getPartName(int number);

    /**
     * Called by the {@link FileSplitter} to notify it is ready to initialize the splitting algorithm.
     * 
     * @param lines
     *            The total number of lines the input file has.
     * 
     * @param parts
     *            The number of parts the file should be splitted.
     */
    public void initialize(int lines, int parts);

    /**
     * Called by the {@link FileSplitter} to read a line of text from the input file.
     * 
     * @param reader
     *            The {@link BufferedReader} used to read the input file.
     * 
     * @return The line that was read or <t>null</t> if end of file reached.
     * 
     * @throws IOException
     *             If some I/O operation goes wrong.
     */
    public String readLine(BufferedReader reader) throws IOException;

    /**
     * Called by the {@link FileSplitter} to start reading the input file.
     * 
     * @return The {@link BufferedReader} used to read the content of input file.
     * 
     * @throws IOException
     *             If some I/O operation goes wrong.
     */
    public BufferedReader startReading() throws IOException;

    /**
     * Called by the {@link FileSplitter} to notify the start of writing on a part file.
     * 
     * @param partFile
     *            The part file itself.
     * 
     * @return The writer used to write data on the part file.
     * 
     * @throws IOException
     *             If some I/O operation goes wrong.
     */
    public PrintWriter startWriting(File partFile) throws IOException;

    /**
     * Called by the {@link FileSplitter} to stop reading the input file.
     * 
     * @param reader
     *            The reader used to read the input file.
     * 
     * @throws IOException
     *             If some I/O operation goes wrong.
     */
    public void stopReading(BufferedReader reader) throws IOException;

    /**
     * Called by the {@link FileSplitter} to notify the stop of writing on a part file.
     * 
     * @param partFile
     *            The part file itself.
     * 
     * @param writer
     *            The writer used to write data on the part file.
     * 
     * @throws IOException
     *             If some I/O operation goes wrong.
     */
    public void stopWriting(File partFile, PrintWriter writer) throws IOException;
}