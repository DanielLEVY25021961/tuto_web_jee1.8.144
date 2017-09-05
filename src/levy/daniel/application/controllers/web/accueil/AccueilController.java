package levy.daniel.application.controllers.web.accueil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AccueilController :<br/>
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
 * @since 18 août 2017
 *
 */
public class AccueilController extends HttpServlet {

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
	private static final Log LOG 
		= LogFactory.getLog(AccueilController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AccueilController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AccueilController() {
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
		
		final StringBuilder stb = new StringBuilder();
				
		final String message1 = "Message créé dans le doGet(...) "
				+ "de la Servlet AccueilController "
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
						+ "entree?auteur=Daniel Lévy) est :  " 
						+ paramAuteur;
			
			/* Saut de ligne HTML. */
			stb.append("<br/>");
			
			stb.append(message2);
		}
		
		final String ariane = "accueil";
		final String message = stb.toString();
		
		/* Passe message à l'attribut attrMessageServlet de la requête. */
		pReq.setAttribute("attrMessageServlet", message);
		pReq.setAttribute("ariane", ariane);
		
		/* URL : context/entree */
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/vues/web/accueil/entree.jsp")
			.forward(pReq, pResp);
		
	} // Fin de doGet(...).________________________________________________
	
	
	
} // FIN DE LA CLASSE AccueilController.-------------------------------------
