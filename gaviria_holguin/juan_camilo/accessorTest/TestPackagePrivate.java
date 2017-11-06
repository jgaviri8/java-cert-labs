public class TestPackagePrivate {
  public static void main(String... args) {
    my_package.MyClass object = new my_package.MyClass();
    System.out.format("%s%n", object.charProperty);
  }
}
