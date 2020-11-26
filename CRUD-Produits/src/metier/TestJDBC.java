package metier;

import java.util.Iterator;
import java.util.List;

public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IoperationOnProducts test = new OperationOnProduct();

		//test.addProduits(new Produit("11", "Lenovo ThinkPad Y1", 7510, 10, "WH_9"));
		
		//List<Produit> prods = test.AllProducts();
		
		/*for(Produit p : prods) {
			System.out.println(" Designation :"+p.getDesignation());
		}*/
		//Produit p1 = new Produit("2","n",1,2,"N");
		//test.deleteProduit(p1);
		
		//prods = test.SearchByKeyword("Len");
		
		/*for (Produit pr : prods) {
			System.out.println("Disgnation recherché : "+pr.getDesignation());
		}*/
		
		//-------------Get PRODUIT------------------------------
		
		/*try {
			Produit pr= test.getSpecificProduct("1");
			System.out.println("----------------------------------");
			System.out.println("Produit recherché est : ");
			System.out.println(pr.getReference());
			System.out.println(pr.getDesignation());
			System.out.println(pr.getPrix());
			System.out.println(pr.getQuantite());
			System.out.println(pr.getWarehouse_ref());
			System.out.println("----------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		//-------------UPDATE PRODUCT------------------------------
		//test.UpdateProduct(new Produit("10", "Updated from app", 99, 99, "Updated from app"));
		
		IOperationOnDemande testd = new OperationOnDemande();
		
		Demande d = new Demande();
		
		//testd.addDemande(d);
		//testd.modifyDemande(d);
		
		List<Demande> list = testd.SearchByKeywordInDemande("del");
		
		for (Demande dem : list) {
			System.out.println(dem.getId_demande());
			System.out.println(dem.getNom());
			System.out.println(dem.getPrenom());
			System.out.println(dem.getRef_produit());
		}
		//d = testd.getSpecificDemande(1);
		//System.out.println(d.getNom());
	}

}
