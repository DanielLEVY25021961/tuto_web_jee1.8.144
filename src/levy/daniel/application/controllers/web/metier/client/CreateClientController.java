package levy.daniel.application.controllers.web.metier.client;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.services.metier.IServiceGeneric;
import levy.daniel.application.model.services.metier.client.impl.ClientService;

/**
 * class CreateClientController :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
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
 * @since 24 août 2017
 *
 */
public class CreateClientController extends HttpServlet {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * PARAM_NOM : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "nomClient".<br/>
	 */
	public static final String PARAM_NOM = "nomClient";

	
	/**
	 * PARAM_PRENOM : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "prenomClient".<br/>
	 */
	public static final String PARAM_PRENOM = "prenomClient";

	
	/**
	 * PARAM_ADRESSE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "adresseClient".<br/>
	 */
	public static final String PARAM_ADRESSE = "adresseClient";

	
	/**
	 * PARAM_TELEPHONE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "telephoneClient".<br/>
	 */
	public static final String PARAM_TELEPHONE = "telephoneClient";

	
	/**
	 * PARAM_EMAIL : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "emailClient".<br/>
	 */
	public static final String PARAM_EMAIL = "emailClient";

	
	/**
	 * ATTR_CLIENT : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "client".<br/>
	 */
	public static final String ATTR_CLIENT = "client";

	
	/**
	 * ATTR_MESSAGE : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "message".<br/>
	 */
	public static final String ATTR_MESSAGE = "message";

	
	/**
	 * ATTR_ERREURS : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "erreurs".<br/>
	 */
	public static final String ATTR_ERREURS = "erreurs";

	
	/**
	 * ATTR_ERREUR : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "erreur".<br/>
	 */
	public static final String ATTR_ERREUR = "erreur";

	
	/**
	 * ATTR_ARIANE : String :<br/>
	 * "ariane".<br/>
	 */
	public static final String ATTR_ARIANE = "ariane";

	
	/**
	 * MESSAGE_ARIANE : String :<br/>
	 * "créer un client".<br/>
	 */
	public static final String MESSAGE_ARIANE = "créer un client";
	
	
	/**
	 * VUE_CREATE_CLIENT : String :<br/>
	 * "/WEB-INF/vues/web/metier/client/formulaires/createClient.jsp".<br/>
	 */
	public static final String VUE_CREATE_CLIENT 
		= "/WEB-INF/vues/web/metier/client/formulaires/createClient.jsp";

		
	/**
	 * VUE_CIBLE_OK : String :<br/>
	 * Vue à atteindre si le formulaire est valide.<br/>
	 * "/WEB-INF/vues/web/metier/client/afficherClient.jsp".<br/>
	 */
	public static final String VUE_CIBLE_OK 
		= "/WEB-INF/vues/web/metier/client/afficherClient.jsp";

	
	/**
	 * VUE_CIBLE_KO : String :<br/>
	 * Vue à atteindre si le formulaire n'est PAS valide.<br/>
	 * "/WEB-INF/vues/web/metier/client/formulaires/createClient.jsp".<br/>
	 */
	public static final String VUE_CIBLE_KO 
		= "/WEB-INF/vues/web/metier/client/formulaires/createClient.jsp";
	
	
	/**
	 * SAUT_LIGNE_HTML : String :<br/>
	 * "&lt;br/&gt;".<br/>
	 */
	public static final String SAUT_LIGNE_HTML = "<br/>";

	
	/**
	 * DEBUT_MESSAGE_ERREUR : String :<br/>
	 * "Erreur - Vous n'avez pas rempli tous 
	 * les champs obligatoires concernant ".<br/>
	 */
	public static final String DEBUT_MESSAGE_ERREUR 
		= "Erreur - Vous n'avez pas rempli tous les "
				+ "champs obligatoires concernant ";
	

	/**
	 * MESSAGE_CREATION_OK : String :<br/>
	 * message à l'attention de l'utilisateur en cas 
	 * de succès de la création.<br/>
	 * "OK - Client créé avec succès !".<br/>
	 */
	public static final String MESSAGE_CREATION_OK 
		= "OK - Client créé avec succès !";
	
	
	/**
	 * MESSAGE_CREATION_KO : String :<br/>
	 * message à l'attention de l'utilisateur en cas 
	 * d'insuccès de la création.<br/>
	 * "KO - Impossible de créer le client !".<br/>
	 */
	public static final String MESSAGE_CREATION_KO 
		= "KO - Impossible de créer le client !";

	
	/**
	 * service : IServiceGeneric<AbstractClient> :<br/>
	 * Service.<br/>
	 */
	public transient IServiceGeneric<AbstractClient> service 
		= new ClientService();
	
	
	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(CreateClientController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CreateClientController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CreateClientController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(
			final HttpServletRequest pReq
				, final HttpServletResponse pResp) 
						throws ServletException, IOException {

		/* Récupération des noms des paramètres transmis dans la requête. */
		final Enumeration<String> parametresTransmis 
			= pReq.getParameterNames();
		
		
		/* Si l'internaute demande le formulaire de création 
		 * pour la première fois, l'énumération 
		 * des paramètres transmis est vide; */
		final boolean initialisation 
			= this.enumSize(parametresTransmis) == 0;

		// ****************************************************************
		// INITIALISATION.
		// ****************************************************************

		/* Lors de la première demande de formulaire 
		 * de création de commande par l'internaute. */
		if (initialisation) {
			
			/* FIL D'ARIANE. */
			pReq.setAttribute(ATTR_ARIANE, MESSAGE_ARIANE);
			
			/* Aiguillage vers la cible. */
			/* Tranfert de la requête/reponse. */
			this.getServletContext()
				.getRequestDispatcher(VUE_CREATE_CLIENT)
					.forward(pReq, pResp);
			
			return;
			
		} // Fin de if (initialisation)._____________________________
		
		
		// Hors initialisation.
		
		// ****************************************************************
		// LECTURE DES PARAMETRES DE REQUETE ET TRIM().
		// ****************************************************************
		
		/* Lit les paramètres passés dans le formulaire createCommande.jsp 
		 * et transmis dans la requête.*/
		/* TRIM(), cad retire les espaces inadéquats 
		 * dans les String lues dans le formulaire.*/
		
		/* CLIENT. ***/
		String paramNomClient = null;
		String paramPrenomClient = null;
		String paramAdresseClient = null;
		String paramTelephoneClient = null;
		String paramEmailClient = null;
		
		/* nom. */
		final String paramNomClientForm 
			= pReq.getParameter(PARAM_NOM);				
		if (!StringUtils.isBlank(paramNomClientForm)) {
			paramNomClient = paramNomClientForm.trim();
		}
		/* prenom. */ 
		final String paramPrenomClientForm 
			= pReq.getParameter(PARAM_PRENOM);		
		if (!StringUtils.isBlank(paramPrenomClientForm)) {
			paramPrenomClient = paramPrenomClientForm.trim();
		}
		/* adresseLivraison. */
		final String paramAdresseClientForm 
			= pReq.getParameter(PARAM_ADRESSE);		
		if (!StringUtils.isBlank(paramAdresseClientForm)) {
			paramAdresseClient = paramAdresseClientForm.trim();
		}
		/* telephone. */
		final String paramTelephoneClientForm 
			= pReq.getParameter(PARAM_TELEPHONE);		
		if (!StringUtils.isBlank(paramTelephoneClientForm)) {
			paramTelephoneClient = paramTelephoneClientForm.trim();
		}
		/* email. */
		final String paramEmailClientForm 
			= pReq.getParameter(PARAM_EMAIL); 		
		if (!StringUtils.isBlank(paramEmailClientForm))	{
			paramEmailClient = paramEmailClientForm.trim();
		}
		
						
		// ****************************************************************
		/* CREATION DES BEANS. */
		// ****************************************************************
		
		/* client. */
		final AbstractClient client 
			= new Client(paramNomClient, paramPrenomClient
					, paramAdresseClient, paramTelephoneClient
						, paramEmailClient);


		String messageUtilisateur = null;
		boolean formulaireValide = false;

		
		// ****************************************************************
		// VALIDATION DU FORMULAIRE.
		// ****************************************************************
		// APPEL DU SERVICE.
		final Map<String, Map<String, String>> erreurs 
			= this.service.validate(client);
		
		formulaireValide = this.service.getValide();
		
		
		/* VERIFICATION DU REMPLISSAGE. ********************************/		
		final StringBuilder messageUtilisateurStb = new StringBuilder();
		
		// ****************************************************************
		// CONSTITUTION DU MESSAGE UTILISATEUR.
		// ****************************************************************

		if (formulaireValide) {
			
			messageUtilisateurStb.append(MESSAGE_CREATION_OK);
			
			messageUtilisateur = messageUtilisateurStb.toString();
		}
		else {
								
			messageUtilisateurStb.append(MESSAGE_CREATION_KO);
			
			messageUtilisateur = messageUtilisateurStb.toString();
		}

		// ************************************************************
		// AJOUT DU BEAN, DU MESSAGE et de l'ERREUR 
		// AUX ATTRIBUTS DE LA REQUETE.
		// ************************************************************
		pReq.setAttribute(ATTR_CLIENT, client);
		pReq.setAttribute(ATTR_MESSAGE, messageUtilisateur);
		pReq.setAttribute(ATTR_ERREUR, formulaireValide);
		pReq.setAttribute(ATTR_ERREURS, erreurs);

		// ************************************************************
		// AIGUILLAGE VERS LA CIBLE et transfert de la requête/reponse.
		// ************************************************************
		if (formulaireValide) {
			
			/* Fil d'ariane. */
			final String ariane = "client";
			pReq.setAttribute(ATTR_ARIANE, ariane);
			
			/* Chemin de la jsp à atteindre si OK.*/
			/* Aiguillage vers la cible. */
			/* Tranfert de la requête/reponse. */
			this.getServletContext()
				.getRequestDispatcher(VUE_CIBLE_OK)
					.forward(pReq, pResp);
			
			return;
			
		} // Fin de if (formulaireValide).________________________
		
		/* Fil d'Ariane*/
		pReq.setAttribute(ATTR_ARIANE, MESSAGE_ARIANE);
	
		/* Chemin de la jsp à atteindre si KO.*/		
		/* Aiguillage vers la cible. */
		/* Tranfert de la requête/reponse. */
		this.getServletContext()
			.getRequestDispatcher(VUE_CIBLE_KO)
				.forward(pReq, pResp);


	} // Fin de doGet(...).________________________________________________
	

		
	/**
	 * method enumSize(
	 * Enumeration&lt;String&gt; pEnum) :<br/>
	 * Retourne le nombre d'éléments dans une 
	 * Enumeration&lt;String&gt; pEnum.<br/>
	 * <br/>
	 *
	 * @param pEnum : Enumeration&lt;String&gt;.<br/>
	 * 
	 * @return : Long : nombre d'éléments.<br/>
	 */
	private Long enumSize(
			final Enumeration<String> pEnum) {
		
		/* retourne 0 si pEnum == null. */
		if (pEnum == null) {
			return 0L;
		}
		
		Long resultat = 0L;
		
		while (pEnum.hasMoreElements()) {
			pEnum.nextElement();
			resultat++;
		}
		
		return resultat;
		
	} // Fin de enumSize(...)._____________________________________________

	

	
} // FIN DE LA CLASSE CreateClientController.--------------------------------
