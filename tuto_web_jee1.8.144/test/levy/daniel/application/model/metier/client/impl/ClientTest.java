package levy.daniel.application.model.metier.client.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * class ClientTest :<br/>
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
public class ClientTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ClientTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ClientTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ClientTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testCompareAriteNulle() :<br/>
	 * Teste la méthode compareTo(...)
	 * <ul>
	 * <li>garantit que instanceAriteNulle
	 * .compareTo(instanceAriteNulle) == 0</li>
	 * </ul>
	 */
	@Test
	public void testCompareAriteNulle() {
		
		final Client clientNull1 = new Client();
		final Client clientNull2 = new Client();
		
		final int compare = clientNull1.compareTo(clientNull2);
		
		/* garantit que instanceAriteNulle
		 * .compareTo(instanceAriteNulle) == 0. */
		assertEquals(
				"instanceAriteNulle.compareTo(instanceAriteNulle) == 0 : "
					, 0
						, compare);
		
	} // Fin de testCompareAriteNulle().___________________________________
	

	
	/**
	 * method testCompareAriteNulleNonNulle() :<br/>
	 * Teste la méthode compareTo(...)
	 * <ul>
	 * <li>garantit que instanceNomNONNull
	 * .compareTo(instanceNomNull) == -1. </li>
	 * <li>garantit que instancePrenomNONNull
	 * .compareTo(instancePrenomNull) == -1</li>
	 * <li>garantit que instanceEmailNONNull
	 * .compareTo(instanceEmailNull) == -1</li>
	 * </ul>
	 */
	@Test
	public void testCompareAriteNulleNonNulle() {
		
		final Client clientNull1 = new Client();
		final Client clientNull2 = new Client();
		
		clientNull1.setNom("Paris");
		
		final int compare1 = clientNull1.compareTo(clientNull2);
		final int compare1Inverse = clientNull2.compareTo(clientNull1);
		
		/* garantit que instanceNomNONNull
		 * .compareTo(instanceNomNull) == -1. */
		assertEquals(
				"instanceNomNONNull.compareTo(instanceNomNull) == -1 : "
					, -1
						, compare1);
		
		assertEquals(
				"instanceNomNull.compareTo(instanceNomNONNull) == +1 : "
					, +1
						, compare1Inverse);
		
		clientNull1.setNom(null);
		clientNull2.setNom(null);
		clientNull1.setPrenom("papy");
		
		final int compare2 = clientNull1.compareTo(clientNull2);
		final int compare2Inverse = clientNull2.compareTo(clientNull1);

		/* garantit que instancePrenomNONNull
		 * .compareTo(instancePrenomNull) == -1. */
		assertEquals(
				"instancePrenomNONNull"
				+ ".compareTo(instancePrenomNull) == -1 : "
					, -1
						, compare2);
		
		assertEquals(
				"instancePrenomNull.compareTo(instancePrenomNONNull) == +1 : "
					, +1
						, compare2Inverse);
		
		clientNull1.setPrenom(null);
		clientNull2.setPrenom(null);
		
		clientNull1.setEmail("toto.fert@free.fr");
		
		final int compare3 = clientNull1.compareTo(clientNull2);
		final int compare3Inverse = clientNull2.compareTo(clientNull1);
		
		/* garantit que instanceEmailNONNull
		 * .compareTo(instancePrenomNull) == -1. */
		assertEquals(
				"instanceEmailNONNull"
				+ ".compareTo(instanceEmailNull) == -1 : "
					, -1
						, compare3);
		
		assertEquals(
				"instanceEmailNull.compareTo(instanceEmailNONNull) == +1 : "
					, +1
						, compare3Inverse);

		
	} // Fin de testCompareAriteNulleNonNulle().___________________________


	
	/**
	 * method testCompare() :<br/>
	 * Teste la méthode compareTo(...)
	 * <ul>
	 * <li>garantit le bon fonctionnement de compareTo().</li>
	 * </ul>
	 */
	@Test
	public void testCompare() {
		
		final Client client1 
		= new Client(
				1L, "Gonzalo", "Andy"
				, "London", "06.84.55.55.22"
				, "pastora.gerty@free.fr");
		final Client client2 
			= new Client(2L, "Gonzalo", "Papy"
					, "London", "06.84.55.55.21"
					, "pastor.gerty@free.fr");
		
		final int compare = client1.compareTo(client2);
		final int compareInverse = client2.compareTo(client1);
		
		assertTrue("client1 avant client2 : ", compare < 0);
		assertTrue("client2 après client1 : ", compareInverse > 0);
		
	} // Fin de testCompare()._____________________________________________
	
	
	
	/**
	 * method testContratsJava() :<br/>
	 * Teste la méthode compareTo(...)
	 * <ul>
	 * <li>garantit que client1.equals(client2) ===> 
	 * client1.hashCode() == client2.hashCode().</li>
	 * <li>garantit que client1.equals(client2) ===> 
	 * client1.compareTo(client2) == 0.</li>
	 * </ul>
	 */
	@Test
	public void testContratsJava() {
		
		final Client client1 
			= new Client(
					1L, "Gonzales", "Papy"
					, "Paris", "06.84.55.55.21"
					, "pastor.gerty@free.fr");
		final Client client2 
			= new Client(2L, "Gonzales", "Papy"
					, "Paris", "06.84.55.55.21"
					, "pastor.gerty@free.fr");
		
		assertEquals("client1.equals(client2) : ", client1, client2);
		
		/* garantit que client1.equals(client2) ===> 
		 * client1.hashCode() == client2.hashCode(). */
		assertTrue("client1.hashCode() == client2.hashCode() : "
				, client1.hashCode() == client2.hashCode());
		
		/* garantit que client1.equals(client2) ===> 
		 * client1.compareTo(client2) == 0. */
		assertEquals("client1.compareTo(client2) == 0"
				, 0
					, client1.compareTo(client2));
		
	} // Fin de testContratsJava().________________________________________
	
	
	
} // FIN DE LA CLASSE ClientTest.--------------------------------------------
