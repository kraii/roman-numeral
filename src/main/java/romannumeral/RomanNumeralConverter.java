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
	
	public int convertToInteger(String romanNumeral) {
		int total = 0;
		int previousTokenValue = 0;
		
		for(int i = romanNumeral.length() - 1; i >= 0; i--) { 
			int currentTokenValue = getValueAtPostion(romanNumeral, i);
			total += negateIfSubtractive(currentTokenValue, previousTokenValue);
			previousTokenValue = currentTokenValue;
		}
		
		return total;
	}
	
	private int getValueAtPostion(String romanNumeral, int position) {
		Character character = romanNumeral.charAt(position);
		return convertCharacterToInteger(character);
	}

	private int convertCharacterToInteger(Character romanNumeralCharacter) {
		Integer value = characterValues.get(romanNumeralCharacter);
		
		if(value == null) 
			throw new InvalidNumeralException();
		else 
			return value;
	}
	
	private int negateIfSubtractive(int currentTokenValue, int previousTokenValue) {
		if(currentTokenValue < previousTokenValue) 
			return currentTokenValue * -1; 
		else
			return currentTokenValue;
	}
}

@SuppressWarnings("serial")
class InvalidNumeralException extends RuntimeException {

}
