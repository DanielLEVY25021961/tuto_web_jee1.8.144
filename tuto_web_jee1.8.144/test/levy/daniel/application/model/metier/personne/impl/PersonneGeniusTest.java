package levy.daniel.application.model.metier.personne.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * class PersonneGeniusTest :<br/>
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
 * @since 19 août 2017
 *
 */
public class PersonneGeniusTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(PersonneGeniusTest.class);


	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR PersonneGeniusTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneGeniusTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * method testInstanciation() :<br/>
	 * Vérifie que le constructeur fonctionne.<br/>
	 * <br/>
	 */
	@Test
	public void testInstanciation() {
		
		final PersonneGenius premierBeanPapy 
		= new PersonneGenius("Papy", "Gonzales", true);
		
		assertEquals("Prénom Papy : ", "Papy", premierBeanPapy.getPrenom());
		assertEquals("Nom Gonzales : ", "Gonzales", premierBeanPapy.getNom());
		assertTrue("Genial : true", premierBeanPapy.getGenius());
		
	} // Fin de testInstanciation()._______________________________________

	

} // FIN DE LA CLASSE PersonneGeniusTest.------------------------------------
