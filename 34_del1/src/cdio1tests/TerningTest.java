package cdio1tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cdio1.Terning;

public class TerningTest {
	Terning testTerning;

	@Before
	public void setUp() throws Exception {
		testTerning = new Terning();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final int ANTAL_TESTSLAG = 60000; // bør ikke overstige 357913940, hvilket er intmax/6. Hvis den gør er der en lillebitte risiko for overflow.
		final double TILLADT_AFVIGELSE = 0.04; // Tillad afvigelse på 4%.
		final double FORVENTET_MINIMUM = ANTAL_TESTSLAG * (1-TILLADT_AFVIGELSE) / 6;
		final double FORVENTET_MAKSIMUM = ANTAL_TESTSLAG * (1+TILLADT_AFVIGELSE) / 6;
		int antal1ere = 0;
		int antal2ere = 0;
		int antal3ere = 0;
		int antal4ere = 0;
		int antal5ere = 0;
		int antal6ere = 0;
		for (int i = 0; i < ANTAL_TESTSLAG; i++)
		{

			int slagResultat = testTerning.kast();
			assertTrue(1 <= slagResultat && slagResultat <= 6);
			switch(slagResultat) {
			case 1:  
				antal1ere++;
				break;
			case 2:  
				antal2ere++;
				break;
			case 3:  
				antal3ere++;
				break;
			case 4:  
				antal4ere++;
				break;
			case 5:  
				antal5ere++;
				break;
			case 6:  
				antal6ere++;
				break;	
			}

		}
		assertTrue(FORVENTET_MINIMUM < antal1ere && antal1ere < FORVENTET_MAKSIMUM);
		assertTrue(FORVENTET_MINIMUM < antal2ere && antal2ere < FORVENTET_MAKSIMUM);
		assertTrue(FORVENTET_MINIMUM < antal3ere && antal3ere < FORVENTET_MAKSIMUM);
		assertTrue(FORVENTET_MINIMUM < antal4ere && antal4ere < FORVENTET_MAKSIMUM);
		assertTrue(FORVENTET_MINIMUM < antal5ere && antal5ere < FORVENTET_MAKSIMUM);
		assertTrue(FORVENTET_MINIMUM < antal6ere && antal6ere < FORVENTET_MAKSIMUM);
	}

}
