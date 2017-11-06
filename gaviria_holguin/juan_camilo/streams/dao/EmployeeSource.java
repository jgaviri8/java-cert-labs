package streams.dao;

import java.util.List;
import streams.dtos.EmployeeDto;

public interface EmployeeSource {
	List<EmployeeDto> readAllEmployees();
}