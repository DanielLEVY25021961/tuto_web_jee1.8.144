package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	
	/**
	 * method testExpressionReguliere() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Test
	public void testExpressionReguliere() {
		
		/* Pattern "que des lettres". 
		 * + signifie au moins une lettre. */
		final Pattern pattern = Pattern.compile("\\D+");
		
		/* Moteur de recherche Matcher. */
		final Matcher matcher = pattern.matcher(" ");
		
		/* boolean qui stipule si le pattern est respecté. */
		final boolean match = matcher.matches();
		
		System.out.println(match);
		
	} // Fin de testExpressionReguliere()._________________________________
	
	

} // FIN DE LA CLASSE GestionnaireRGTest.------------------------------------
