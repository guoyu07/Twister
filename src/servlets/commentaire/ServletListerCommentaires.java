package servlets.commentaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.commentaire.ListerCommentaires;



public class ServletListerCommentaires extends HttpServlet {
	    public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
	        // Récuperation des paramètres
	        String id_utilisateur = requete.getParameter("id_utilisateur");
	        int limite = Integer.parseInt(requete.getParameter("limite"));

	        // Utilisation du service approprié
	        JSONObject retour =ListerCommentaires.listerCommentaires(id_utilisateur, limite);
	        reponse.setContentType("application/json");
	        reponse.getWriter().print(retour);
	    
	    }

}


