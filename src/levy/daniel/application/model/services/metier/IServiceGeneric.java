package levy.daniel.application.model.services.metier;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.services.valideurs.IValideurGeneric;
import levy.daniel.application.model.services.valideurs.LigneRapportValidation;

/**
 * class IServiceGeneric :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Généricité, Type paramétré, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 25 août 2017
 *
 */
public interface IServiceGeneric<T> {

		
	
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
	

	
	/**
	 * method validate(
	 * T pObject) :<br/>
	 * <ul>
	 * <li>valide l'Objet métier de type paramétré T pObject.</li>
	 * <li>retourne une map&lt;String, map&lt;String, String&gt;&gt; 
	 * contenant les messages d'erreur avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le message d'erreur.</li>
	 * <li>map&lt;String, String&gt; : une map contenant la RG violée 
	 * ainsi que le message d'erreur relatif à la RG.</li>
	 * </ul>
	 * </ul>
	 * <br/>
	 *
	 * @param pObject : T : Objet métier de type paramétré T.<br/>
	 * 
	 * @return : map&lt;String, map&lt;String, String&gt;&gt; : 
	 * Map contenant les attributs de l'Objet métier violant des RG 
	 * ainsi que les messages d'erreur relatifs aux RG violées.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	Map<String, Map<String, String>> validate(T pObject) 
			throws MalformedURLException;
	

	
	/**
	 * method fournirEnTeteCsvRGImplementees() :<br/>
	 * Retourne l'en-Tête Csv pour la liste des 
	 * règles de gestion implémentées dans ce service.<br/>
	 * <br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 */
	String fournirEnTeteCsvRGImplementees();


	
	/**
	 * method fournirStringListeCsvRGImplementees() :<br/>
	 * <ul>
	 * <li>fournit sous forme de String en csv avec séparateur ':' 
	 * la liste des règles de gestions contrôlées 
	 * dans le présent Service.</li>
	 * </ul>
	 * retourne null si this.listeRGImplementees == null.<br/>
	 * <br/>
	 * Une règle de gestion est décomposée comme suit :<br/>
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : liste des règles de gestions contrôlées 
	 * dans le présent Service en CSV.<br/>
	 */
	String fournirStringListeCsvRGImplementees();
	

	
	/**
	 * method fournirNomObjetMetier() :<br/>
	 * Retourne le nom de la classe de l'objet métier géré 
	 * par la présente classe de service.<br/>
	 * <br/>
	 * Par exemple : "Classe Client".<br/>
	 * <br/>
	 *
	 * @return : String : Nom de l'objet métier 
	 * géré par la présente classe de service.<br/>
	 */
	String fournirNomObjetMetier();

	
	
	/**
	 * method founirNomClasse() :<br/>
	 * Retourne le nom de la présente classe de service.<br/>
	 * <br/>
	 * Par exemple : "Classe ClientService".<br/>
	 *
	 * @return : String : nom de la présente classe de service.<br/>
	 */
	String founirNomClasse();

	

	/**
	 * method getValideur() :<br/>
	 * Getter du Valideur dédié à la validation de l'objet métier 
	 * de type paramétré T traité par ce service.<br/>
	 * <br/>
	 *
	 * @return valideur : IValideurGeneric<T>.<br/>
	 */
	IValideurGeneric<T> getValideur();
	
	
	
	/**
	 * method getListeRGImplementees() :<br/>
	 * Getter de la Liste des RG implémentées dans le Service.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @return listeRGImplementees : List&lt;LigneRG&gt;.<br/>
	 */
	List<LigneRG> getListeRGImplementees();

	
	
	/**
	 * method getErreurs() :<br/>
	 * Getter de la map&lt;String, map&lt;String, String&gt;&gt; 
	 * contenant les messages d'erreur avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le message d'erreur (par exemple "prénom").</li>
	 * <li>map&lt;String, String&gt; : une map contenant :
	 * <ul>
	 * <li>String : le nom de la RG violée (par exemple 
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.").</li>
	 * <li>String : le message d'erreur relatif à la RG 
	 * (par exemple : "Le nom n'est pas renseigné (obligatoire).").</li>
	 * </ul>
	 * </ul>
	 * </ul>
	 * <br/>
	 *
	 * @return erreurs : map&lt;String, map&lt;String, String&gt;&gt;.<br/>
	 */
	Map<String, Map<String, String>> getErreurs();
	
	
	
	/**
	 * method getControles() :<br/>
	 * Getter de la map&lt;String, map&lt;String
	 * , LigneRapportValidation&gt;&gt; 
	 * contenant les rapports de contrôle (validation) avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le rapport de contrôle (par exemple "prénom").</li>
	 * <li>map&lt;String, LigneRapportValidation&gt; : une map contenant :
	 * <ul>
	 * <li>String : le nom de la RG violée (par exemple 
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.").</li>
	 * <li>LigneRapportValidation : Pure fabrication encapsulant 
	 * tous les éléments d'information relatifs à un contrôle 
	 * (validation d'une RG).</li>
	 * <br/>
	 * Une LigneRapportValidation encapsule : <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * </ul>
	 * </ul>
	 * </ul>
	 * <br/>
	 *
	 * @return controles : map&lt;String, map&lt;String
	 * , LigneRapportValidation&gt;&gt;.<br/>
	 */
	Map<String, Map<String, LigneRapportValidation>> getControles();
	

	
	/**
	 * method getControlesList() :<br/>
	 * Getter de la Liste des Pures fabrications encapsulant 
	 * tous les éléments d'information relatifs à un contrôle 
	 * (validation d'une RG).</li>
	 * <br/>
	 * Une LigneRapportValidation encapsule : <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * </ul>
	 * </ul>
	 * </ul>
	 * <br/>
	 *
	 * @return controlesList : 
	 * List&lt;LigneRapportValidation&gt;.<br/>
	 */
	List<LigneRapportValidation> getControlesList();

	
	
	/**
	 * method getValide() :<br/>
	 * Getter du Boolean qui stipule si le contrôle effectué 
	 * par le validateur est sans erreur ou pas.<br/>
	 * <br/>
	 *
	 * @return valide : Boolean.<br/>
	 */
	Boolean getValide();
	
	
	
} // FIN DE L'INTERFACE IServiceGeneric<T>.--------------------------------
