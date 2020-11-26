package metier;

import java.io.Serializable;

public class Produit implements Serializable{

	private String reference;
	private String designation;
	private double prix;
	private int quantite;
	private String warehouse_ref ;
	private String filename;
	private String filepath;
	
	//-------------Getters and setters------------------
	public String getReference() {
		return reference;
	}
	public String getDesignation() {
		return designation;
	}
	public double getPrix() {
		return prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public String getWarehouse_ref() {
		return warehouse_ref;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public void setWarehouse_ref(String warehouse_ref) {
		this.warehouse_ref = warehouse_ref;
	}
	public String getFilename() {
		return filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Produit(String reference, String designation, double prix, int quantite, String warehouse_ref,
			String filename, String filepath) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.warehouse_ref = warehouse_ref;
		this.filename = filename;
		this.filepath = filepath;
	}
	
	public Produit(String reference, String designation, double prix, int quantite, String warehouse_ref) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.warehouse_ref = warehouse_ref;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
