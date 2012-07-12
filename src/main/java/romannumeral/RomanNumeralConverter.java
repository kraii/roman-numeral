package romannumeral;

import java.util.*;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class RomanNumeralConverter {

	private String romanNumeral;

	private Numeral previousToken = Numeral.NULL;
	private int timeTokenRepeated = 1;

	public RomanNumeralConverter(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}

	public int convertToInteger() {
		int total = 0;
		for (Character character : getCharactersReversed(romanNumeral)) {
			Numeral currentToken = Numeral.parse(character);
			validateIfTokenRepeated(previousToken, currentToken);
			total += negateIfSubtractive(currentToken, previousToken);

			previousToken = currentToken;
		}

		return total;
	}

	private List<Character> getCharactersReversed(String romanNumeral) {
		ImmutableList<Character> characters = Lists.charactersOf(romanNumeral);
		return characters.reverse();
	}

	private void validateIfTokenRepeated(Numeral previousToken, Numeral currentToken) {
		if (previousToken == currentToken) {
			timeTokenRepeated++;
			validateRepeatedToken(currentToken);
		} else {
			timeTokenRepeated = 1;
		}
	}

	private void validateRepeatedToken(Numeral currentToken) {
		Numeral immediateHigherValueNumeral = currentToken.getImmediateHigherValueNumeral();
		validateNoTokenWithSameValueAsRepeatedTokens(currentToken, immediateHigherValueNumeral);
		validateNoAvailableSubtractiveOption(currentToken, immediateHigherValueNumeral);
	}

	private void validateNoTokenWithSameValueAsRepeatedTokens(Numeral currentToken, Numeral immediateHigherValueNumeral) {
		if (immediateHigherValueNumeral.decimalValue == currentToken.decimalValue * timeTokenRepeated) {
			throw new InvalidNumeralException("Should not repeat %s, instead use %s", currentToken,
					immediateHigherValueNumeral);
		}
	}

	private void validateNoAvailableSubtractiveOption(Numeral currentToken, Numeral immediateHigherValueNumeral) {
		if(timeTokenRepeated >= 4 &&  currentToken.canBeSubtractedFrom(immediateHigherValueNumeral)) {
			throw new InvalidNumeralException("Should not repeat %s, instead use %s%s", currentToken, currentToken,
					immediateHigherValueNumeral);
		}
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
			throw new InvalidNumeralException("Cannot apply subtractive principle to tokens %s%s", previousToken,
					currentToken);
		}
	}
}
