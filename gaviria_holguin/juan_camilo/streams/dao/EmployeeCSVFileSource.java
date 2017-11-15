package streams.dao;

import java.io.BufferedReader;
import java.nio.charset.Charset
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import streams.dtos.EmployeeDto;

public class EmployeeCSVFileSource implements EmployeeSource {
	public List<EmployeeDto> readAllEmployees() {
		List<EmployeeDto> result = new ArrayList<EmployeeDto>();
		final String fileSeparator = System.getProperty("file.separator");
		Path file = Paths.get("." + fileSeparator + "empleados.csv");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ioe) {
			System.err.format("IOException: %s%n", ioe);
		}
		return result;
	}
}