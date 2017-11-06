public class TestPrivate extends MyClass {
  private byte byteProperty = 0b00000010; 
  public static void main(String... args) {
    TestPrivate object = new TestPrivate();
    System.out.format("%s - %d%n", object.property, object.byteProperty);
  }
}
