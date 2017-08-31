package levy.daniel.application.apptechnic.configurationmanagers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.GestionnaireRG;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

/**
 * class LigneRGTest :<br/>
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
 * @since 27 août 2017
 *
 */
public class LigneRGTest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * RG_CLIENT_NOM_01 : String :<br/>
	 * Règle de Gestion.<br/>
	 * "RG-Client-01 : le nom du client doit être renseigné.".<br/>
	 */
	public static final String RG_CLIENT_01 
		= "RG-Client-01 : le nom du client doit être renseigné.";

	
	/**
	 * RG_CLIENT_NOM_01_MESSAGE : String :<br/>
	 * Message à l'attention de l'utilisateur.<br/>
	 * "Le nom n'est pas renseigné (obligatoire)."<br/>
	 */
	public static final String RG_CLIENT_01_MESSAGE 
		= "Le nom n'est pas renseigné (obligatoire).";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(LigneRGTest.class);
	

	// *************************METHODES************************************/	
	 /**
	 * method CONSTRUCTEUR LigneRGTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LigneRGTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	/**
	 * method testInstanciationNull() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testInstanciationNull() {
		
		final LigneRG ligneRG = new LigneRG();
		ligneRG.setActiviteControleAttribut(true);
		ligneRG.setActiviteRG(true);
		ligneRG.setTypeControleInt(1);
		
		System.out.println(ligneRG.toString());
		
		assertNotNull("ligneRG non null : ", ligneRG);
		
	} // Fin de testInstanciationNull().___________________________________


	
	/**
	 * method testInstanciationComplet() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testInstanciationComplet() {
		
		final LigneRG ligneRG 
			= new LigneRG(1L
					, true, true
					, RG_CLIENT_01
					, 1
					, RG_CLIENT_01_MESSAGE
					, "Client", "nom"
					, "Classe ClientService", "Méthode validerNom()");
		
		System.out.println(ligneRG.toString());
		
		assertNotNull("ligneRG non null : ", ligneRG);
		
	} // Fin de testInstanciationComplet().________________________________
	
	
	
	/**
	 * method testCompareTo() :<br/>
	 * .<br/>
	 * <br/>
	 * @throws MalformedURLException 
	 */
	@Test
	public void testCompareTo() throws MalformedURLException {
		
		final LigneRG ligneRG1 
			= GestionnaireRG.getLigneRG(GestionnaireRG.RG_CLIENT_NOM_01);
		final LigneRG ligneRG2 
			= GestionnaireRG.getLigneRG(GestionnaireRG.RG_CLIENT_NOM_02);
		
//		System.out.println("ligneRG1.compareTo(ligneRG2) = " 
//				+ ligneRG1.compareTo(ligneRG2));
		
		assertTrue("ligneRG1.compareTo(ligneRG2) < 0 : "
				, ligneRG1.compareTo(ligneRG2) < 0);
		
	} // Fin de testCompareTo().___________________________________________
	
	
	
} // FIN DE LA CLASSE LigneRGTest.-------------------------------------------
