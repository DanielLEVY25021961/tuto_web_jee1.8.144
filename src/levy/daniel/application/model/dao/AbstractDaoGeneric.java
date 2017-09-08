package levy.daniel.application.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * class AbstractDaoGeneric :<br/>
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
 *  @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 8 sept. 2017
 *
 */
public abstract class AbstractDaoGeneric<T> implements IDaoGeneric<T> {

	// ************************ATTRIBUTS************************************/

	/**
	 * session : Session :<br/>
	 * org.hibernate.session.<br/>
	 */
	private transient Session session;

	
	/**
	 * entityManagerFactory : EntityManagerFactory :<br/>
	 * JPA EntityManagerFactory.<br/>
	 */
	private transient EntityManagerFactory entityManagerFactory;
	
	
	/**
	 * entityManager : EntityManager :<br/>
	 * DAO « ListeCoursesDAO » utilise le « EntityManager » pour 
	 * lister les entités « Course » contenues dans la base de données.<br/>
	 */
	private transient EntityManager entityManager;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(AbstractDaoGeneric.class);



	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractDaoGeneric() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoGeneric() {
		
		super();
		
		/* Lance la persistence. */
		this.buildEntityManager();
		
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________
	
	
	
	/**
	 * method buildEntityManager() :<br/>
	 * <ul>
	 * <li>Récupère la session Hibernate auprès de HibernateUtilNG.</li>
	 * <li>Récupère la Factory auprès de la Session.</li>
	 * <li>Récupère l'EntityManager auprès de la Factory.</li>
	 * </ul>
	 */
	private void buildEntityManager() 
			throws HibernateException, IllegalStateException {
		
		/* Récupère la session Hibernate auprès de HibernateUtilNG. */
		this.session = HibernateUtilNG.currentSession();
		
		/* Récupère la Factory auprès de la Session. */
		this.entityManagerFactory 
			= this.session.getEntityManagerFactory();
		
		/* Récupère l'EntityManager auprès de la Factory. */
		this.entityManager 
			= this.entityManagerFactory.createEntityManager();
				
	} // Fin de buildEntityManager().______________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T create(
			final T pObject) {

		/* Persiste en base. */
		this.entityManager.persist(pObject);
		
		/* retourne. */
		return pObject;
		
	} // Fin de create(...)._______________________________________________

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(T pObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T retrieve(T pObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getOne(Long pId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAllMax(Long pMax) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<T> findAll(Iterable<ID> pIds) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(T pObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> S save(S pEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> Iterable<S> save(Iterable<S> pEntities) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(T pObject) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Long pId) {
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
	public void delete(Iterable<? extends T> pEntities) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(ID pId) {
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
	}}
