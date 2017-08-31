package levy.daniel.application.controllers.web.metier.commande;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import levy.daniel.application.model.metier.client.AbstractClient;
import levy.daniel.application.model.metier.client.impl.Client;
import levy.daniel.application.model.metier.commande.AbstractCommande;
import levy.daniel.application.model.metier.commande.impl.Commande;

/**
 * class CreateCommandeController :<br/>
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
 * @since 21 août 2017
 *
 */
public class CreateCommandeController extends HttpServlet {

	// ************************ATTRIBUTS************************************/
	
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
	 * PARAM_DATE_COMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "dateCommande".<br/>
	 */
	public static final String PARAM_DATE_COMMANDE 
		= "dateCommande";

	
	/**
	 * PARAM_MONTANT_COMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "montantCommande".<br/>
	 */
	public static final String PARAM_MONTANT_COMMANDE 
		= "montantCommande";
	
	
	/**
	 * PARAM_MODE_PAIMENT_COMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "modePaiementCommande".<br/>
	 */
	public static final String PARAM_MODE_PAIMENT_COMMANDE 
		= "modePaiementCommande";
	
	
	/**
	 * PARAM_STATUT_PAIEMENT_COMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "statutPaiementCommande".<br/>
	 */
	public static final String PARAM_STATUT_PAIEMENT_COMMANDE 
		= "statutPaiementCommande";
	
	
	/**
	 * PARAM_MODE_LIVRAISON_COMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "modeLivraisonCommande".<br/>
	 */
	public static final String PARAM_MODE_LIVRAISON_COMMANDE 
		= "modeLivraisonCommande";
	
	
	/**
	 * PARAM_STATUT_LIVRAISON_COMMMANDE : String :<br/>
	 * Nom du paramètre transmis dans la requête par le formulaire.<br/>
	 * "statutLivraisonCommande".<br/>
	 */
	public static final String PARAM_STATUT_LIVRAISON_COMMMANDE 
		= "statutLivraisonCommande";
	
	
	/**
	 * ATTR_CLIENT : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "client".<br/>
	 */
	public static final String ATTR_CLIENT = "client";

	
	/**
	 * ATTR_COMMANDE : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "commande".<br/>
	 */
	public static final String ATTR_COMMANDE = "commande";

	
	/**
	 * ATTR_MESSAGE : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "message".<br/>
	 */
	public static final String ATTR_MESSAGE = "message";

	
	/**
	 * ATTR_ERREUR : String :<br/>
	 * Nom de l'attribut rajouté à la request 
	 * et transmis à une cible (JSP, ...).<br/>
	 * "erreur".<br/>
	 */
	public static final String ATTR_ERREUR = "erreur";
	

	/**
	 * VUE_CREATE_COMMANDE : String :<br/>
	 * Vue à atteindre lors du premier appel du formulaire.<br/>
	 * "/WEB-INF/vues/web/metier/commande/formulaires/createCommande.jsp".<br/>
	 */
	public static final String VUE_CREATE_COMMANDE 
		= "/WEB-INF/vues/web/metier/commande/formulaires/createCommande.jsp";

	
	/**
	 * VUE_CIBLE_OK : String :<br/>
	 * Vue à atteindre si le formulaire est valide.<br/>
	 * "/WEB-INF/vues/web/metier/commande/afficherCommande.jsp"
	 */
	public static final String VUE_CIBLE_OK 
		= "/WEB-INF/vues/web/metier/commande/afficherCommande.jsp";

	
	/**
	 * VUE_CIBLE_KO : String :<br/>
	 * Vue à atteindre si le formulaire n'est PAS valide.<br/>
	 * "/WEB-INF/vues/web/metier/commande/formulaires/createCommande.jsp"
	 */
	public static final String VUE_CIBLE_KO 
		= "/WEB-INF/vues/web/metier/commande/formulaires/createCommande.jsp";
	
	
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
	 * message à l'attention de l'utilisateur 
	 * en cas de succès de la création.<br/>
	 * "OK - Commande créée avec succès !".<br/>
	 */
	public static final String MESSAGE_CREATION_OK 
		= "OK - Commande créée avec succès !";
	
	
	/**
	 * MESSAGE_CREATION_KO : String :<br/>
	 * message à l'attention de l'utilisateur 
	 * en cas d'insuccès de la création.<br/>
	 * "KO - Impossible de créer la commande !".<br/>
	 */
	public static final String MESSAGE_CREATION_KO 
		= "KO - Impossible de créer la commande !";
	
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(CreateCommandeController.class);

	// *************************METHODES************************************/
	
	/**
	 * method CreateCommandeController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CreateCommandeController() {
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
			
			/* Aiguillage vers la cible. */
			/* Tranfert de la requête/reponse. */
			this.getServletContext()
				.getRequestDispatcher(VUE_CREATE_COMMANDE)
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

		
		/* COMMANDE. ***/
		String paramDateCommande = null;
		String paramMontant = null;
		String paramModePaiement = null;
		String paramStatutPaiement =null;
		String paramModeLivraison = null;
		String paramStatutLivraison = null;
		
		/* dateCommande. */				
		/* Calcul de la date courante si le champ dateCommande 
		 * est désactivé dans le formulaire de saisie. 
		 * Sinon, récupération dela valeur dans le formulaire. */
		if (this.enumContient(parametresTransmis, PARAM_DATE_COMMANDE)) {
			
			final String paramDateCommandeForm 
				= pReq.getParameter(PARAM_DATE_COMMANDE);
			
			if (!StringUtils.isBlank(paramDateCommandeForm)) {
				paramDateCommande = paramDateCommandeForm.trim();
			}
			
		} else {
			paramDateCommande = this.fournirDateCourante();
		}
		/* montant. */	
		final String paramMontantForm 
			= pReq.getParameter(PARAM_MONTANT_COMMANDE);		
		if (!StringUtils.isBlank(paramMontantForm)) {
			paramMontant = paramMontantForm.trim();
		}
		/* modePaiement. */
		final String paramModePaiementForm 
			= pReq.getParameter(PARAM_MODE_PAIMENT_COMMANDE);
		if (!StringUtils.isBlank(paramModePaiementForm)) {
			paramModePaiement = paramModePaiementForm.trim();
		}
		/* statutPaiement. */
		final String paramStatutPaiementForm 
			= pReq.getParameter(PARAM_STATUT_PAIEMENT_COMMANDE);
		if (!StringUtils.isBlank(paramStatutPaiementForm)) {
			paramStatutPaiement = paramStatutPaiementForm.trim();
		}
		/* modeLivraison. */
		final String paramModeLivraisonForm 
			= pReq.getParameter(PARAM_MODE_LIVRAISON_COMMANDE);
		if (!StringUtils.isBlank(paramModeLivraisonForm)) {
			paramModeLivraison = paramModeLivraisonForm.trim();
		}
		/* statutLivraison. */
		final String paramStatutLivraisonForm 
			= pReq.getParameter(PARAM_STATUT_LIVRAISON_COMMMANDE);
		if (!StringUtils.isBlank(paramStatutLivraisonForm)) {
			paramStatutLivraison = paramStatutLivraisonForm.trim();
		}

		
		String messageUtilisateur = null;
		boolean formulaireValide = false;
		
		// ****************************************************************
		// VALIDATION DU FORMULAIRE.
		// ****************************************************************
		
		/* VERIFICATION DU REMPLISSAGE. ********************************/		
		final StringBuilder messageUtilisateurStb = new StringBuilder();
		
		final boolean bonRemplissageClient 
			= this.verifierChampsObligatoiresClient(
				paramNomClient
				, paramAdresseClient
					, paramTelephoneClient
						, messageUtilisateurStb);
				
		final boolean bonRemplissageCommande 
			= this.verifierChampsObligatoirersCommande(
					paramDateCommande
						, paramMontant
							, paramModePaiement
								, paramModeLivraison
									, messageUtilisateurStb);
		
		/* VERIFICATION DU FORMAT DES CHAMPS. *************/
		boolean validationFormatDate = false;
		
		if (!StringUtils.isBlank(paramDateCommande)) {
			
			validationFormatDate 
			= this.validerFormatDate(
					paramDateCommande
						, messageUtilisateurStb);
			
		}

		
		
		final boolean validationFormatMontant 
			= this.validerFormatMontant(
					paramMontant
						, messageUtilisateurStb);

		
		// ****************************************************************
		// CONSTITUTION DU MESSAGE UTILISATEUR.
		// ****************************************************************
		formulaireValide 
			= bonRemplissageClient 
				&& bonRemplissageCommande 
					&& validationFormatDate 
						&& validationFormatMontant;
		
		if (formulaireValide) {
			
			messageUtilisateurStb.append(SAUT_LIGNE_HTML);
			messageUtilisateurStb.append(MESSAGE_CREATION_OK);
			
			messageUtilisateur = messageUtilisateurStb.toString();
		}
		else {
			
			messageUtilisateurStb.append(SAUT_LIGNE_HTML);
			messageUtilisateurStb.append(MESSAGE_CREATION_KO);
			
			messageUtilisateur = messageUtilisateurStb.toString();
		}
		

		// ****************************************************************
		/* CREATION DES BEANS. */
		// ****************************************************************
		
		/* client. */
		final AbstractClient client 
			= new Client(paramNomClient, paramPrenomClient
					, paramAdresseClient, paramTelephoneClient
						, paramEmailClient);
		
		/* commande. */
		final AbstractCommande commande 
			= new Commande(this.fournirJodaDate(paramDateCommande)
					, this.fournirDouble(paramMontant)
						, paramModePaiement
							, paramStatutPaiement
								, paramModeLivraison
									, paramStatutLivraison
										, client);
		

		
		// ************************************************************
		// AJOUT DU BEAN, DU MESSAGE et de l'ERREUR 
		// AUX ATTRIBUTS DE LA REQUETE.
		// ************************************************************
		pReq.setAttribute(ATTR_CLIENT, client);
		pReq.setAttribute(ATTR_COMMANDE, commande);
		pReq.setAttribute(ATTR_MESSAGE, messageUtilisateur);
		pReq.setAttribute(ATTR_ERREUR, formulaireValide);

		
		// ************************************************************
		// AIGUILLAGE VERS LA CIBLE et transfert de la requête/reponse.
		// ************************************************************
		if (formulaireValide) {
			
			/* Chemin de la jsp à atteindre si OK.*/
			/* Aiguillage vers la cible. */
			/* Tranfert de la requête/reponse. */
			this.getServletContext()
				.getRequestDispatcher(VUE_CIBLE_OK)
					.forward(pReq, pResp);
			
			return;
			
		} // Fin de if (formulaireValide).________________________
		
			
		/* Chemin de la jsp à atteindre si KO.*/
		/* Aiguillage vers la cible. */
		/* Tranfert de la requête/reponse. */
		this.getServletContext()
			.getRequestDispatcher(VUE_CIBLE_KO)
				.forward(pReq, pResp);

				
	} // Fin de doGet(...).________________________________________________
	
	
	
	/**
	 * method verifierChampsObligatoiresClient(
	 * String pNom
	 * , String pAdresse
	 * , String pTelephone
	 * , StringBuilder pStb) :<br/>
	 * <ul>
	 * <li>Vérifie que les champs obligatoires (nom, adresse, téléphone) 
	 * pour un client sont bien remplis.</li>
	 * <li>Retourne true si les champs sont bien remplis.</li>
	 * <li>décore le StringBuilder pStb avec des messages utilisateur.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pNom : String : nom du client.<br/>
	 * @param pAdresse : String : adresse de livraison du client.<br/>
	 * @param pTelephone : String : téléphone du client.<br/> 
	 * @param pStb : StringBuilder : 
	 * StringBuilder encapsulant le message utilisateur.<br/>
	 * 
	 * @return : boolean : true si tout est bien rempli.<br/>
	 */
	private boolean verifierChampsObligatoiresClient(
			final String pNom
				, final String pAdresse
					, final String pTelephone
						, final StringBuilder pStb) {
		
		String messageClient = null;

		/* nom. */
		if (StringUtils.isBlank(pNom)) {
			
			final String messageNom 
				= "Le nom n'est pas renseigné (obligatoire).";
			pStb.append(messageNom);
			
		}
		
		/* adresse. */
		if (StringUtils.isBlank(pAdresse)) {
			
			final String messageAdresse 
				= "L'adresse n'est pas renseignée (obligatoire).";
			
			if (StringUtils.isBlank(pNom)) {
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageAdresse);
			} else {
				pStb.append(messageAdresse);
			}
			
		}
		
		/* telephone. */
		if (StringUtils.isBlank(pTelephone)) {
			
			final String messageTelephone 
			= "Le téléphone n'est pas renseigné (obligatoire).";
			
			if (StringUtils.isBlank(pNom) || StringUtils.isBlank(pAdresse)) {
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageTelephone);
			} else {
				pStb.append(messageTelephone);
			}
		}
		
		
		if (StringUtils.isBlank(pNom) 
				|| StringUtils.isBlank(pAdresse) 
					|| StringUtils.isBlank(pTelephone)) {
			
			messageClient = DEBUT_MESSAGE_ERREUR + "le client.";
			
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageClient);
			
			return false;
		}
		
		messageClient = "Client bien renseigné";
		pStb.append(messageClient);
		
		return true;
		
	} // Fin de verifierChampsObligatoiresClient(...)._____________________
	

	
	/**
	 * method verifierChampsObligatoirersCommande(
	 * String pDate
	 * , String pMontant
	 * , String pModePaiement
	 * , String pModeLivraison
	 * , StringBuilder pStb) :<br/>
	 * <ul>
	 * <li>Vérifie que les champs obligatoires 
	 * (dateCommande, montant, modePaiment, modeLivraison) 
	 * pour une commande sont bien remplis.</li>
	 * <li>Retourne true si les champs sont bien remplis.</li>
	 * <li>décore le StringBuilder pStb avec des messages utilisateur.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pDate : String : date de la commande.<br/>
	 * @param pMontant : String : montant de la commande.<br/>
	 * @param pModePaiement : String : mode de paiement.<br/>
	 * @param pModeLivraison : String : mode de livraison.<br/>
	 * @param pStb : StringBuilder : 
	 * StringBuilder encapsulant le message utilisateur.<br/>
	 * 
	 * @return : boolean : true si tout est bien rempli.<br/>
	 */
	private boolean verifierChampsObligatoirersCommande(
			final String pDate
				, final String pMontant
					, final String pModePaiement
						, final String pModeLivraison
							, final StringBuilder pStb) {
		
		String messageCommande = null;
		
		/* date. */
		if (StringUtils.isBlank(pDate)) {
			
			final String messageDate 
			= "La Date n'est pas renseignée (obligatoire).";
			
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageDate);
			
		}
		
		/* montant. */
		if (StringUtils.isBlank(pMontant)) {
			
			final String messageMontant
			= "Le Montant n'est pas renseigné (obligatoire).";
						
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageMontant);
			
		}
		
		/* modePaiement. */
		if (StringUtils.isBlank(pModePaiement)) {
			
			final String messageModePaiement
			= "Le Mode de paiement n'est pas renseigné (obligatoire).";
						
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageModePaiement);
			
		}
		
		/* modeLivraison. */
		if (StringUtils.isBlank(pModeLivraison)) {
			
			final String messageModeLivraison
			= "Le Mode de livraison n'est pas renseigné (obligatoire).";
						
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageModeLivraison);
			
		}
		
		
		if (StringUtils.isBlank(pDate) 
				|| StringUtils.isBlank(pMontant) 
					|| StringUtils.isBlank(pModePaiement) 
						|| StringUtils.isBlank(pModeLivraison)) {
			
			messageCommande = DEBUT_MESSAGE_ERREUR + "la commande.";
			
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageCommande);
			
			return false;
		}
		
		messageCommande = "Commande bien renseignée";
		
		pStb.append(SAUT_LIGNE_HTML);
		pStb.append(messageCommande);
		
		return true;
		
	} // Fin de verifierChampsObligatoirersCommande(...).__________________
	
	

	/**
	 * method validerFormatDate(
	 * String pParamDateCommande
	 * , StringBuilder pStb) :<br/>
	 * <ul>
	 * <li>Vérifie que la date renseignée dans le formulaire 
	 * est homogène à une org.joda.time.DateTime.</li>
	 * <li>Retourne true si le format de la date convient.</li>
	 * <li>décore le StringBuilder pStb avec des messages utilisateur.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pParamDateCommande : String : date dans le formulaire.<br/>
	 * @param pStb : StringBuilder :
	 * StringBuilder encapsulant le message utilisateur.<br/>
	 * 
	 * @return : boolean : true si bon format.<br/>
	 */
	private boolean validerFormatDate(
			final String pParamDateCommande
				, final StringBuilder pStb) {
		
		String messageDate = null;
		boolean dateCorrect = false;
		
		/* date. */
		if (StringUtils.isBlank(pParamDateCommande.trim())) {
			
			messageDate = "Date de la commande non renseignée";
			
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageDate);
			
			dateCorrect = false; 
		}
		else {
			
		    /* Récupération de la Locale courante de la machine. */
	        final Locale localeFr = Locale.getDefault();

	        /* Instanciation d'un DateTimeFormatter. */
	        final DateTimeFormatter dtformatterComplet 
	        	= DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")
	        				.withLocale(localeFr);

			try {
				
				dtformatterComplet.parseDateTime(pParamDateCommande);
				
				messageDate = "Date correctement renseignée (bon format)";
				
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageDate);
								
				dateCorrect = true;
				
			} catch (Exception e) {
				
				messageDate = "Erreur - La date n'est pas au format "
				+ "'dd/MM/yyyy HH:mm:ss' comme dans 25/02/1961 22:34:27";
				
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageDate);
				
				dateCorrect = false;
			}
		}
		
		return dateCorrect;
		
	} // Fin de validerFormatDate(...).____________________________________
	

	
	/**
	 * method validerFormatMontant(
	 * String pParamMontant
	 * , StringBuilder pStb) :<br/>
	 * <ul>
	 * <li>Vérifie que le montant renseigné dans le formulaire 
	 * est homogène à un Double.</li>
	 * <li>Retourne true si le format du montant convient.</li>
	 * <li>décore le StringBuilder pStb avec des messages utilisateur.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pParamMontant : String : montant dans le formulaire.<br/>
	 * @param pStb : StringBuilder : 
	 * StringBuilder encapsulant le message utilisateur.<br/>
	 * 
	 * @return : boolean : true si le montant convient.<br/>
	 */
	private boolean validerFormatMontant(
			final String pParamMontant
				, final StringBuilder pStb) {
		
		String messageMontant = null;
		boolean montantCorrect = false;
		
		/* date. */
		if (StringUtils.isBlank(pParamMontant)) {
			
			messageMontant = "Montant de la commande non renseigné";
			
			pStb.append(SAUT_LIGNE_HTML);
			pStb.append(messageMontant);
			
			montantCorrect = false; 
		}
		else {
			
			try {
				
				Double.parseDouble(pParamMontant);
				
				messageMontant 
					= "Montant correctement renseigné (bon format)";
				
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageMontant);
								
				montantCorrect = true;
				
			} catch (NumberFormatException e) {
				
				messageMontant 
					= "Erreur - Le montant n'est pas homogène "
							+ "à un numérique (Double).";
						
				pStb.append(SAUT_LIGNE_HTML);
				pStb.append(messageMontant);
						
				montantCorrect = false;
				
			}
		}
		
		return montantCorrect;
		
	} // Fin de validerFormatMontant.______________________________________

	
	
	/**
	 * method enumContient(
	 * Enumeration&lt;String&gt; pEnum
	 * , String pString) :<br/>
	 * <ul>
	 * <li>détermine si l'Enumération pEnum contient pString.</li>
	 * <li>retourne true si si l'Enumération pEnum contient pString.</li>
	 * </ul>
	 * retourne false si pEnum == null.<br/>
	 * <br/>
	 *
	 * @param pEnum : Enumeration&lt;String&gt;.<br/>
	 * @param pString : String : chaine à rechercher dans l'enumération.<br/>
	 * 
	 * @return : boolean : true si l'Enumération pEnum contient pString.<br/>
	 */
	private boolean enumContient(
			final Enumeration<String> pEnum
				, final String pString) {
		
		/* retourne false si pEnum == null. */
		if (pEnum == null) {
			return false;
		}
		
		while (pEnum.hasMoreElements()) {
			final String stringLue = pEnum.nextElement();
			if (StringUtils.equalsIgnoreCase(stringLue, pString)) {
				return true;
			}
		}
		
		return false;
		
	} // Fin de enumContient(...)._________________________________________
	

	
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

	
	
	/**
	 * method fournirDateCourante() :<br/>
	 * Fournit la date système formatée 
	 * sous la forme "dd/MM/yyyy HH:mm:ss" comme 25/02/1961 22:34:27.<br/>
	 * <br/>
	 *
	 * @return : String : date système formatée sous la forme 
	 * "dd/MM/yyyy HH:mm:ss" comme 25/02/1961 22:34:27.<br/>
	 */
	private String fournirDateCourante() {
		
		/* Récupération de la date courante */
        final DateTime dtCourante = new DateTime();
        
        /* Récupération de la Locale courante de la machine. */
        final Locale localeFr = Locale.getDefault();
        
        /* Instanciation d'un DateTimeFormatter. */
        final DateTimeFormatter dtformatterComplet 
        	= DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")
        				.withLocale(localeFr);
        
        /* Formatage de la org.joda.time.DateTime. */
		final String dateCouranteFormatee 
			= dtCourante.toString(dtformatterComplet);
		
		return dateCouranteFormatee;
		
	} // Fin de fournirDateCourante()._____________________________________
	

	
	/**
	 * method fournirJodaDate(
	 * String pDateString) :<br/>
	 * <ul>
	 * <li>retourne une org.joda.time.DateTime à partir 
	 * d'une String formatée sous la forme 
	 * "dd/MM/yyyy HH:mm:ss" comme 25/02/1961 22:34:27.</li>
	 * </ul>
	 * retourne null si pDateString est blank.<br/>
	 * retourne null si pDateString n'est pas parsable en DateTime.<br/>
	 * <br/>
	 *
	 * @param pDateString : String : String homogène à une 
	 * date formatée sous la forme "dd/MM/yyyy HH:mm:ss".<br/>
	 * 
	 * @return : org.joda.time.DateTime : 
	 * DateTime correspondant à pDateString.<br/>
	 */
	private DateTime fournirJodaDate(
			final String pDateString) {
		
		/* retourne null si pDateString est blank. */
		if (StringUtils.isBlank(pDateString)) {
			return null;
		}
		
		DateTime date = null;
		
		/* Récupération de la Locale courante de la machine. */
        final Locale localeFr = Locale.getDefault();
        
        /* Instanciation d'un DateTimeFormatter. */
        final DateTimeFormatter dtformatterComplet 
        	= DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")
        				.withLocale(localeFr);
        
		try {
			
			date = dtformatterComplet.parseDateTime(pDateString);
			
		} catch (Exception e) {
			
			/* retourne null si pDateString 
			 * n'est pas parsable en DateTime. */
			date = null;
		}
		
		return date;
		
	} // Fin de fournirJodaDate(...).______________________________________
	
	
	
	/**
	 * method fournirDouble(
	 * String pDouble) :<br/>
	 * <ul>
	 * <li>retourne un Double à partir 
	 * d'une String homogène à un Double.</li>
	 * </ul>
	 * retourne null si pDouble est blank.<br/>
	 * retourne null si pDouble n'est pas parsable en Double.<br/>
	 * <br/>
	 *
	 * @param pDouble
	 * @return :  :  .<br/>
	 */
	private Double fournirDouble(
			final String pDouble) {
		
		/* retourne null si pDouble est blank. */
		if (StringUtils.isBlank(pDouble)) {
			return null;
		}
		
		Double resultat = null;
		
		try {
			
			resultat = Double.parseDouble(pDouble);
			
		} catch (NumberFormatException e) {
			
			/* retourne null si pDouble n'est pas parsable en Double. */
			resultat = null;
		}
		
		return resultat;
		
	} // Fin de fournirDouble(...).________________________________________
	
	
	
} // FIN DE LA CLASSE CreateCommandeController.------------------------------
