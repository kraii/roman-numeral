package romannumeral;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RomanNumeralConverterTest {
	
	@Test
	public void I_gives_1() {
		assertThat(RomanNumeralConverter.convert("I"), is(1));
	}
	
	@Test
	public void II_gives_2() {
		assertThat(RomanNumeralConverter.convert("II"), is(2));
	}
	
	@Test
	public void V_gives_5() {
		assertThat(RomanNumeralConverter.convert("V"), is(5));
	}
	
	@Test
	public void X_gives_10() {
		assertThat(RomanNumeralConverter.convert("X"), is(10));
	}
	
	@Test
	public void L_gives_50() {
		assertThat(RomanNumeralConverter.convert("L"), is(50));
	}
	
	@Test
	public void C_gives_100() {
		assertThat(RomanNumeralConverter.convert("C"), is(100));
	}
	
	@Test
	public void D_gives_500() {
		assertThat(RomanNumeralConverter.convert("D"), is(500));
	}

	@Test
	public void M_gives_1000() {
		assertThat(RomanNumeralConverter.convert("M"), is(1000));
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception() {
		RomanNumeralConverter.convert("Z");
	}
}
