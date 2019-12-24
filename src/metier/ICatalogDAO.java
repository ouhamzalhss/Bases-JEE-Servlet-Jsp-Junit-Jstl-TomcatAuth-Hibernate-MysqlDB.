package metier;

import java.util.List;

import metier.entities.Produit;

public interface ICatalogDAO {
	
	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public Produit getProduit(Long id);
	public List<Produit> getProduitParMC(String mc);
	public void deleteProduit(Long id);
	public void updateProduit(Produit p);
	
}
