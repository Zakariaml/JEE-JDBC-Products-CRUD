package metier;

public class Demande {

	private int id_demande;
	private String nom;
	private String prenom;
	private String ref_produit;
	private String ville;
	private String adresse;
	private String telephone;
	
	
	public Demande(int id_demande, String nom, String prenom, String ref_produit, String ville, String adresse,
			String telephone) {
		super();
		this.id_demande = id_demande;
		this.nom = nom;
		this.prenom = prenom;
		this.ref_produit = ref_produit;
		this.ville = ville;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	
	public Demande() {
		super();
		
	}

	public int getId_demande() {
		return id_demande;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getRef_produit() {
		return ref_produit;
	}
	public String getVille() {
		return ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setRef_produit(String ref_produit) {
		this.ref_produit = ref_produit;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
