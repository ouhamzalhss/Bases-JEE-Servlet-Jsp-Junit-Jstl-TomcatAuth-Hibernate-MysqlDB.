package metier.entities;

public class ModelB {
	
	private double montant;
	private int duree;
	private double taux;
	private double mensialite;
	
	
	public ModelB(double montant, int duree, double taux) {
		super();
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
	}
	
	public ModelB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getMensialite() {
		return mensialite;
	}
	public void setMensialite(double mensialite) {
		this.mensialite = mensialite;
	}
	
	

}
