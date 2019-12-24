package metier;

import java.util.List;

import metier.entities.Produit;

public class TestCatalogue {

	public static void main(String[] args) {
		ICatalogDAO metier = new CatalogImpl();
		metier.addProduit(new Produit("HP 100", 1542, 12));
		metier.addProduit(new Produit("IMPR 100", 4222, 10));
		
		List<Produit> liste = metier.getProduitParMC("IMPR");
		for(Produit p : liste) {
			System.out.println(p.getDesignation());
		}
		
		

	}

}
