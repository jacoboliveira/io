package br.com.staroski.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * Classe utilitária para ler entrada de dados pelo teclado e escrever na saída padrão do sistema.
 */
public final class StdIO {

    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BOOLEAN = "boolean";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_INT = "int";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_STRING = "String";

    private static final String PREDICATE_FAILED = "não atende ao predicado informado!";
    private static final String INVALID = "não é válido!";

    // não estou utilizando Scanner pois ele não é legal para ler entrada de dados a partir do teclado
    // o Scanner não consome a quebra de linha ao presionar ENTER e isso gera comportamentos indesejados
    private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintStream OUT = System.out;

    public static void print(boolean value) {
        OUT.print(value);
    }

    public static void print(char value) {
        OUT.print(value);
    }

    public static void print(char[] chars) {
        OUT.print(chars);
    }

    public static void print(double value) {
        OUT.print(value);
    }

    public static void print(float value) {
        OUT.print(value);
    }

    public static void print(int value) {
        OUT.print(value);
    }

    public static void print(long value) {
        OUT.print(value);
    }

    public static void print(Object object) {
        OUT.print(object);
    }

    public static void print(String text) {
        OUT.print(text);
    }

    public static PrintStream printf(Locale locale, String format, Object... args) {
        return OUT.printf(locale, format, args);
    }

    public static PrintStream printf(String format, Object... args) {
        return OUT.printf(format, args);
    }

    public static void println() {
        OUT.println();
    }

    public static void println(boolean value) {
        OUT.println(value);
    }

    public static void println(char value) {
        OUT.println(value);
    }

    public static void println(char[] value) {
        OUT.println(value);
    }

    public static void println(double value) {
        OUT.println(value);
    }

    public static void println(float value) {
        OUT.println(value);
    }

    public static void println(int value) {
        OUT.println(value);
    }

    public static void println(long value) {
        OUT.println(value);
    }

    public static void println(Object object) {
        OUT.println(object);
    }

    public static void println(String text) {
        OUT.println(text);
    }

    public static boolean readBoolean() {
        while (true) {
            try {
                return Boolean.parseBoolean(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static boolean readBoolean(Predicate<Boolean> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                boolean value = Boolean.parseBoolean(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_BOOLEAN, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_BOOLEAN, line, INVALID);
            }
        }
    }

    public static boolean readBoolean(String message) {
        while (true) {
            try {
                print(message);
                return Boolean.parseBoolean(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static boolean readBoolean(String message, Predicate<Boolean> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                boolean value = Boolean.parseBoolean(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_BOOLEAN, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_BOOLEAN, line, INVALID);
            }
        }
    }

    public static byte readByte() {
        while (true) {
            try {
                return Byte.parseByte(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static byte readByte(Predicate<Byte> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                byte value = Byte.parseByte(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_BYTE, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_BYTE, line, INVALID);
            }
        }
    }

    public static byte readByte(String message) {
        while (true) {
            try {
                print(message);
                return Byte.parseByte(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static byte readByte(String message, Predicate<Byte> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                byte value = Byte.parseByte(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_BYTE, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_BYTE, line, INVALID);
            }
        }
    }

    public static char readChar() {
        while (true) {
            try {
                return IN.readLine().charAt(0);
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static char readChar(Predicate<Character> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine().substring(0, 1);
                char value = line.charAt(0);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_CHAR, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_CHAR, line, INVALID);
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            try {
                print(message);
                return IN.readLine().charAt(0);
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static char readChar(String message, Predicate<Character> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine().substring(0, 1);
                char value = line.charAt(0);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_CHAR, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_CHAR, line, INVALID);
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static double readDouble(Predicate<Double> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                double value = Double.parseDouble(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_DOUBLE, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_DOUBLE, line, INVALID);
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                print(message);
                return Double.parseDouble(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static double readDouble(String message, Predicate<Double> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                double value = Double.parseDouble(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_DOUBLE, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_DOUBLE, line, INVALID);
            }
        }
    }

    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static float readFloat(Predicate<Float> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                float value = Float.parseFloat(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_FLOAT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_FLOAT, line, INVALID);
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            try {
                print(message);
                return Float.parseFloat(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static float readFloat(String message, Predicate<Float> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                float value = Float.parseFloat(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_FLOAT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_FLOAT, line, INVALID);
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static int readInt(Predicate<Integer> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                int value = Integer.parseInt(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_INT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_INT, line, INVALID);
            }
        }
    }

    public static int readInt(String message) {
        while (true) {
            try {
                print(message);
                return Integer.parseInt(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static int readInt(String message, Predicate<Integer> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                int value = Integer.parseInt(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_INT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_INT, line, INVALID);
            }
        }
    }

    public static long readLong() {
        while (true) {
            try {
                return Long.parseLong(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static long readLong(Predicate<Long> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                long value = Long.parseLong(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_LONG, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_LONG, line, INVALID);
            }
        }
    }

    public static long readLong(String message) {
        while (true) {
            try {
                print(message);
                return Long.parseLong(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static long readLong(String message, Predicate<Long> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                long value = Long.parseLong(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_LONG, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_LONG, line, INVALID);
            }
        }
    }

    public static short readShort() {
        while (true) {
            try {
                return Short.parseShort(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static short readShort(Predicate<Short> predicate) {
        while (true) {
            String line = null;
            try {
                line = IN.readLine();
                short value = Short.parseShort(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_SHORT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_SHORT, line, INVALID);
            }
        }
    }

    public static short readShort(String message) {
        while (true) {
            try {
                print(message);
                return Short.parseShort(IN.readLine());
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static short readShort(String message, Predicate<Short> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                short value = Short.parseShort(line);
                if (predicate.test(value)) {
                    return value;
                }
                showMessage(TYPE_SHORT, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_SHORT, line, INVALID);
            }
        }
    }

    public static String readString() {
        while (true) {
            try {
                return IN.readLine();
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static String readString(Predicate<String> predicate) {
        while (true) {
            String line = null;
            try {

                line = IN.readLine();
                if (predicate.test(line)) {
                    return line;
                }
                showMessage(TYPE_STRING, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_STRING, line, INVALID);
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                print(message);
                return IN.readLine();
            } catch (IOException ioe) {
                throw wrap(ioe);
            }
        }
    }

    public static String readString(String message, Predicate<String> predicate) {
        while (true) {
            String line = null;
            try {
                print(message);
                line = IN.readLine();
                if (predicate.test(line)) {
                    return line;
                }
                showMessage(TYPE_STRING, line, PREDICATE_FAILED);
            } catch (IOException ioe) {
                throw wrap(ioe);
            } catch (Exception e) {
                showMessage(TYPE_STRING, line, INVALID);
            }
        }
    }

    private static void showMessage(String type, String value, String message) {
        println("Valor \"" + value + "\" do tipo " + type + " " + message);
    }

    private static RuntimeException wrap(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        }
        return new RuntimeException(t.getLocalizedMessage(), t);
    }

    private StdIO() {}
}
