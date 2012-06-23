package romannumeral;

public class RomanNumeralConverter {

	public static int convert(String romanNumeral) {
		int total = 0;
		for(int i = 0; i < romanNumeral.length(); i++) { 
			String character = String.valueOf(romanNumeral.charAt(i));
			total += convertCharacter(character);
		}
		
		return total;
	}

	private static int convertCharacter(String romanNumeral) {
		switch (romanNumeral) {
		case "I":
			return 1;
		case "V":
			return 5;
		case "X":
			return 10;
		case "L":
			return 50;
		case "C":
			return 100;
		case "D":
			return 500;
		case "M":
			return 1000;
		}

		throw new InvalidNumeralException();
	}
}

@SuppressWarnings("serial")
class InvalidNumeralException extends RuntimeException {

}
