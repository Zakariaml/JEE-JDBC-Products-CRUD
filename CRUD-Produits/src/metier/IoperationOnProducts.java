package metier;

import java.util.List;

public interface IoperationOnProducts {

	public void addProduits(Produit p);
	public void deleteProduit(Produit p);
	public List<Produit> AllProducts();
	public List<Produit> SearchByKeyword(String key);
	public void UpdateProduct(Produit p);
	public Produit getSpecificProduct(String Reference);
}
