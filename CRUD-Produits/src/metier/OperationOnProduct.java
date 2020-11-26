package metier;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class OperationOnProduct implements IoperationOnProducts{

	@Override
	public void addProduits(Produit p) {
		if (p.getFilename()== null) {
			p.setFilename("NA");
			p.setFilepath("NA");
		}
		Connection cnx = SingletonConnectionJDBC.getCnx();
		try {
			PreparedStatement ps = cnx.
prepareStatement("insert into produit (reference,designation,prix,quantite,warehouse_ref,filename,filepath) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.setString(5, p.getWarehouse_ref());
			ps.setString(6, p.getFilename());
			ps.setString(7, p.getFilepath());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteProduit(Produit p) {
		Connection cnx = SingletonConnectionJDBC.getCnx();
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from produit where reference=? ");
			ps.setString(1, p.getReference());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Produit> AllProducts() {
		List<Produit> listofProduct = new ArrayList<Produit>();
		Connection cnx = SingletonConnectionJDBC.getCnx();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM produit");
			ResultSet resultat = ps.executeQuery();
			
			while(resultat.next()) {
				Produit p = new Produit();
				p.setReference(resultat.getString("reference"));
				p.setDesignation(resultat.getString("designation"));
				p.setPrix(resultat.getDouble("prix"));
				p.setQuantite(resultat.getInt("quantite"));
				p.setWarehouse_ref(resultat.getString("warehouse_ref"));
				p.setFilename(resultat.getString("filename"));
				p.setFilepath(resultat.getString("filepath"));
				
				listofProduct.add(p);
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listofProduct;
	}

	@Override
	public List<Produit> SearchByKeyword(String key) {
		
		List<Produit> listofProduct = new ArrayList<Produit>();
		
		Connection cnx = SingletonConnectionJDBC.getCnx();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM produit WHERE designation LIKE ? ");
			ps.setString(1, "%"+key+"%");
			ResultSet resultat = ps.executeQuery();
			
			while(resultat.next()) {
				Produit p = new Produit();
				p.setReference(resultat.getString("reference"));
				p.setDesignation(resultat.getString("designation"));
				p.setPrix(resultat.getDouble("prix"));
				p.setQuantite(resultat.getInt("quantite"));
				p.setWarehouse_ref(resultat.getString("warehouse_ref"));
				p.setFilename(resultat.getString("filename"));
				p.setFilepath(resultat.getString("filepath"));
				listofProduct.add(p);
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listofProduct;
	}

	@Override
	public void UpdateProduct(Produit p) {
		
		try {
			Connection cnx = SingletonConnectionJDBC.getCnx();
			if (p.getFilename()!=null) {
				PreparedStatement ps = cnx.
						prepareStatement("update produit SET designation = ?,prix=?,quantite=?,warehouse_ref=?,filename=?,filepath=? WHERE reference = ? ");
				ps.setString(1, p.getDesignation());
				ps.setDouble(2, p.getPrix());
				ps.setInt(3, p.getQuantite());
				ps.setString(4, p.getWarehouse_ref());
				ps.setString(5, p.getFilename());
				ps.setString(6, p.getFilepath());
				ps.setString(7, p.getReference());
				ps.executeUpdate();
				ps.close();
			}
			else {
				PreparedStatement ps = cnx.
						prepareStatement("update produit SET designation = ?,prix=?,quantite=?,warehouse_ref=? WHERE reference = ? ");
				ps.setString(1, p.getDesignation());
				ps.setDouble(2, p.getPrix());
				ps.setInt(3, p.getQuantite());
				ps.setString(4, p.getWarehouse_ref());
				ps.setString(5, p.getReference());
				ps.executeUpdate();
				ps.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Produit getSpecificProduct(String Reference) {
		Produit prod = null;
		
		PreparedStatement ps;
		try {
			Connection cnx = SingletonConnectionJDBC.getCnx();
			
			ps = cnx.prepareStatement("Select * from produit WHERE reference=?");
			ps.setString(1, Reference);
			
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				prod = new Produit();
				prod.setDesignation(result.getString("designation"));
				prod.setReference(result.getString("reference"));
				prod.setPrix(result.getDouble("prix"));
				prod.setQuantite(result.getInt("quantite"));
				prod.setWarehouse_ref(result.getString("warehouse_ref"));
				prod.setFilename(result.getString("filename"));
				prod.setFilepath(result.getString("filepath"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(prod == null) throw new RuntimeException(" ---- Produit "+ Reference +" introuvable ----");
		else return prod;
	}
	

}
