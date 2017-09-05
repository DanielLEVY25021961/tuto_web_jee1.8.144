package levy.daniel.application.controllers.web.metier.personne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.impl.PersonneGenius;

/**
 * class PersonneController :<br/>
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
public class PersonneController extends HttpServlet {
	
	// ************************ATTRIBUTS************************************/

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
	private static final Log LOG = LogFactory.getLog(PersonneController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR PersonneController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneController() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(
			final HttpServletRequest pReq
				, final HttpServletResponse pResp) 
							throws ServletException, IOException {
		
		// MESSAGE.
		final StringBuilder stb = new StringBuilder();
		
		final String message1 = "Message créé dans le doGet(...) "
				+ "de la Servlet PersonneController "
				+ "et passé dans l'attribut attrMessageServlet "
				+ "de l'objet request pReq";
		
		stb.append(message1);
		
		/* Récupération de la valeur associée au paramètre auteur 
		 * dans la requête GET.*/
		final String paramAuteur = pReq.getParameter("auteur");
		
		if (!StringUtils.isBlank(paramAuteur)) {
			
			final String message2 
				= "L'auteur précisé en paramètre de la requête GET "
						+ "(http://localhost:8080/tuto_web_jee1.8.144/"
						+ "personne?auteur=Daniel Lévy) est :  " 
						+ paramAuteur;
			
			/* Saut de ligne HTML. */
			stb.append("<br/>");
			
			stb.append(message2);
		}
				
		final String message = stb.toString();
		
//		final String arianeEntree = (String) pReq.getAttribute("ariane");
//		System.out.println("arianeEntree : " + arianeEntree);
		final String ariane = "personne";
		
		/* Passe message à l'attribut attrMessageServlet de la requête. */
		pReq.setAttribute("attrMessageServlet", message);
		pReq.setAttribute("ariane", ariane);
		
		// BEAN.
		final PersonneGenius premierBeanPapy 
			= new PersonneGenius("Papy", "Gonzales", true);
		pReq.setAttribute("attrPremierBeanPapy", premierBeanPapy);
		
		/* URL : context/personne */
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/vues/web/metier/personne/personne.jsp")
			.forward(pReq, pResp);
		
	} // Fin de doGet(...).________________________________________________
	
	
	
	
} // FIN DE LA CLASSE PersonneController.------------------------------------
