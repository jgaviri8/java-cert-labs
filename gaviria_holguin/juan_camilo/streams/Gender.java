package streams;

public enum Gender {
	MALE('M'),
	FEMALE('F');
	
	private char gender;
	
	private Gender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}
}