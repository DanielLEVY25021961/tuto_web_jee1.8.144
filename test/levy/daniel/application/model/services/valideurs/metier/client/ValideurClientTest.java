package levy.daniel.application.model.services.valideurs.metier.client;

import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.valideurs.IValideurGeneric;

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
	 * NOM : String :<br/>
	 * "nom".<br/>
	 */
	public static final String NOM = "nom";
	
	
	/**
	 * PRENOM : String :<br/>
	 * "prenom".<br/>
	 */
	public static final String PRENOM = "prenom";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
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
		
		final AbstractClient client = new Client("Zorro", "Daniel ", null, null, null);
		
		final IValideurGeneric<AbstractClient> valideurClient = new ValideurClient();
		
				
		/* Validation du client. */
		valideurClient.validate(client);
		
		/* VALIDE. */
		final Boolean valide = valideurClient.getValide();		
		System.out.println("VALIDE ? : " + valide);
		
		System.out.println();
		System.out.println("ERREURS : ");
		System.out.println(valideurClient.afficherErreurs());
		/* nom;RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;Le nom n'est pas renseigné (obligatoire).; */
		
		System.out.println();
		System.out.println("ERREURS SUR LE NOM: ");
		System.out.println(valideurClient.fournirMapErreursAttribut(NOM));
		System.out.println(valideurClient.fournirStringErreursAttribut(NOM, "\n"));
		/* Le nom n'est pas renseigné (obligatoire). */

		
		System.out.println();
		System.out.println("LISTE DES RG IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(
				valideurClient
					.fournirStringListeCsvRGImplementeesAvecEntete());
		

		System.out.println();
		System.out.println("LISTE DES CONTROLES IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(valideurClient.afficherControles());
		/* nom;RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;KO;Le champ nom est null ou vide (que des espaces);
		 * nom;RG_CLIENT_NOM_02 : le nom du client ne doit contenir que des lettres.;OK;Le champ nom est blank (null ou vide). Donc pas de chiffres !; */
		
		System.out.println();
		System.out.println("CONTROLES SUR LE NOM: ");
		System.out.println(valideurClient.fournirMapControlesAttribut(NOM));
		System.out.println(valideurClient.fournirStringControlesAttribut(NOM, "\n"));
		/* RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;KO;Le champ nom est null ou vide (que des espaces); */
		/* RG_CLIENT_NOM_02 : le nom du client ne doit contenir que des lettres.;OK;Le champ nom est blank (null ou vide). Donc pas de chiffres !; */
		
		
		
	} // Fin de testValiderNom().__________________________________________

	
	
	/**
	 * method testValiderPrenom() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @throws MalformedURLException :  :  .<br/>
	 */
	@Test
	public void testValiderPrenom() throws MalformedURLException {
		
		final AbstractClient client = new Client("Zorro27", "Daniel 27", null, null, null);
		
		final IValideurGeneric<AbstractClient> valideurClient = new ValideurClient();
		
		/* Validation du client. */
		valideurClient.validate(client);
		
		/* VALIDE. */
		final Boolean valide = valideurClient.getValide();		
		System.out.println("VALIDE ? : " + valide);

		System.out.println("ERREURS : ");
		System.out.println(valideurClient.afficherErreurs());
		/* nom;RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;Le nom n'est pas renseigné (obligatoire).; */
		
		System.out.println();
		System.out.println("ERREURS SUR LE PRENOM: ");
		System.out.println(valideurClient.fournirMapErreursAttribut(PRENOM));
		System.out.println(valideurClient.fournirStringErreursAttribut(PRENOM, "\n"));
		/* Le nom n'est pas renseigné (obligatoire). */

		
		System.out.println();
		System.out.println("LISTE DES RG IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(
				valideurClient
					.fournirStringListeCsvRGImplementeesAvecEntete());
		

		System.out.println();
		System.out.println("LISTE DES CONTROLES IMPLEMENTEES DANS LE VALIDEUR : ");
		System.out.println(valideurClient.afficherControles());
		/* nom;RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;KO;Le champ nom est null ou vide (que des espaces);
		 * nom;RG_CLIENT_NOM_02 : le nom du client ne doit contenir que des lettres.;OK;Le champ nom est blank (null ou vide). Donc pas de chiffres !; */
		
		System.out.println();
		System.out.println("CONTROLES SUR LE PRENOM: ");
		System.out.println(valideurClient.fournirMapControlesAttribut(PRENOM));
		System.out.println(valideurClient.fournirStringControlesAttribut(PRENOM, "\n"));
		/* RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;KO;Le champ nom est null ou vide (que des espaces); */
		/* RG_CLIENT_NOM_02 : le nom du client ne doit contenir que des lettres.;OK;Le champ nom est blank (null ou vide). Donc pas de chiffres !; */
		
	} // Fin de testValiderPrenom()._______________________________________
	
	

} // FIN DE LA CLASSE ValideurClientTest.------------------------------------
