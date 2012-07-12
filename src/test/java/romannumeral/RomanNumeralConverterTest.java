package romannumeral;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class RomanNumeralConverterTest {
	
	private int convertNumeral(String numeral) {
		return new RomanNumeralConverter(numeral).convertToInteger();
	}

	@Test
	public void I_gives_1() {
		assertThat(convertNumeral("I"), is(1));
	}

	@Test
	public void II_gives_2() {
		assertThat(convertNumeral("II"), is(2));
	}

	@Test
	public void V_gives_5() {
		assertThat(convertNumeral("V"), is(5));
	}

	@Test
	public void X_gives_10() {
		assertThat(convertNumeral("X"), is(10));
	}

	@Test
	public void L_gives_50() {
		assertThat(convertNumeral("L"), is(50));
	}

	@Test
	public void C_gives_100() {
		assertThat(convertNumeral("C"), is(100));
	}

	@Test
	public void D_gives_500() {
		assertThat(convertNumeral("D"), is(500));
	}

	@Test
	public void M_gives_1000() {
		assertThat(convertNumeral("M"), is(1000));
	}

	@Test
	public void MMM_gives_3000() {
		assertThat(convertNumeral("MMM"), is(3000));
	}

	@Test
	public void IV_gives_4() {
		assertThat(convertNumeral("IV"), is(4));
	}

	@Test
	public void IX_gives_9() {
		assertThat(convertNumeral("IX"), is(9));
	}

	@Test
	public void MCMXCV_gives_1995() {
		assertThat(convertNumeral("MCMXCV"), is(1995));
	}

	@Test
	public void XXXIX_give_39() {
		assertThat(convertNumeral("XXXIX"), is(39));
	}

	@Test(expected = InvalidNumeralException.class)
	public void invalidNumeral_gives_exception() {
		convertNumeral("Z");
	}

	@Test(expected = InvalidNumeralException.class)
	public void invalidNumeral_gives_exception_when_there_is_valid_numerals() {
		convertNumeral("MCMXCVA");
	}

	@Test(expected = InvalidNumeralException.class)
	public void IIII_is_invalid() {
		convertNumeral("IIII");
	}

	@Test(expected = InvalidNumeralException.class)
	public void IIIII_is_invalid() {
		convertNumeral("IIIII");
	}

	@Test(expected = InvalidNumeralException.class)
	public void DD_is_invalid() {
		convertNumeral("DD");
	}

	@Test(expected = InvalidNumeralException.class)
	public void LM_is_invalid() {
		convertNumeral("LM");
	}

	@Test(expected = InvalidNumeralException.class)
	public void V_cannotBeRepeated() {
		convertNumeral("VV");
	}

	@Test
	public void CCC_is_300() {
		assertThat(convertNumeral("CCC"), is(300));
	}

	@Test(expected = InvalidNumeralException.class)
	public void CCCC_is_invalid() {
		convertNumeral("CCCC");
	}

	@Test
	public void XLIX_is_49() {
		assertThat(convertNumeral("XLIX"), is(49));
	}
}
