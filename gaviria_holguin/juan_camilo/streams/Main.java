package streams;

import java.util.List;
import streams.dao.*;
import streams.dtos.EmployeeDto;

public class Main {
  public static void main(String... args) {
    EmployeeSource source = new EmployeeCSVFileSource();
    List<EmployeeDto> employeesList = source.readAllEmployees();
    for(EmployeeDto employee : employeesList) {
      System.out.printf("%s%n", employee);
    }
  }
}