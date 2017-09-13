package levy.daniel.application.model.dao.metier.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGeneric;
import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class AbstractDaoClient :<br/>
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
 * @since 8 sept. 2017
 *
 */
public class AbstractDaoClient 
	extends AbstractDaoGeneric<AbstractClient> implements IDaoClient {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoClient.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractDaoClient() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public AbstractDaoClient() {
		super();
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient retrieveByIdMetier(
			final AbstractClient pClient) {
		return null;
	}


}
