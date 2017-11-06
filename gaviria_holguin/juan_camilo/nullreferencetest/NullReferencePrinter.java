package nullreferencetest;

public class NullReferencePrinter {
  public static void main(String... args) {
    String word1 = null;
    String word2 = null;
    System.out.format("%s - %s%n", word1, word2);
  }
}
