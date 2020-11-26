package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Demande;
import metier.IOperationOnDemande;
import metier.IoperationOnProducts;
import metier.OperationOnDemande;
import metier.OperationOnProduct;
import metier.Produit;

/**
 * Servlet implementation class ClientProduitServlet
 */
@WebServlet("/ClientProduitServlet")
public class ClientProduitServlet extends HttpServlet {
	
	private IoperationOnProducts metier;
	private IOperationOnDemande demandeModel;

	@Override
	public void init() throws ServletException {
		metier = new OperationOnProduct();
		demandeModel = new OperationOnDemande();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Demande d = new Demande();
		String action = request.getParameter("action");
		if (action != null) {
			//if the client press button buy in a specific button
			if(action.equalsIgnoreCase("buy")) {
				Produit p = new Produit();
				//get the product and redirect to form page to complete the order!
				p = metier.getSpecificProduct(request.getParameter("reference"));
				request.setAttribute("produit", p);
				
				request.getRequestDispatcher("/WEB-INF/Ordernow.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("demander")) {
				d.setRef_produit(request.getParameter("reference"));
				d.setNom(request.getParameter("nom"));
				d.setPrenom(request.getParameter("prenom"));
				d.setAdresse(request.getParameter("adresse"));
				d.setVille(request.getParameter("ville"));
				d.setTelephone(request.getParameter("telephone"));

				demandeModel.addDemande(d);
				
				// Redirect to Thank you page and show some information about the order!
				List<Produit> allprod = metier.AllProducts();
				request.setAttribute("allprod", allprod);
				request.getRequestDispatcher("/WEB-INF/Shop.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("search")) {
				String keyword = request.getParameter("keyword");
				List<Produit> productSearch = metier.SearchByKeyword(keyword);
				request.setAttribute("key", keyword);
				request.setAttribute("allprod", productSearch);
				request.getRequestDispatcher("/WEB-INF/Shop.jsp").forward(request, response);
			}
		}
		else {
			List<Produit> allprod = metier.AllProducts();
			request.setAttribute("allprod", allprod);
			request.getRequestDispatcher("/WEB-INF/Shop.jsp").forward(request, response);	
		}
	}

}
