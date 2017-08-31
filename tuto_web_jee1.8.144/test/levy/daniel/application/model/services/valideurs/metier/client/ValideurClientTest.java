package levy.daniel.application.model.services.valideurs.metier.client;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.valideurs.LigneRapportValidation;

/**
 * class ValideurClientTest :<br/>
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
 * @since 31 août 2017
 *
 */
public class ValideurClientTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ValideurClientTest.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ValideurClientTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ValideurClientTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testValiderNom() :<br/>
	 * .<br/>
	 * <br/>
	 * @throws MalformedURLException 
	 */
	@Test
	public void testValiderNom() throws MalformedURLException {
		
		final AbstractClient client = new Client("Zorro Gonzales 27", null, null, null, null);
		
		final ValideurClient valideurClient = new ValideurClient();
		final Map<String, Map<String, String>> erreurs = valideurClient.validate(client);
		
		System.out.println("ERREURS : ");
		System.out.println(erreurs);
		
		System.out.println();
		System.out.println("LISTE DES RG IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(valideurClient.fournirEnTeteCsvRGImplementees());
		System.out.println(valideurClient.fournirStringListeCsvRGImplementees());
		
		final Map<String, Map<String, LigneRapportValidation>> controles 
			= valideurClient.getControles();
		System.out.println();
		System.out.println("LISTE DES CONTROLES IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(controles);
		
		
	} // Fin de testValiderNom().__________________________________________


}
