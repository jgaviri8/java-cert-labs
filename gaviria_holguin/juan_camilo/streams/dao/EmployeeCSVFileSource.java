package streams.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import streams.dtos.EmployeeDto;
import streams.Gender;

public class EmployeeCSVFileSource implements EmployeeSource {
	public List<EmployeeDto> readAllEmployees() {
		List<EmployeeDto> result = new ArrayList<EmployeeDto>();
		final String fileSeparator = System.getProperty("file.separator");
		Path file = Paths.get("." + fileSeparator + "empleados.csv");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while((line = reader.readLine()) != null) {
				Scanner scanner = new Scanner(line).useDelimiter(",");
				LocalDate birthDate = LocalDate.parse(scanner.next());
				String cellPhoneNumber = scanner.next();
				BigDecimal salary = new BigDecimal(scanner.next());
				String name = scanner.next();
				String city = scanner.next();
				Gender gender = Gender.parse(scanner.next());
				result.add(new EmployeeDto().setBirthDate(birthDate)
				    .setCellPhoneNumber(cellPhoneNumber)
				    .setSalary(salary)
				    .setName(name)
				    .setCity(city)
				    .setGender(gender));
			}
		} catch (IOException ioe) {
			System.err.format("IOException: %s%n", ioe);
		}
		return result;
	}
}