package levy.daniel.application.model.metier.client.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class Client :<br/>
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
 * @since 20 août 2017
 *
 */
public class Client extends AbstractClient {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Client.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR Client() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 *
	 */
	public Client() {
		this(null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Client(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : 
	 * adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/> 
	 */
	public Client(
			final String pNom, final String pPrenom
				, final String pAdresseLivraison, final String pTelephone
				, final String pEmail) {
		
		this(null, pNom, pPrenom, pAdresseLivraison, pTelephone, pEmail);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Client(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/> 
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : 
	 * adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/> 
	 */
	public Client(
			final Long pId
				, final String pNom, final String pPrenom
				, final String pAdresseLivraison, final String pTelephone
				, final String pEmail) {
		
		super(pId, pNom, pPrenom, pAdresseLivraison, pTelephone, pEmail);
		
	} // Fin du CONSTRUCTEUR COMPLET BASE._________________________________
	

	
} // FIN DE LA CLASSE Client.------------------------------------------------
