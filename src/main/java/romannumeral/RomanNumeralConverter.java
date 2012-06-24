package romannumeral;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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
		
		for(Character character : getCharactersReversed(romanNumeral)) { 
			int currentTokenValue = convertCharacterToInteger(character);
			total += negateIfSubtractive(currentTokenValue, previousTokenValue);
			previousTokenValue = currentTokenValue;
		}
		
		return total;
	}

	private ImmutableList<Character> getCharactersReversed(String romanNumeral) {
		return Lists.charactersOf(romanNumeral).reverse();
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
