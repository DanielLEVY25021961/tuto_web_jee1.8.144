package levy.daniel.application.model.dao;

import java.util.List;

/**
 * class IDaoGeneric :<br/>
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
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 8 sept. 2017
 *
 */
public interface IDaoGeneric<T> {
	
	
	/**
	 * method create(T pObject) :<br/>
	 * Crée un Objet metier de type paramétré T pObject.<br/>
	 * <br/>
	 *
	 * @param pObject : T : Objet métier de type paramétré T.<br/>
	 * 
	 * @return : T : Objet métier de type paramétré T créé.<br/>
	 */
	T create(T pObject);


	
	
	/**
	 * method retrieve(
	 * T pObject) :<br/>
	 * Recherche un objet métier de Type paramétré T pObject en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré T 
	 * existant en base.<br/>
	 */
	T retrieve(T pObject);
	

	
	/**
	 * method getOne() :<br/>
	 * Retourne un Objet métier via son ID en base.<br/>
	 * Compatible avec SpringData.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base de l'Objet métier.
	 * 
	 * @return : T : Objet métier.<br/>
	 */
	T getOne(Long pId);
	
	
	
	/**
	 * method update(
	 * T pObject) :<br/>
	 * Modifie un objet métier de Type paramétré T 
	 * pObject existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré T 
	 * modifié en base.<br/>
	 */
	T update(T pObject);
	
	
	
	/**
	 * method delete(
	 * T pObject) :<br/>
	 * Détruit un un objet métier de Type paramétré T 
	 * existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : boolean : true si l'objet métier de Type paramétré T 
	 * a été détruit en base.<br/>
	 */
	boolean delete(T pObject);
	
	
	
	/**
	 * method delete(
	 * Long pId) :<br/>
	 * Détruit un un objet métier de Type paramétré T 
	 * existant en base via son ID.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 */
	void delete(Long pId);

	
	
	/**
	 * method findAll() :<br/>
	 * Retourne la liste de tous les objets métier de Type paramétré T 
	 * présents en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;T&gt; : 
	 * liste de tous les objets métier de Type paramétré T 
	 * présents en base.<br/>
	 */
	List<T> findAll();
	
	


} // FIN DE L'INTERFACE IDaoGeneric.---------------------------------------
