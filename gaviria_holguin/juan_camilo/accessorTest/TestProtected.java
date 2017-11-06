public class TestProtected extends MyClass {
  private String getStringProperty() {
    MyClass object = new MyClass();
    return object.stringProperty;
  }

  public static void main(String... args) {
    TestProtected object = new TestProtected();
    System.out.format("%s%n", object.getStringProperty());
  }
}
