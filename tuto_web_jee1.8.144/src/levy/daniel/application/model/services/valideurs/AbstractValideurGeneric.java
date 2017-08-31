package levy.daniel.application.model.services.valideurs;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;

/**
 * class AbstractValideurGeneric :<br/>
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
 * @since 30 août 2017
 *
 */
public abstract class AbstractValideurGeneric<T> 
		implements IValideurGeneric<T> {

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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractValideurGeneric.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR AbstractValideurGeneric() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractValideurGeneric() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract Map<String, Map<String, String>> validate(T pObject) 
			throws MalformedURLException;

	
	
	/**
	 * method alimenterListeRGImplementees(
	 * LigneRG pLigneRG) :<br/>
	 * <ul>
	 * <li>Ajoute une LigneRG à this.listeRGImplementees 
	 * comportant toutes les RG 
	 * contrôlées par la présente classe.</li>
	 * <li> Une ligneRG csv se présente comme suit :<br/> 
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".</li>
	 * </ul>
	 * <br/>
	 * retourne null si this.listeRGImplementees == null.<br/>
	 * <br/>
	 *
	 * @param pLigneRG : LigneRG.<br/>
	 * 
	 * @return : List&lt;LigneRG&gt; : this.listeRGImplementees.<br/>
	 */
	protected final List<LigneRG> alimenterListeRGImplementees(
				final LigneRG pLigneRG) {
		
		/* retourne null si this.listeRGImplementees == null. */
		if (this.listeRGImplementees == null) {
			return null;
		}
				
		this.listeRGImplementees.add(pLigneRG);
		
		return this.listeRGImplementees;
		
	} // Fin de alimenterListeRGImplementees(...)._________________________
	

	
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

		
	
} // FIN DE LA CLASSE AbstractValideurGeneric.-------------------------------
