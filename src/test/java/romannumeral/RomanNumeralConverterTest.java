package romannumeral;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RomanNumeralConverterTest {
	
	@Test
	public void I_gives_1() {
		assertThat(RomanNumeralConverter.convert("I"), is(1));
	}

}
