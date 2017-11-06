package passbyvalue;

public class ObjectPassTest {
  public void foo(Employee e) {
    e.setSalary(130_000.00);
    e = new Employee();
    e.setSalary(140_000.00);
  }

  public static void main(String... args) {
    ObjectPassTest test = new ObjectPassTest();
    Employee x = new Employee();
    x.setSalary(120_000.00);
    test.foo(x);
    System.out.printf("Employee salary: %f%n", x.getSalary());
  }
}
