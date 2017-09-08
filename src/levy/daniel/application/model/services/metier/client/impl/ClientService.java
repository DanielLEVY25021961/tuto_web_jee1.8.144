package levy.daniel.application.model.services.metier.client.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.xml.internal.bind.v2.model.core.ID;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.metier.client.AbstractClientService;

/**
 * class ClientService :<br/>
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
public class ClientService extends AbstractClientService {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_CLIENT_SERVICE : String :<br/>
	 * "Classe ClientService".<br/>
	 */
	public static final String CLASSE_CLIENT_SERVICE 
		= "Classe ClientService";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ClientService.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ClientService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ClientService() {
		
		super();
				
		this.objetMetier = new Client();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * "Classe ClientService".<br/>
	 */
	@Override
	public String founirNomClasse() {
		return CLASSE_CLIENT_SERVICE;
	} // Fin de founirNomClasse()._________________________________________




	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final AbstractClient pObject) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient retrieve(
			final AbstractClient pObject) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient getOne(
			final Long pId) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AbstractClient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AbstractClient> findAllMax(
			final Long pMax) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<AbstractClient> findAll(
			final Iterable<ID> pIds) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient update(
			final AbstractClient pObject) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends AbstractClient> S save(
			final S pEntity) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends AbstractClient> Iterable<S> save(
			final Iterable<S> pEntities) {
		// TODO Auto-generated method stub
		return null;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final AbstractClient pObject) {
		// TODO Auto-generated method stub
		return false;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(
			final Long pId) {
		// TODO Auto-generated method stub
		
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(
			final Iterable<? extends AbstractClient> pEntities) {
		// TODO Auto-generated method stub
		
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final ID pId) {
		// TODO Auto-generated method stub
		return false;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
} // FIN DE LA CLASSE ClientService.-----------------------------------------
