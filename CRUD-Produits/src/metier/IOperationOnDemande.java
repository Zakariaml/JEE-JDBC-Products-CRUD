package metier;

import java.util.List;

public interface IOperationOnDemande {

	public void addDemande(Demande d);
	public void modifyDemande(Demande d);
	public void deleteDemande(Demande d);
	public List<Demande> AllDemande();
	public List<Demande> SearchByKeywordInDemande(String Key);
	public Demande getSpecificDemande(int ref_dem);
}
