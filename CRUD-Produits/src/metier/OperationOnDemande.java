package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationOnDemande implements IOperationOnDemande{

	@Override
	public void addDemande(Demande d) {
		Connection cnx = SingletonConnectionJDBC.getCnx();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO demande VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, d.getId_demande());
			ps.setString(2, d.getNom());
			ps.setString(3, d.getPrenom());
			ps.setString(4, d.getRef_produit());
			ps.setString(5, d.getVille());
			ps.setString(6,d.getAdresse());
			ps.setString(7, d.getTelephone());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifyDemande(Demande d) {
		Connection cnx = SingletonConnectionJDBC.getCnx();
		
		try {
			PreparedStatement ps = cnx.
					prepareStatement("UPDATE demande"
							+ " SET nom_client=?,prenom_client=?,"
							+ "ref_produit=?,ville=?,adresse=?,telephone=? "
							+ "WHERE id_demande = ?");
	
			ps.setString(1, d.getNom());
			ps.setString(2, d.getPrenom());
			ps.setString(3, d.getRef_produit());
			ps.setString(4, d.getVille());
			ps.setString(5,d.getAdresse());
			ps.setString(6, d.getTelephone());
			ps.setInt(7, d.getId_demande());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDemande(Demande d) {
		Connection cnx = SingletonConnectionJDBC.getCnx();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM demande WHERE id_demande = ?");
			ps.setInt(1, d.getId_demande());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Demande> AllDemande() {
		List<Demande> listOrders = new ArrayList<Demande>();
		
		Connection cnx = SingletonConnectionJDBC.getCnx();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM demande");
			ResultSet resultat = ps.executeQuery();
			while(resultat.next()) {
				Demande d = new Demande();
				d.setId_demande(Integer.parseInt(resultat.getString("id_demande")));
				d.setNom(resultat.getString("nom_client"));
				d.setPrenom(resultat.getString("prenom_client"));
				d.setRef_produit(resultat.getString("ref_produit"));
				d.setVille(resultat.getString("ville"));
				d.setAdresse(resultat.getString("adresse"));
				d.setTelephone(resultat.getString("telephone"));
				listOrders.add(d);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOrders;
	}

	@Override
	public Demande getSpecificDemande(int ref_dem) {
			Demande d = new Demande();
		try {
			Connection cnx = SingletonConnectionJDBC.getCnx();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM demande WHERE id_demande=?");
			ps.setInt(1, ref_dem);
			
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				d.setId_demande(Integer.parseInt(result.getString("id_demande")));
				d.setNom(result.getString("nom_client"));
				d.setPrenom(result.getString("prenom_client"));
				d.setRef_produit(result.getString("ref_produit"));
				d.setVille(result.getString("ville"));
				d.setAdresse(result.getString("adresse"));
				d.setTelephone(result.getString("telephone"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public List<Demande> SearchByKeywordInDemande(String Key) {
		List<Demande> listOrders = new ArrayList<Demande>();
		try {
			Connection cnx = SingletonConnectionJDBC.getCnx();
			PreparedStatement ps = cnx.
					prepareStatement("SELECT * FROM demande WHERE "
							+ "nom_client LIKE ? OR prenom_client LIKE ? OR ville LIKE ?"
							+ "OR adresse LIKE ? OR telephone LIKE ?");
			//ps.setInt(1, Integer.parseInt("%"+Key+"%"));
			ps.setString(1, "%"+Key+"%");
			ps.setString(2, "%"+Key+"%");
			ps.setString(3, "%"+Key+"%");
			ps.setString(4, "%"+Key+"%");
			ps.setString(5, "%"+Key+"%");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				Demande d = new Demande();
				d.setId_demande(Integer.parseInt(result.getString("id_demande")));
				d.setNom(result.getString("nom_client"));
				d.setPrenom(result.getString("prenom_client"));
				d.setRef_produit(result.getString("ref_produit"));
				d.setVille(result.getString("ville"));
				d.setAdresse(result.getString("adresse"));
				d.setTelephone(result.getString("telephone"));
				listOrders.add(d);
			}
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return listOrders;
	}

}
