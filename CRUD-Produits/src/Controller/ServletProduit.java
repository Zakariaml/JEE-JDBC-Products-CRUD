package Controller;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import metier.Demande;
import metier.IOperationOnDemande;
import metier.IoperationOnProducts;
import metier.OperationOnDemande;
import metier.OperationOnProduct;
import metier.Produit;

@MultipartConfig
public class ServletProduit extends HttpServlet{

	private IoperationOnProducts metier;
	private IOperationOnDemande demandeModel;
	
	@Override
	public void init() throws ServletException {
		metier = new OperationOnProduct();
		demandeModel = new OperationOnDemande();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produit> allProducts = new ArrayList<Produit>();
		List<Demande> alldemandes = new ArrayList<Demande>();
		String action = request.getParameter("action");
		if(action != null) {
			Produit p = new Produit();
			if(action.equalsIgnoreCase("delete")) {
				p.setReference(request.getParameter("ref"));
				metier.deleteProduit(p);
			}
			else if (action.equalsIgnoreCase("modify")) {
				p = metier.getSpecificProduct(request.getParameter("ref"));
				request.setAttribute("product", p);
				request.getRequestDispatcher("/WEB-INF/Modifyproduct.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("save")) {
				p.setReference(request.getParameter("reference"));
				p.setDesignation(request.getParameter("designation"));
				p.setPrix(Double.parseDouble(request.getParameter("prix")));
				p.setQuantite(Integer.parseInt(request.getParameter("quantite")));
				p.setWarehouse_ref(request.getParameter("warehouse_ref"));
	
				//boolean selected = request.getParameter("checkIfFileSelected").equalsIgnoreCase("selected");
		
					Part partimage = request.getPart("image");
					
					//get the path with the function getPart(String...) 
					Part part = partimage;
					//extract file name using method extractFileName defined in the bottom of this servlet
					String filename = extractFileName(part);
					if(!filename.equalsIgnoreCase("")) {
						//specify the path where we will save the image file
						String SavePath ="C:\\Users\\HINNOVIS\\eclipse-workspace\\CRUD-Produits\\WebContent\\images"+ File.separator + filename;
						//Then save the file using new File();
						File saveFile = new File(SavePath);
						
						part.write(SavePath + File.separator);
						
						p.setFilename(filename);
						p.setFilepath(SavePath);	
					}
					
				
				String UpdateOrAdd;
				if(request.getParameter("addORsave") == null) {
					metier.UpdateProduct(p);
					UpdateOrAdd = "Modified";
					request.setAttribute("ModifiedOrAdded", UpdateOrAdd);
					GoToHomePage(request, response);
				}
				else {
					metier.addProduits(p);
					UpdateOrAdd= "Added";
					request.setAttribute("ModifiedOrAdded", UpdateOrAdd);
					GoToHomePage(request, response);
				} 
			}
			else if (action.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("/WEB-INF/Modifyproduct.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("search")) {
				String keyword = request.getParameter("keyword");
				if(!keyword.equalsIgnoreCase("")) {
					allProducts = metier.SearchByKeyword(keyword);
					alldemandes = SearchByKeywordInDemandeAndConvertRefProdToDeisgnation(keyword);
					
					request.setAttribute("key", keyword);
					request.setAttribute("listdemand", alldemandes);
					request.setAttribute("listprod", allProducts);
					
					request.getRequestDispatcher("/WEB-INF/HomePageJSP.jsp").forward(request, response);
				}
				else GoToHomePage(request, response);
				
			}
		}
		GoToHomePage(request, response);
		
	}

	private void GoToHomePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Produit> allProducts = metier.AllProducts();;
		List<Demande> alldemandes = AllDemandesAndConvertRefProdToDesignation();

		request.setAttribute("listdemand", alldemandes);
		request.setAttribute("listprod", allProducts);
		
		request.getRequestDispatcher("/WEB-INF/HomePageJSP.jsp").forward(request, response);
	}
	
	private List<Demande> SearchByKeywordInDemandeAndConvertRefProdToDeisgnation(String key){
		List<Demande> alldemandes = demandeModel.SearchByKeywordInDemande(key);
		List<Demande> Alldem_convert = new ArrayList<Demande>();
		
		for (Demande demande : alldemandes) {
			String designation = metier.getSpecificProduct(demande.getRef_produit()).getDesignation();
			demande.setRef_produit(designation);
			Alldem_convert.add(demande);
		}
	return Alldem_convert;
	}
	
	/*private List<Demande> SerachInDemande(String Key){
		List<Demande> AllDemande= AllDemandesAndConvertRefProdToDesignation();
		List<Demande> AfterSearchInDemande = new ArrayList<Demande>();
		String KEYlowerCase = Key.toLowerCase();
		for (Demande demande : AllDemande) {
			if(demande.getId_demande() == Integer.parseInt(Key) || 
					demande.getNom().contains(KEYlowerCase) == true ||
					demande.getPrenom().contains(KEYlowerCase)==true 
					|| demande.getRef_produit().contains(KEYlowerCase)==true ||
					demande.getVille().contains(KEYlowerCase)==true ||
					demande.getAdresse().contains(KEYlowerCase)==true ||
					demande.getTelephone().contains(KEYlowerCase)==true) {
				
			}
			
		}
		return null;
	}*/
	
	private List<Demande> AllDemandesAndConvertRefProdToDesignation(){
		List<Demande> AllDem = demandeModel.AllDemande();
		List<Demande> AllDemConverted = new ArrayList<Demande>();
		
		for (Demande demande : AllDem) {
			String designation = metier.getSpecificProduct(demande.getRef_produit()).getDesignation();
			demande.setRef_produit(designation);
			AllDemConverted.add(demande);
		}
		return AllDemConverted;
	}
	
	private String extractFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
	    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : partHeader.split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
}

