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

	public static Gender parse(String genderText) {
		Gender result = null;
		if(genderText != null && !genderText.isEmpty()) {
			for(Gender value : Gender.values()) {
				if(genderText.charAt(0) == value.gender) {
					result = value;
					break;
				}
			}
		}
		return result;
	}
}