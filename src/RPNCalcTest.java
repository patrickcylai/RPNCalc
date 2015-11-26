import static org.junit.Assert.*;

import org.junit.Test;

public class RPNCalcTest {

	@Test
	public void testisNumeric() {
		assertTrue(RPNCalc.isNumeric("123"));
		assertFalse(RPNCalc.isNumeric("abc"));
		assertFalse(RPNCalc.isNumeric("a1b2c3"));
		assertTrue(RPNCalc.isNumeric("1.2"));
		assertFalse(RPNCalc.isNumeric("1.2.3"));
	}
	
	@Test
	public void testMainWithArgs() {
		//String[] args = {"1", "1", "+"};
	}

}
