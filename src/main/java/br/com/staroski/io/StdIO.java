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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean readBoolean(Predicate<Boolean> predicate) {
        while (true) {
            try {
                boolean value = Boolean.parseBoolean(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor boolean não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor boolean inválido!");
            }
        }
    }

    public static boolean readBoolean(String message) {
        while (true) {
            try {
                print(message);
                return Boolean.parseBoolean(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean readBoolean(String message, Predicate<Boolean> predicate) {
        while (true) {
            try {
                print(message);
                boolean value = Boolean.parseBoolean(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor boolean não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor boolean inválido!");
            }
        }
    }

    public static byte readByte() {
        while (true) {
            try {
                return Byte.parseByte(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte readByte(Predicate<Byte> predicate) {
        while (true) {
            try {
                byte value = Byte.parseByte(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor byte não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor byte inválido!");
            }
        }
    }

    public static byte readByte(String message) {
        while (true) {
            try {
                print(message);
                return Byte.parseByte(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte readByte(String message, Predicate<Byte> predicate) {
        while (true) {
            try {
                print(message);
                byte value = Byte.parseByte(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor byte não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor byte inválido!");
            }
        }
    }

    public static char readChar() {
        while (true) {
            try {
                return IN.readLine().charAt(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static char readChar(Predicate<Character> predicate) {
        while (true) {
            try {
                char value = IN.readLine().charAt(0);
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor char não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor char inválido!");
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            try {
                print(message);
                return IN.readLine().charAt(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static char readChar(String message, Predicate<Character> predicate) {
        while (true) {
            try {
                print(message);
                char value = IN.readLine().charAt(0);
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor char não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor char inválido!");
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static double readDouble(Predicate<Double> predicate) {
        while (true) {
            try {
                double value = Double.parseDouble(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor double não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor double inválido!");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                print(message);
                return Double.parseDouble(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static double readDouble(String message, Predicate<Double> predicate) {
        while (true) {
            try {
                print(message);
                double value = Double.parseDouble(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor double não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor double inválido!");
            }
        }
    }

    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static float readFloat(Predicate<Float> predicate) {
        while (true) {
            try {
                float value = Float.parseFloat(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor float não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor float inválido!");
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            try {
                print(message);
                return Float.parseFloat(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static float readFloat(String message, Predicate<Float> predicate) {
        while (true) {
            try {
                print(message);
                float value = Float.parseFloat(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor float não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor float inválido!");
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int readInt(Predicate<Integer> predicate) {
        while (true) {
            try {
                int value = Integer.parseInt(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor inválido!");
            } catch (Exception e) {
                println("Valor inválido!");
            }
        }
    }

    public static int readInt(String message) {
        while (true) {
            try {
                print(message);
                return Integer.parseInt(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int readInt(String message, Predicate<Integer> predicate) {
        while (true) {
            try {
                print(message);
                int value = Integer.parseInt(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor int não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor int inválido!");
            }
        }
    }

    public static long readLong() {
        while (true) {
            try {
                return Long.parseLong(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static long readLong(Predicate<Long> predicate) {
        while (true) {
            try {
                long value = Long.parseLong(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor long não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor long inválido!");
            }
        }
    }

    public static long readLong(String message) {
        while (true) {
            try {
                print(message);
                return Long.parseLong(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static long readLong(String message, Predicate<Long> predicate) {
        while (true) {
            try {
                print(message);
                long value = Long.parseLong(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor long não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor long inválido!");
            }
        }
    }

    public static short readShort() {
        while (true) {
            try {
                return Short.parseShort(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static short readShort(Predicate<Short> predicate) {
        while (true) {
            try {
                short value = Short.parseShort(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor short não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor short inválido!");
            }
        }
    }

    public static short readShort(String message) {
        while (true) {
            try {
                print(message);
                return Short.parseShort(IN.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static short readShort(String message, Predicate<Short> predicate) {
        while (true) {
            try {
                print(message);
                short value = Short.parseShort(IN.readLine());
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor short não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor short inválido!");
            }
        }
    }

    public static String readString() {
        while (true) {
            try {
                return IN.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readString(Predicate<String> predicate) {
        while (true) {
            try {
                String value = IN.readLine();
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor String não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor String inválido!");
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                print(message);
                return IN.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readString(String message, Predicate<String> predicate) {
        while (true) {
            try {
                print(message);
                String value = IN.readLine();
                if (predicate.test(value)) {
                    return value;
                }
                println("Valor String não atende ao predicado informado!");
            } catch (Exception e) {
                println("Valor String inválido!");
            }
        }
    }

    private StdIO() {}
}
