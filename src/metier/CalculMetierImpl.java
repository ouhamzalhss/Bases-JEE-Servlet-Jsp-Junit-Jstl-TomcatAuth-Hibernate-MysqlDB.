package metier;

import metier.entities.ModelB;

public class CalculMetierImpl implements CalculMetier{
	
	@Override
	public double calculeMonsialite(ModelB model) {
		double taux = model.getTaux() / 100;
		
		return (model.getMontant() * taux /12 ) / (1 - Math.pow( 1 + taux / 12, -model.getDuree()));
	}

}
