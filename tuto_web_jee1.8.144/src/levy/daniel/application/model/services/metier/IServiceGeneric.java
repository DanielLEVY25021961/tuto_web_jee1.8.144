package levy.daniel.application.model.services.metier;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;

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
	
	
	
} // FIN DE L'INTERFACE IServiceGeneric<T>.--------------------------------
