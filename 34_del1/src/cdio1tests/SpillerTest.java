package cdio1tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cdio1.Spiller;

public class SpillerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expected = "Spiller1";
		Spiller testSpiller = new Spiller(expected);
		String actual = testSpiller.getSpiller();
		assertEquals(expected, actual);
		// testSpiller.navn = "NEJ";
		// actual = testSpiller.getSpiller();
		// assertEquals(expected, actual);
	}

}
