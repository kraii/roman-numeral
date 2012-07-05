package romannumeral;

import java.util.*;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class RomanNumeralConverter {

	public int convertToInteger(String romanNumeral) {
		validateNumeral(romanNumeral);
		int total = 0;
		Numeral previousToken = Numeral.NULL;

		for (Character character : getCharactersReversed(romanNumeral)) {
			Numeral currentToken = Numeral.parse(character);
			total += negateIfSubtractive(currentToken, previousToken);

			previousToken = currentToken;
		}

		return total;
	}

	private List<Character> getCharactersReversed(String romanNumeral) {
		ImmutableList<Character> characters = Lists.charactersOf(romanNumeral);
		return characters.reverse();
	}

	private int negateIfSubtractive(Numeral currentToken, Numeral previousToken) {
		if (currentToken.smallerThan(previousToken)) {
			validateSubtractiveCombination(currentToken, previousToken);
			return currentToken.decimalValue * -1;
		} else
			return currentToken.decimalValue;
	}

	private void validateSubtractiveCombination(Numeral currentToken, Numeral previousToken) {
		if (!currentToken.canBeSubtractedFrom(previousToken)) {
			throw new InvalidNumeralException("Cannot apply subtractive principle to tokens %s%s",
					previousToken, currentToken);
		}
	}

	private void validateNumeral(String romanNumeral) {
		validateCountOfRepeatedI(romanNumeral);
		validateDIsNotRepeated(romanNumeral);
	}

	private void validateCountOfRepeatedI(String romanNumeral) {
		if (romanNumeral.contains("IIII"))
			throw new InvalidNumeralException("I Repeated too many times");
	}

	private void validateDIsNotRepeated(String romanNumeral) {
		if (romanNumeral.contains("DD"))
			throw new InvalidNumeralException("Should not use DD, should be C");
	}
}


