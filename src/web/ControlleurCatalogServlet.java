package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogImpl;
import metier.ICatalogDAO;
import metier.entities.Produit;

//@WebServlet(name="cs", urlPatterns = "*.php")
public class ControlleurCatalogServlet extends HttpServlet{
	
	private ICatalogDAO metier;
	
@Override
public void init() throws ServletException {
	metier = new CatalogImpl();
	super.init();
}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		
		
		if(action!=null) {
			if(action.equals("Ajouter")) {
				try {
					String des = req.getParameter("designation");
					double prix =Double.parseDouble(req.getParameter("prix"));
					int qte = Integer.parseInt(req.getParameter("qte"));
					metier.addProduit(new Produit(des,prix,qte));
				} catch (Exception e) {
					req.setAttribute("exception", e.getMessage());
				}
			}else if(action.equals("supp")) {
				Long id = Long.parseLong(req.getParameter("id"));
				metier.deleteProduit(id);
			}else if(action.equals("edit")) {
				 Long id = Long.parseLong(req.getParameter("id"));
				 req.setAttribute("produit", metier.getProduit(id));
		   }else if(action.equals("Modifier")) {
			   		try {
					   	 Long id = Long.parseLong(req.getParameter("id"));
						 Produit p = metier.getProduit(id);
						 p.setDesignation(req.getParameter("designation"));
						 p.setPrix(Double.parseDouble(req.getParameter("prix")));
						 p.setQte(Integer.parseInt(req.getParameter("qte")));
						 
						 metier.updateProduit(p);
					} catch (Exception e) {
						req.setAttribute("exception", e.getMessage());
					}
				
		   }
		}
		
		    Map<String, String> menu = new HashMap();
		    menu.put("Gestion produits", "*.php"); 
		    menu.put("Mensualité crédit", "*.js");
		
		    req.setAttribute("menu", menu);
		    req.setAttribute("produits", metier.listProduits());
			req.getRequestDispatcher("views/produits.jsp").forward(req, resp);
	}
}
