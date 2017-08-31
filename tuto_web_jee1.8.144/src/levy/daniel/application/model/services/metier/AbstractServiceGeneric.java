package levy.daniel.application.model.services.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.services.valideurs.IValideurGeneric;

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

	
	
} // FIN DE LA CLASSE AbstractServiceGeneric.--------------------------------
