package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * class GestionnaireRGTest :<br/>
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
 * @since 30 août 2017
 *
 */
public class GestionnaireRGTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(GestionnaireRGTest.class);
	
	
	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR GestionnaireRGTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnaireRGTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method testAfficherListeRGImplementeesCsv() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testAfficherListeRGImplementeesCsv() {
		
		final String listeCsvRG 
			= GestionnaireRG.afficherListeRGImplementeesCsv();
		
		System.out.println(listeCsvRG);
		
	} // Fin de testAfficherListeRGImplementeesCsv().______________________

	

} // FIN DE LA CLASSE GestionnaireRGTest.------------------------------------
