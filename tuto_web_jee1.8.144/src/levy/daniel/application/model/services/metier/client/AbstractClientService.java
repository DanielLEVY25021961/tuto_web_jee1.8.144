package levy.daniel.application.model.services.metier.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.services.metier.AbstractServiceGeneric;
import levy.daniel.application.model.services.valideurs.metier.client.ValideurClient;

/**
 * class AbstractClientService :<br/>
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
 * @since 25 août 2017
 *
 */
public abstract class AbstractClientService 
	extends AbstractServiceGeneric<AbstractClient> implements IClientService {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_CLIENT_SERVICE : String :<br/>
	 * "Classe AbstractClientService".<br/>
	 */
	public static final String CLASSE_ABSTRACT_CLIENT_SERVICE 
		= "Classe AbstractClientService";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractClientService.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractClientService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractClientService() {
		
		super();
		
		this.valideur = new ValideurClient();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 * @throws MalformedURLException 
	 */
//	@Override
//	public Map<String, Map<String, String>> validate(
//			final AbstractClient pClient) throws MalformedURLException {
//		
//		this.valideur.validate(pClient);
//		
//		/* Remplit this.erreurs. */
//		this.erreurs.putAll(this.valideur.getErreurs());
//		
//		/* Remplit this.Controle */
//		this.controles.putAll(this.valideur.getControles());
//		
//		/* Remplit this.listeRGImplementees. */
//		this.listeRGImplementees.addAll(
//				this.valideur.getListeRGImplementees());
//		
//		/* Remplit this.controlesList. */
//		this.controlesList.addAll(this.valideur.getControlesList());
//		
//		return this.erreurs;
//		
//	} // Fin de valisate(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient create(
			final AbstractClient pObject) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient retrieveByIdMetier(
			final AbstractClient pClient) {
		// TODO Auto-generated method stub
		return null;
	}


			
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String founirNomClasse();
	

	
} // FIN DE LA CLASSE AbstractClientService.---------------------------------
