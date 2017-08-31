package levy.daniel.application.model.services.metier.client;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.metier.client.impl.ClientService;

/**
 * class AbstractClientServiceTest :<br/>
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
 * @since 25 août 2017
 *
 */
public class AbstractClientServiceTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AbstractClientServiceTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractClientServiceTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractClientServiceTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method testFournirListeCsvRGImplementees() :<br/>
	 * .<br/>
	 * <br/>
	 * @throws MalformedURLException 
	 */
	@Test
	public void testFournirListeCsvRGImplementees() throws MalformedURLException {
		
		final AbstractClient client = new Client("Zorro27", null, null, null, null);
		
		final ClientService clientService = new ClientService();
		final Map<String, Map<String, String>> erreurs = clientService.validate(client);
		
		System.out.println("ERREURS : ");
		System.out.println(erreurs);
		
		System.out.println();
		System.out.println("LISTE DES RG IMPLEMENTEES DANS L'APPLICATION : ");
		System.out.println(clientService.fournirEnTeteCsvRGImplementees());
		System.out.println(clientService.fournirStringListeCsvRGImplementees());
		
	} // Fin de testFournirListeCsvRGImplementees()._______________________

	

} // FIN DE LA CLASSE AbstractClientServiceTest.-----------------------------
