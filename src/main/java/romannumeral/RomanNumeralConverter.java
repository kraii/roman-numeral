package romannumeral;

import java.util.*;

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
		validateNumeral(romanNumeral);
		int total = 0;
		int previousTokenValue = 0;
		
		for(Character character : getCharactersReversed(romanNumeral)) { 
			int currentTokenValue = convertCharacterToInteger(character);
			total += negateIfSubtractive(currentTokenValue, previousTokenValue);
			
			previousTokenValue = currentTokenValue;
		}
		
		return total;
	}

	private List<Character> getCharactersReversed(String romanNumeral) {
		ImmutableList<Character> characters = Lists.charactersOf(romanNumeral);
		return characters.reverse();
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
	
	private void validateNumeral(String romanNumeral) {
		validateCountOfRepeatedI(romanNumeral);
		validateDIsNotRepeated(romanNumeral);
	}

	private void validateCountOfRepeatedI(String romanNumeral) {
		if(romanNumeral.contains("IIII")) {
			throw new InvalidNumeralException("I Repeated too many times");
		}
	}
	
	private void validateDIsNotRepeated(String romanNumeral) {
		if(romanNumeral.contains("DD")) {
			throw new InvalidNumeralException("Should not use DD, should be C");
		}
	}
}

@SuppressWarnings("serial")
class InvalidNumeralException extends RuntimeException {
	public InvalidNumeralException() {
		super();
	}
	
	public InvalidNumeralException(String message) {
		super(message);
	}
}
