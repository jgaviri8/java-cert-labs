package streams.dtos;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;
import streams.Gender;

public class EmployeeDto {
	private LocalDate birthDate;
	private String cellPhoneNumber;
	private BigDecimal salary;
	private String name;
	private Gender gender;
	private String city;
	
	public EmployeeDto() {
		birthDate = LocalDate.MIN;
		cellPhoneNumber = "";
		salary = BigDecimal.ZERO;
		name = "";
		gender = Gender.MALE;
		city = "";
	}
	
	public EmployeeDto setBirthDate(LocalDate birthDate) {
		EmployeeDto result = createCopy();
		result.birthDate = birthDate != null ? birthDate.plus(0L, ChronoUnit.DAYS) : LocalDate.MIN;
		return result; 
	}
	
	public EmployeeDto setCellPhoneNumber(String cellPhoneNumber) {
		EmployeeDto result = createCopy();
		result.cellPhoneNumber = cellPhoneNumber != null ? cellPhoneNumber : "";
		return result; 
	}
	
	public EmployeeDto setSalary(BigDecimal salary) {
		EmployeeDto result = createCopy();
		result.salary = salary != null ? salary.multiply(BigDecimal.ONE) : BigDecimal.ZERO;
		return result;
	}
	
	public EmployeeDto setName(String name) {
		EmployeeDto result = createCopy();
		result.name = name != null ? name : "";
		return result; 
	}
	
	public EmployeeDto setGender(Gender gender) {
		EmployeeDto result = createCopy();
		result.gender = gender != null ? gender : Gender.MALE;
		return result; 
	}
	
	public EmployeeDto setCity(String city) {
		EmployeeDto result = createCopy();
		result.city = city != null ? city : "";
		return result; 
	}
	
	public LocalDate getBirthDate() {
		return birthDate.plus(0L, ChronoUnit.DAYS);
	}
	
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	
	public BigDecimal getSalary() {
		return salary.multiply(BigDecimal.ONE);
	}
	
	public String getName() {
		return name;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String getCity() {
		return city;
	}
	
	private EmployeeDto createCopy() {
		EmployeeDto result = new EmployeeDto();
		result.birthDate = this.birthDate.plus(0L, ChronoUnit.DAYS);
		result.cellPhoneNumber = this.cellPhoneNumber;
		result.salary = this.salary.multiply(BigDecimal.ONE);
		result.name = this.name;
		result.gender = this.gender;
		result.city = this.city;
		return result;
	}

	@Override
	public String toString() {
		return birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE) +
		  ", " + cellPhoneNumber + ", " + salary.toString() + ", " +
		  name + ", " + gender.getGender() + ", " + city; 
	}
}