package gaviria_holguin.juan_camilo.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    private ListOfNumbers() {
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    private void writeList(){
        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"))){
            System.out.printf("Entered try statement%n");
            for (int i = 0; i < SIZE; i++) {
                out.printf("Value at %d = %d%n", i, list.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.printf("IndexOutOfBoundsException: %s%n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("Caught IOException: %s%n", e.getMessage());
        }
    }

    public static void main(String... args) {
        new ListOfNumbers().writeList();
    }
}
