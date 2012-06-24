package romannumeral;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RomanNumeralConverterTest {
	
	private RomanNumeralConverter romanNumeralConverter;
	
	@Before
	public void beforeTest() {
		romanNumeralConverter = new RomanNumeralConverter();
	}
	
	@Test
	public void I_gives_1() {
		assertThat(romanNumeralConverter.convert("I"), is(1));
	}
	
	@Test
	public void II_gives_2() {
		assertThat(romanNumeralConverter.convert("II"), is(2));
	}
	
	@Test
	public void V_gives_5() {
		assertThat(romanNumeralConverter.convert("V"), is(5));
	}
	
	@Test
	public void X_gives_10() {
		assertThat(romanNumeralConverter.convert("X"), is(10));
	}
	
	@Test
	public void L_gives_50() {
		assertThat(romanNumeralConverter.convert("L"), is(50));
	}
	
	@Test
	public void C_gives_100() {
		assertThat(romanNumeralConverter.convert("C"), is(100));
	}
	
	@Test
	public void D_gives_500() {
		assertThat(romanNumeralConverter.convert("D"), is(500));
	}

	@Test
	public void M_gives_1000() {
		assertThat(romanNumeralConverter.convert("M"), is(1000));
	}
	
	@Test
	public void IV_gives_4() {
		assertThat(romanNumeralConverter.convert("IV"), is(4));
	}
	
	@Test
	public void MCMXCV_gives_1995() {
		assertThat(romanNumeralConverter.convert("MCMXCV"), is(1995));
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception() {
		romanNumeralConverter.convert("Z");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception_when_there_is_valid_numerals() {
		romanNumeralConverter.convert("MCMXCVA");
	}
}
