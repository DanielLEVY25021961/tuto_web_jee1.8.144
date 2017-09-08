package levy.daniel.application.model.dao;

import java.util.List;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * class IDaoGeneric :<br/>
 * .<br/>
 * <br/>
 * - Exemple d'utilisation :<br/>
 * <br/>
 * - Mots-clé :<br/>
 * <br/>
 * - Dépendances :<br/>
 * <br/>
 *
 * @author dan Lévy
 * @version 1.0
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 8 sept. 2017
 */
public interface IDaoGeneric<T> {

	/* CREATE */

	/**
	 * method create(T pObject) :<br/>
	 * Crée un Objet metier de type paramétré T pObject.<br/>
	 * <br/>
	 *
	 * @param pObject : T : Objet métier de type paramétré T.<br/>
	 * @return : T : Objet métier de type paramétré T créé.<br/>
	 */
	T create(T pObject);

	/**
	 * method createReturnId(T pObject) :<br/>
	 * Crée un Objet metier de type paramétré T pObject.<br/>
	 * <br/>
	 *
	 * @param pObject : T : Objet métier de type paramétré T.<br/>
	 * @return : T : Objet métier de type paramétré T créé.<br/>
	 */
	Long createReturnId(T pObject);

	/* READ */

	/**
	 * method retrieve( T pObject) :<br/>
	 * Recherche un objet métier de Type paramétré T pObject en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * @return : T : objet métier de Type paramétré T existant en base.<br/>
	 */
	T retrieve(T pObject);

	/**
	 * method getOne() :<br/>
	 * Retourne un Objet métier via son ID en base.<br/>
	 * Compatible avec SpringData.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base de l'Objet métier.
	 * @return : T : Objet métier.<br/>
	 */
	T getOne(Long pId);

	/**
	 * method findAll() :<br/>
	 * Retourne la liste de tous les objets métier de Type paramétré T présents en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;T&gt; : liste de tous les objets métier de Type paramétré T présents en
	 *         base.<br/>
	 */
	List<T> findAll();

	/**
	 * method findAll() :<br/>
	 * Retourne la liste de tous les objets métier de Type paramétré T présents en base.<br/>
	 * <br/>
	 * @param pMax 
	 *
	 * @return : List&lt;T&gt; : liste de tous les objets métier de Type paramétré T présents en
	 *         base.<br/>
	 */
	List<T> findAllMax(Long pMax);

	/**
	 * Returns all instances of the type with the given IDs.
	 *
	 * @param ids
	 * @return Iterable<T>
	 */
	Iterable<T> findAll(Iterable<ID> ids);

	/* UPDATE */

	/**
	 * method update( T pObject) :<br/>
	 * Modifie un objet métier de Type paramétré T pObject existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * @return : T : objet métier de Type paramétré T modifié en base.<br/>
	 */
	T update(T pObject);

	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation
	 * might have changed the entity instance completely.
	 *
	 * @param entity
	 * @return the saved entity
	 */
	<S extends T> S save(S entity);

	/**
	 * Saves all given entities.
	 *
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	<S extends T> Iterable<S> save(Iterable<S> entities);

	/* DELETE */

	/**
	 * method delete( T pObject) :<br/>
	 * Détruit un un objet métier de Type paramétré T existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * @return : boolean : true si l'objet métier de Type paramétré T a été détruit en base.<br/>
	 */
	boolean delete(T pObject);

	/**
	 * method delete( Long pId) :<br/>
	 * Détruit un un objet métier de Type paramétré T existant en base via son ID.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 */
	void delete(Long pId);

	/**
	 * Deletes all entities managed by the repository.
	 */
	void deleteAll();

	/**
	 * Deletes the given entities.
	 *
	 * @param entities
	 * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
	 */
	void delete(Iterable<? extends T> entities);

	/* TOOLS */

	/**
	 * Returns whether an entity with the given id exists.
	 *
	 * @param id must not be {@literal null}.
	 * @return true if an entity with the given id exists, {@literal false} otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean exists(ID id);

	/**
	 * Returns the number of entities available.
	 *
	 * @return the number of entities
	 */
	long count();

} // FIN DE L'INTERFACE IDaoGeneric.---------------------------------------
