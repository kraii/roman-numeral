package romannumeral;

import org.junit.Test;
import static romannumeral.Numeral.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumeralTest {
	
	@Test
	public void canParseI() {
		assertThat(Numeral.parse('I'), is(I));
	}
	
	@Test
	public void canParseV() {
		assertThat(Numeral.parse('V'), is(V));
	}
	
	@Test
	public void canParseX() {
		assertThat(Numeral.parse('X'), is(X));
	}
	
	@Test
	public void canParseL() {
		assertThat(Numeral.parse('L'), is(L));
	}
	
	@Test
	public void canParseC() {
		assertThat(Numeral.parse('C'), is(C));
	}
	
	@Test
	public void canParseD() {
		assertThat(Numeral.parse('D'), is(D));
	}
	
	@Test
	public void canParseM() {
		assertThat(Numeral.parse('M'), is(M));
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void invalidNumeral_gives_exception() {
		Numeral.parse('B');
	}
	
	@Test
	public void ISmallerThanV() {
		assertThat(I.smallerThan(V), is(true));
	}
	
	@Test
	public void ICanBeSubtractedFromV() {
		assertThat(I.canBeSubtractedFrom(V), is(true));
	}
	
	@Test
	public void ICanBeSubtractedFromX() {
		assertThat(I.canBeSubtractedFrom(X), is(true));
	}
	
	@Test
	public void ICannotBeSubtractedFromM() {
		assertThat(I.canBeSubtractedFrom(M), is(false));
	}
	
	@Test
	public void C_CanBeSubtractedFromM() {
		assertThat(C.canBeSubtractedFrom(M), is(true));
	}
	
	@Test
	public void L_CannotBeSubtractedFromM() {
		assertThat(L.canBeSubtractedFrom(M), is(false));
	}

}
