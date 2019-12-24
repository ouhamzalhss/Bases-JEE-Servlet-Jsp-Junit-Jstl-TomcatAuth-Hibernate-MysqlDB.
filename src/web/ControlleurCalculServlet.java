package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.ModelB;
import metier.CalculMetier;
import metier.CalculMetierImpl;

//@WebServlet(name = "cc", urlPatterns = "*.js")
public class ControlleurCalculServlet extends HttpServlet{
	CalculMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CalculMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String action = req.getParameter("action");
		ModelB modelB;
		
		if(action!=null) {
			if(action.equals("Calculer")) {
				
				double capital = Double.parseDouble(req.getParameter("capital"));
				int duree = Integer.parseInt(req.getParameter("duree"));
				double taux = Double.parseDouble(req.getParameter("taux"));
				
				modelB = new ModelB( capital, duree, taux );
				modelB.setMensialite(metier.calculeMonsialite(modelB));
				req.setAttribute("model", modelB);
			 }
		 }
		
		req.getRequestDispatcher("calcul.jsp").forward(req, resp);
	}

}
