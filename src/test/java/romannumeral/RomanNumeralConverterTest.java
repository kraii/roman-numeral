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
		assertThat(romanNumeralConverter.convertToInteger("I"), is(1));
	}
	
	@Test
	public void II_gives_2() {
		assertThat(romanNumeralConverter.convertToInteger("II"), is(2));
	}
	
	@Test
	public void V_gives_5() {
		assertThat(romanNumeralConverter.convertToInteger("V"), is(5));
	}
	
	@Test
	public void X_gives_10() {
		assertThat(romanNumeralConverter.convertToInteger("X"), is(10));
	}
	
	@Test
	public void L_gives_50() {
		assertThat(romanNumeralConverter.convertToInteger("L"), is(50));
	}
	
	@Test
	public void C_gives_100() {
		assertThat(romanNumeralConverter.convertToInteger("C"), is(100));
	}
	
	@Test
	public void D_gives_500() {
		assertThat(romanNumeralConverter.convertToInteger("D"), is(500));
	}

	@Test
	public void M_gives_1000() {
		assertThat(romanNumeralConverter.convertToInteger("M"), is(1000));
	}
	
	@Test
	public void IV_gives_4() {
		assertThat(romanNumeralConverter.convertToInteger("IV"), is(4));
	}
	
	@Test
	public void IX_gives_9() {
		assertThat(romanNumeralConverter.convertToInteger("IX"), is(9));
	}
	
	@Test
	public void MCMXCV_gives_1995() {
		assertThat(romanNumeralConverter.convertToInteger("MCMXCV"), is(1995));
	}
	
	@Test
	public void XXXIX_give_39() {
		assertThat(romanNumeralConverter.convertToInteger("XXXIX"), is(39));
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception() {
		romanNumeralConverter.convertToInteger("Z");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception_when_there_is_valid_numerals() {
		romanNumeralConverter.convertToInteger("MCMXCVA");
	}
	
	@Test(expected=InvalidNumeralException.class) 
	public void IIII_is_invalid() {
		romanNumeralConverter.convertToInteger("IIII");
	}
	
	@Test(expected=InvalidNumeralException.class) 
	public void IIIII_is_invalid() {
		romanNumeralConverter.convertToInteger("IIIII");
	}
	
	@Test(expected=InvalidNumeralException.class) 
	public void DD_is_invalid() {
		romanNumeralConverter.convertToInteger("DD");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void IM_is_invalid() {
		romanNumeralConverter.convertToInteger("IM");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void IC_is_invalid() {
		romanNumeralConverter.convertToInteger("IC");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void LM_is_invalid() {
		romanNumeralConverter.convertToInteger("LM");
	}
}
