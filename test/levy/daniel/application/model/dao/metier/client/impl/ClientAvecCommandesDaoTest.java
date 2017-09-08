package levy.daniel.application.model.dao.metier.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.junit.Test;

import levy.daniel.application.model.metier.client.IClient;
import levy.daniel.application.model.metier.client.impl.ClientACommandes;
import levy.daniel.application.model.metier.commande.impl.Commande;

/**
 * class ClientAvecCommandesDaoTest :<br/>
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
 * @since 8 sept. 2017
 *
 */
public class ClientAvecCommandesDaoTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ClientAvecCommandesDaoTest.class);
	
	
	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ClientAvecCommandesDaoTest() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public ClientAvecCommandesDaoTest() {
		super();
	}

	
	
	/**
	 * method testCreate() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Test
	public void testCreate() {
		
		final List<Commande> list  
		= new ArrayList<Commande>();
		
		DateTime date1 =  new DateTime();
		
		final Commande commande1 = new Commande(date1, 55.69D, "CB", "en cours", "48h chrono", "en cours", null);
		final Commande commande2 = new Commande(date1, 75.69D, "CB", "en cours", "48h chrono", "en cours", null);
		
		list.add(commande1);
		list.add(commande2);
		
		final IClient client = new ClientACommandes(
				"Zorro", "papy"
				, "10 rue des pins", "0164589874", "papy.gonzales@free.fr"
				, list);
		
	}


}
