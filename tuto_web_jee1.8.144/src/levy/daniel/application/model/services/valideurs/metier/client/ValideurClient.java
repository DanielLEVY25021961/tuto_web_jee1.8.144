package levy.daniel.application.model.services.valideurs.metier.client;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.GestionnaireRG;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.services.valideurs.AbstractValideurGeneric;
import levy.daniel.application.model.services.valideurs.LigneRapportValidation;

/**
 * class ValideurClient :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 30 août 2017
 *
 */
public class ValideurClient extends AbstractValideurGeneric<AbstractClient> {

	// ************************ATTRIBUTS************************************/

		
	/**
	 * METHODE_VALIDER_NOM : String :<br/>
	 * "Méthode validerNom(...)".<br/>
	 */
	public static final String METHODE_VALIDER_NOM 
		= "Méthode validerNom(...)";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ValideurClient.class);
	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ValideurClient() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ValideurClient() {
		
		super();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final AbstractClient pClient) 
			throws MalformedURLException {
		
		this.validerNom(pClient);
		
		return this.erreurs;
		
	} // Fin de validate(...)._____________________________________________
	
	
		
	/**
	 * method validerNom(
	 * AbstractClient pClient) :<br/>
	 * <ul>
	 * </ul>
	 * <br/>
	 * retourne true si pClient == null.<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * 
	 * @return boolean : false si l'attribut 
	 * à vérifier n'est pas valide.<br/>
	 * @throws MalformedURLException 
	 */
	public boolean validerNom(
			final AbstractClient pClient) 
						throws MalformedURLException {
			
		final Map<String, String> mapErreursNom 
		= new ConcurrentHashMap<String, String>();
		
		final Map<String, LigneRapportValidation> mapControlesNom 
		= new ConcurrentHashMap<String, LigneRapportValidation>();
		
		/* Vérification de la RG_CLIENT_NOM_01. */
		final boolean isValideRGClientNom01 
			= this.validerRGClientNom01(
					pClient, mapErreursNom, mapControlesNom);
		
		/* Vérification de la RG_CLIENT_NOM_02. */
		final boolean isValideRGClientNom02 
			= this.validerRGClientNom02(
					pClient, mapErreursNom, mapControlesNom);
		
		/* Alimentation de la map this.erreurs. */
		this.erreurs.put("nom", mapErreursNom);
		
		/* Alimentation de la Map this.controles. */
		this.controles.put("nom", mapControlesNom);
		
		return isValideRGClientNom01 && isValideRGClientNom02;
		
	} // Fin de validerNom(...).__________________________________________
	
	
	
	/**
	 * method validerRGClientNom01(
	 * AbstractClient pClient
	 * , Map<String, String> pMapNom) :<br/>
	 * Contrôle si la RG_CLIENT_NOM_01 est bien appliquée.<br/>
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.".<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @param pMapErreursNom : Map&lt;String, String&gt; : 
	 * Map contenant le nom de la règle et son message d'erreur.<br/>
	 * @param pMapControlesNom : Map&lt;String, LigneRapportValidation&gt; 
	 * : Map contenant le nom de la règle et le rapport de contrôle.<br/>
	 * 
	 * @return : boolean : false si la règle est violée.<br/>
	 * @throws MalformedURLException 
	 */
	public boolean validerRGClientNom01(
			final AbstractClient pClient
			, final Map<String, String> pMapErreursNom
			, final Map<String, LigneRapportValidation> pMapControlesNom) 
							throws MalformedURLException {
		
		/* retourne true si pClient == null. */
		if (pClient == null) {
			return true;
		}
		
		boolean resultat = true;
		
		/* Extraction de l'attribut du bean 'nom'. */
		final String nom = pClient.getNom();
				
		/* RG_CLIENT_NOM_01. */
		final LigneRG ligneRGClient01 
			= GestionnaireRG.getLigneRG(GestionnaireRG.RG_CLIENT_NOM_01);
		
		/* alimente this.listeRGImplementees. */
		this.alimenterListeRGImplementees(ligneRGClient01);

		/* Récupération de l'activité de la règle. */
		final Boolean actif = ligneRGClient01.getActif();
		
		if (actif) {
			
			// CAS DE VIOLATION DE LA REGLE.
			/* RG-Client-01 : le nom du client doit être renseigné. */
			if (StringUtils.isBlank(nom)) {
				
				/* Remplissage de la map contenant les erreurs 
				 * associées à l'attribut 'nom'. */
				pMapErreursNom.put(
						GestionnaireRG.RG_CLIENT_NOM_01
						, GestionnaireRG.RG_CLIENT_NOM_01_MESSAGE);
				
				/* Remplissage de la map contenant les contrôles 
				 * associées à l'attribut 'nom'. */
				final LigneRapportValidation ligneRapportValidation 
				= new LigneRapportValidation(
						"KO"
						, "Le champ nom est null ou vide (que des espaces)"
						, ligneRGClient01);
				
				pMapControlesNom.put(
						GestionnaireRG.RG_CLIENT_NOM_01
						, ligneRapportValidation);
				
				/* remplissage de la liste des contrôles. */
				this.controlesList.add(ligneRapportValidation);
								
				resultat = false;
			
			// PAS DE VIOLATION DE LA REGLE.
			} else {
				
				/* Remplissage de la map contenant les contrôles 
				 * associées à l'attribut 'nom'. */
				final LigneRapportValidation ligneRapportValidation 
				= new LigneRapportValidation(
						"OK"
						, "Le champ nom est renseigné"
						, ligneRGClient01);
				
				pMapControlesNom.put(
						GestionnaireRG.RG_CLIENT_NOM_01
						, ligneRapportValidation);
				
				/* remplissage de la liste des contrôles. */
				this.controlesList.add(ligneRapportValidation);
				
				resultat = true;
			}
		
		// CONTROLE INACTIF.
		} else {
			
			/* Remplissage de la map contenant les contrôles 
			 * associées à l'attribut 'nom'. */
			final LigneRapportValidation ligneRapportValidation 
			= new LigneRapportValidation(
					"Sans Objet (non effectué)"
					, "La nullité du champ nom n'est pas contrôlée"
					, ligneRGClient01);
			
			pMapControlesNom.put(
					GestionnaireRG.RG_CLIENT_NOM_01
					, ligneRapportValidation);
			
			/* remplissage de la liste des contrôles. */
			this.controlesList.add(ligneRapportValidation);
			
			resultat = true;
			
		}
				
		return resultat;
		
	} // Fin de validerRGClientNom01(...)._________________________________


	
	/**
	 * method validerRGClientNom02() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @param pMapErreursNom : Map&lt;String, String&gt; : 
	 * Map contenant le nom de la règle et son message d'erreur.<br/>
	 * @param pMapControlesNom : Map&lt;String, LigneRapportValidation&gt; 
	 * : Map contenant le nom de la règle et le rapport de contrôle.<br/>
	 * 
	 * @return : boolean : false si la règle est violée.<br/>
	 * @throws MalformedURLException 
	 */
	public boolean validerRGClientNom02(
			final AbstractClient pClient
			, final Map<String, String> pMapErreursNom
			, final Map<String, LigneRapportValidation> pMapControlesNom) 
					throws MalformedURLException {
		
		/* retourne true si pClient == null. */
		if (pClient == null) {
			return true;
		}
		
		boolean resultat = true;
		
		/* Extraction de l'attribut du bean 'nom'. */
		final String nom = pClient.getNom();
				
		/* RG_CLIENT_NOM_02. */
		final LigneRG ligneRGClient02 
			= GestionnaireRG.getLigneRG(GestionnaireRG.RG_CLIENT_NOM_02);
		
		/* alimente this.listeRGImplementees. */
		this.alimenterListeRGImplementees(ligneRGClient02);

		/* Récupération de l'activité de la règle. */
		final Boolean actif = ligneRGClient02.getActif();
		
		if (actif) {
			
			/* Pattern "que des lettres". 
			 * + signifie au moins une lettre. */
			final Pattern pattern = Pattern.compile("\\D+");
			
			/* Moteur de recherche Matcher. */
			final Matcher matcher = pattern.matcher(nom);
			
			/* boolean qui stipule si le pattern est respecté. */
			final boolean match = matcher.matches();
			
			// CAS DE VIOLATION DE LA REGLE.
			/* RG_CLIENT_NOM_02 : le nom du client ne doit contenir que des lettres. */
			if (!match) {
				
				/* Remplissage de la map contenant les erreurs 
				 * associées à l'attribut 'nom'. */
				pMapErreursNom.put(
						GestionnaireRG.RG_CLIENT_NOM_02
						, GestionnaireRG.RG_CLIENT_NOM_02_MESSAGE);
				
				/* Remplissage de la map contenant les contrôles 
				 * associées à l'attribut 'nom'. */
				final LigneRapportValidation ligneRapportValidation 
				= new LigneRapportValidation(
						"KO"
						, "Le champ nom ne contient pas que des lettres : " + nom
						, ligneRGClient02);
				
				pMapControlesNom.put(
						GestionnaireRG.RG_CLIENT_NOM_02
						, ligneRapportValidation);
				
				/* remplissage de la liste des contrôles. */
				this.controlesList.add(ligneRapportValidation);
								
				resultat = false;
			
			// PAS DE VIOLATION DE LA REGLE.
			} else {
				
				/* Remplissage de la map contenant les contrôles 
				 * associées à l'attribut 'nom'. */
				final LigneRapportValidation ligneRapportValidation 
				= new LigneRapportValidation(
						"OK"
						, "Le champ nom ne contient que des lettres : " + nom
						, ligneRGClient02);
				
				pMapControlesNom.put(
						GestionnaireRG.RG_CLIENT_NOM_02
						, ligneRapportValidation);
				
				/* remplissage de la liste des contrôles. */
				this.controlesList.add(ligneRapportValidation);
				
				resultat = true;
			}
		
		// CONTROLE INACTIF.
		} else {
			
			/* Remplissage de la map contenant les contrôles 
			 * associées à l'attribut 'nom'. */
			final LigneRapportValidation ligneRapportValidation 
			= new LigneRapportValidation(
					"Sans Objet (non effectué)"
					, "Le format du champ nom n'est pas contrôlée"
					, ligneRGClient02);
			
			pMapControlesNom.put(
					GestionnaireRG.RG_CLIENT_NOM_02
					, ligneRapportValidation);
			
			/* remplissage de la liste des contrôles. */
			this.controlesList.add(ligneRapportValidation);
			
			resultat = true;
			
		}
				
		return resultat;
		
	} // Fin de validerRGClientNom02(...)._________________________________
	
	
} // FIN DE LA CLASSE ValideurClient.----------------------------------------
