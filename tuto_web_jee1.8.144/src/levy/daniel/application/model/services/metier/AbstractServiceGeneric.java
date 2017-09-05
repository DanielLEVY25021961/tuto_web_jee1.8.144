package levy.daniel.application.model.services.metier;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.services.valideurs.IValideurGeneric;
import levy.daniel.application.model.services.valideurs.LigneRapportValidation;

/**
 * class AbstractServiceGeneric :<br/>
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
 * @since 26 août 2017
 *
 */
public abstract class AbstractServiceGeneric<T> implements IServiceGeneric<T> {

	// ************************ATTRIBUTS************************************/

		
	/**
	 * listeRGImplementees : List&lt;LigneRG&gt; :<br/>
	 * Liste des RG implémentées dans le Service.<br/>
	 * Une LigneRG encapsule :<br/>
	 * <br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 */
	protected transient List<LigneRG> listeRGImplementees 
		= new ArrayList<LigneRG>();

	
	/**
	 * objetMetier : T :<br/>
	 * Objet métier géré par le présent service.<br/>
	 */
	protected transient T objetMetier;

	
	/**
	 * valideur : IValideurGeneric<T> :<br/>
	 * Valideur dédié à la validation de l'objet métier 
	 * de type paramétré T traité par ce service.<br/>
	 */
	protected transient IValideurGeneric<T> valideur;
	
	
		
	/**
	 * erreurs : Map<String,Map<String,String>> :<br/>
	 * map&lt;String, map&lt;String, String&gt;&gt; 
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
	 */
	protected transient Map<String, Map<String, String>> erreurs 
			= new ConcurrentHashMap<String, Map<String, String>>();
	
	
	/**
	 * controles : Map<String,Map<String,LigneRapportValidation>> :<br/>
	 * map&lt;String, map&lt;String, LigneRapportValidation&gt;&gt; 
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
	 */
	protected transient Map<String, Map<String, LigneRapportValidation>> controles 
	= new ConcurrentHashMap<String, Map<String, LigneRapportValidation>>();

	
	/**
	 * controlesList : List&lt;LigneRapportValidation&gt; :<br/>
	 * Liste des Pures fabrications encapsulant 
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
	 */
	protected transient List<LigneRapportValidation> controlesList 
		= new ArrayList<LigneRapportValidation>();

	
	/**
	 * valide : Boolean :<br/>
	 * Boolean qui stipule si le contrôle effectué par le validateur 
	 * est sans erreur ou pas.<br/>
	 */
	protected transient Boolean valide;
	
	
	/**
	 * SAUT_LIGNE : String :<br/>
	 * "\n".<br/>
	 */
	public static final String SAUT_LIGNE = "\n";
	

	/**
	 * SAUT_LIGNE_HTML : String :<br/>
	 * "<br/>".<br/>
	 */
	public static final String SAUT_LIGNE_HTML = "<br/>";
	
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractServiceGeneric.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractServiceGeneric() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractServiceGeneric() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final T pObject) 
					throws MalformedURLException {
		
		this.valideur.validate(pObject);
		
		/* Remplit this.erreurs. */
		this.erreurs.putAll(this.valideur.getErreurs());
		
		/* Remplit this.Controle */
		this.controles.putAll(this.valideur.getControles());
		
		/* Remplit this.listeRGImplementees. */
		this.listeRGImplementees.addAll(
				this.valideur.getListeRGImplementees());
		
		/* Remplit this.controlesList. */
		this.controlesList.addAll(this.valideur.getControlesList());
		
		/* Remplit this.valide. */
		this.valide = this.valideur.getValide();
		
		return this.erreurs;
		
	} // Fin de validate(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirEnTeteCsvRGImplementees() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;";
		
	} // Fin de fournirEnTeteCsvRGImplementees().__________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringListeCsvRGImplementees() {
		
		/* retourne null si this.listeRGImplementees == null. */
		if (this.listeRGImplementees == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final LigneRG ligneRGCsv : this.listeRGImplementees) {
			stb.append(ligneRGCsv.toStringCsv());
			stb.append('\n');
		}
				
		return stb.toString();
		
	} // Fin de fournirStringListeCsvRGImplementees()._____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirNomObjetMetier() {
		return this.objetMetier.getClass().getSimpleName();
	} // Fin de fournirNomObjetMetier().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String founirNomClasse();
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IValideurGeneric<T> getValideur() {
		return this.valideur;
	} // Fin de getValideur()._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRG> getListeRGImplementees() {
		return this.listeRGImplementees;
	} // Fin de getListeRGImplementees().__________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, Map<String, String>> getErreurs() {
		return this.erreurs;
	} // Fin de getErreurs().______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, Map<String, LigneRapportValidation>> getControles() {
		return this.controles;
	} // Fin de getControles().____________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRapportValidation> getControlesList() {
		return this.controlesList;
	} // Fin de getControlesList().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Boolean getValide() {
		return this.valide;
	} // Fin de getValide()._______________________________________________

		
	
} // FIN DE LA CLASSE AbstractServiceGeneric.--------------------------------
