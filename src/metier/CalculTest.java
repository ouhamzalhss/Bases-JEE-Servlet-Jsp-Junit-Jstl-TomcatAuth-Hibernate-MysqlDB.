package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.entities.ModelB;

public class CalculTest {
	
	private CalculMetier metier;

	@Before
	public void setUp() throws Exception {
		metier = new CalculMetierImpl();
	}

	@Test
	public void testCalculeMonsialite() {

		double capital = 200000;
		int duree = 240;
		double taux = 0.045;
		ModelB model = new ModelB(capital, duree, taux);
		double resAtt = 1265.2987;
		double res = metier.calculeMonsialite(model);
		assertEquals(resAtt, res, 0.0001);
	}

}
