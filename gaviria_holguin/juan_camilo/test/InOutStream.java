package gaviria_holguin.juan_camilo.test;

import java.io.*;

public class InOutStream {

    private void writeBytesStream() {
        try (FileOutputStream stream = new FileOutputStream("byteOutput.dat")) {
            stream.write(1);
            stream.write(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCharacterStream() {
        try (FileWriter stream = new FileWriter("characterOutput.txt")) {
            stream.write("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBytesBufferedStream() {
        try (BufferedOutputStream stream =
                     new BufferedOutputStream(new FileOutputStream("byteBufferedOutput.dat"))) {
            stream.write(new byte[]{1, 2, 3, 4, 5, 92});
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCharactersBufferedStream() {
        try (BufferedWriter stream = new BufferedWriter(new FileWriter("characterBufferedOutput.txt"))) {
            stream.write("test dos");
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDataStream() {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream("dataOutput.dat"))) {
            stream.writeByte(Byte.MAX_VALUE);
            stream.writeBoolean(true);
            stream.writeChar(Character.MAX_VALUE);
            stream.writeShort(Short.MAX_VALUE);
            stream.writeInt(Integer.MAX_VALUE);
            stream.writeLong(Long.MAX_VALUE);
            stream.writeFloat(Float.MAX_VALUE);
            stream.writeDouble(Double.MAX_VALUE);
            stream.writeUTF("hola");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeObjectStream() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("objectOutput.dat"))) {
            stream.writeObject(new TestSerializable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBytesStream(Console console) {
        try (FileInputStream stream = new FileInputStream("byteOutput.dat")) {
            console.format("Byte 1 %d, Byte 2 %d%n", stream.read(), stream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCharacterStream(Console console) {
        try (FileReader stream = new FileReader("characterOutput.txt")) {
            int character;
            while((character = stream.read()) != -1) {
                console.format("%c", character);
            }
            console.format("%n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBytesBufferedStream(Console console) {
        try (BufferedInputStream stream =
                     new BufferedInputStream(new FileInputStream("byteBufferedOutput.dat"))) {
            int _byte;
            while((_byte = stream.read()) != -1) {
                console.format("%d", _byte);
            }
            console.format("%n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCharacterBufferedStream(Console console) {
        try (BufferedReader stream = new BufferedReader(new FileReader("characterBufferedOutput.txt"))) {
            String line;
            while((line = stream.readLine()) != null) {
                console.format("%s", line);
            }
            console.format("%n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataStream(Console console) {
        try(DataInputStream stream = new DataInputStream(new FileInputStream("dataOutput.dat"))) {
            console.format("byte: %d, boolean %b, char: %c, short: %d, int: %d, long: %d, float: %a, double: %a," +
                            " String: %s%n", stream.readByte(), stream.readBoolean(), stream.readChar(),
                    stream.readShort(), stream.readInt(), stream.readLong(), stream.readFloat(), stream.readDouble(),
                    stream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObjectStream(Console console) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("objectOutput.dat"))) {
            TestSerializable object = (TestSerializable) stream.readObject();
            console.format("%s%n", object.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        Console console = System.console();
        if (console == null) {
            System.out.format("No hay consola asociada a esta máquina virtual%n");
        } else {
            InOutStream inOutStream = new InOutStream();
            inOutStream.writeBytesStream();
            inOutStream.writeCharacterStream();
            inOutStream.writeBytesBufferedStream();
            inOutStream.writeCharactersBufferedStream();
            inOutStream.writeDataStream();
            inOutStream.writeObjectStream();
            inOutStream.readBytesStream(console);
            inOutStream.readCharacterStream(console);
            inOutStream.readBytesBufferedStream(console);
            inOutStream.readCharacterBufferedStream(console);
            inOutStream.readDataStream(console);
            inOutStream.readObjectStream(console);
        }
    }
}
