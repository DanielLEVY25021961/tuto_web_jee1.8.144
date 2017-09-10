package levy.daniel.application.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;


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
	 * 
	 * @throws HibernateException
	 * @throws IllegalStateException
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
	

	
	/* CREATE ************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T create(
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
	public final Long createReturnId(
			final T pObject) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de createReturnId(...)._______________________________________


	
	/* READ *************/
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T retrieve(
			final T pObject) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de retrieve(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T getOne(
			final Long pId) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de getOne(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de findAll()._________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAllMax(
			final Long pMax) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de findAllMax(...).___________________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<T> findAll(
			final Iterable<Long> pIds) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de findAll(...).______________________________________________


	
	/* UPDATE *************/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(
			final T pObject) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de update(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> S save(
			final S pObject) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de save(...)._________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> Iterable<S> save(
			final Iterable<S> pEntities) {
		
		// TODO Auto-generated method stub
		return null;
		
	} // Fin de save(...)._________________________________________________

	
	
	/* DELETE *************/
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final T pObject) {
		
		// TODO Auto-generated method stub
		return false;
		
	} // Fin de delete(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(
			final Long pId) {
		
		/***/	
		
	} // Fin de delete(...)._______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteBoolean(
			final Long pId) {
		
		return false;
		
	} // Fin de deleteBoolean(...).________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		
		/***/
		
	} // Fin de deleteAll()._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(
			final Iterable<? extends T> pEntities) {
		
		// TODO Auto-generated method stub
		
	} // Fin de delete(...)._______________________________________________

	
	
	/* TOOLS *************/
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) {
		
		// TODO Auto-generated method stub
		return false;
		
	} // Fin de exists(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() {
		
		// TODO Auto-generated method stub
		return 0L;
		
	} // Fin de count().___________________________________________________
	

	
} // FIN DE LA CLASSE AbstractDaoGeneric.------------------------------------
