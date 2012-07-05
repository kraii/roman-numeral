package romannumeral;

enum Numeral {
	NULL(0),
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	int decimalValue;

	Numeral(int decimalValue) {
		this.decimalValue = decimalValue;
	}
	
	public static Numeral parse(Character numeral) {
		try {
			return valueOf(numeral.toString());
		}
		catch(IllegalArgumentException e) {
			throw new InvalidNumeralException("%s is an invalid numeral", numeral);
		}
	}

	public boolean smallerThan(Numeral otherToken) {
		return decimalValue < otherToken.decimalValue;
	}
	
	public boolean canBeSubtractedFrom(Numeral otherToken) {
		int quotient = otherToken.decimalValue / decimalValue;
		int orderOfMagnitude = deriveOrderOfMagnitude(quotient);
		return orderOfMagnitude == 1 || quotient == 10;
	}

	private int deriveOrderOfMagnitude(int quotient) {
		int nonNegativeQuotient = Math.abs(quotient);
		return String.valueOf(nonNegativeQuotient).length();
	}
}
