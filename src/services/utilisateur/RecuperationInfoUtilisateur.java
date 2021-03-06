package services.utilisateur;

import java.sql.SQLException;

import org.json.JSONObject;

import bd.tools.UtilisateursTools;
import services.CodesErreur;
import services.ErrorJSON;

public class RecuperationInfoUtilisateur {
	
	public static JSONObject recuperationInfoUtilisateur(String id) {
		try{
		
		JSONObject retour =UtilisateursTools.getInfoUtilisateur(id);
		return retour;
		
		
		}catch(InstantiationException e){
			return ErrorJSON.serviceRefused("Erreur lors de la connexion a la base de donnees MySQL (InstantiationException)", CodesErreur.ERREUR_CONNEXION_BD_MYSQL);
		}catch( IllegalAccessException e){
			return ErrorJSON.serviceRefused("Erreur lors de la connexion a la base de donnees MySQL (IllegalAccessException)", CodesErreur.ERREUR_CONNEXION_BD_MYSQL);
		}catch( ClassNotFoundException e){
			return ErrorJSON.serviceRefused("Erreur lors de la connexion a la base de donnees MySQL (ClassNotFoundException)", CodesErreur.ERREUR_CONNEXION_BD_MYSQL);
		}catch ( SQLException e){
			return ErrorJSON.serviceRefused("Erreur, requete SQL incorrecte", CodesErreur.ERREUR_SQL);
		}
	}
}
