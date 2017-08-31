package levy.daniel.application.model.services.valideurs.metier.client;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.GestionnaireRG;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.services.valideurs.AbstractValideurGeneric;

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
			
		final Map<String, String> mapNom 
		= new ConcurrentHashMap<String, String>();
		
		return this.validerRGClientNom01(pClient, mapNom);
		
	} // Fin de validerNom(...).__________________________________________
	
	
	
	/**
	 * method validerRGClientNom01(
	 * AbstractClient pClient
	 * , Map<String, String> pMapNom) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient
	 * @param pMapNom :
	 * 
	 * @return :  :  .<br/>
	 */
	public boolean validerRGClientNom01(
			final AbstractClient pClient
				, final Map<String, String> pMapNom) {
		
		/* retourne true si pClient == null. */
		if (pClient == null) {
			return true;
		}
		
		boolean resultat = true;
				
		final String nom = pClient.getNom();
				
		/* RG_CLIENT_NOM_01. */
		final LigneRG ligneRGClient01 
			= GestionnaireRG.getLigneRG(GestionnaireRG.RG_CLIENT_NOM_01);

		final Boolean actif = ligneRGClient01.getActif();
		
		if (actif) {
						
			/* RG-Client-01 : le nom du client doit être renseigné. */
			if (StringUtils.isBlank(nom)) {
				
				
				
				rg1Map.put(GestionnaireRG.RG_CLIENT_NOM_01, GestionnaireRG.RG_CLIENT_NOM_01_MESSAGE);
				
				pErreurs.put("nom", rg1Map);
				
				resultat = false;
			}
		}
		
		this.alimenterListeRGImplementees(ligneRGClient01);
				
		
		return resultat;
	}


	public boolean validerRGClientNom02(AbstractClient pClient, Map<String, String> pMapNom) {
		
	}
} // FIN DE LA CLASSE ValideurClient.----------------------------------------
