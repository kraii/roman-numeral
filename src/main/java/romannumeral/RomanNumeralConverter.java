package romannumeral;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
	
	private Map<Character, Integer> characterValues;
	
	public RomanNumeralConverter() {
		initialiseCharacterValues();
	}
	
	private void initialiseCharacterValues() {
		characterValues = new HashMap<Character, Integer>();
		characterValues.put('I', 1);
		characterValues.put('V', 5);
		characterValues.put('X', 10);
		characterValues.put('L', 50);
		characterValues.put('C', 100);
		characterValues.put('D', 500);
		characterValues.put('M', 1000);
	}
	
	public int convert(String romanNumeral) {
		int total = 0;
		int previousValue = 0;
		for(int i = romanNumeral.length() - 1; i >= 0; i--) { 
			Character character = romanNumeral.charAt(i);
			int currentValue = convertCharacter(character);

			if(currentValue < previousValue) 
				total -= currentValue; 
			else 
				total += currentValue;
			
			previousValue = currentValue;
		}
		
		return total;
	}

	private int convertCharacter(Character romanNumeralCharacter) {
		Integer value = characterValues.get(romanNumeralCharacter);
		
		if(value == null) 
			throw new InvalidNumeralException();
		else 
			return value;
	}
}

@SuppressWarnings("serial")
class InvalidNumeralException extends RuntimeException {

}
