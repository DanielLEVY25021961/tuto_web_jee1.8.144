package levy.daniel.application.controllers.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class ServletJ2eeAccueil :<br/>
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
public class ServletJ2eeAccueil extends HttpServlet {

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
	private static final Log LOG = LogFactory.getLog(ServletJ2eeAccueil.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ServletJ2eeAccueil() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ServletJ2eeAccueil() {
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
				
		pResp.setContentType("text/html");
		pResp.setCharacterEncoding("UTF-8");
		final PrintWriter out = pResp.getWriter();
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"utf-8\" />");
	    out.println("<title>Accueil.Servlet</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>Ceci est une page générée dans la réponse "
	    		+ "de doGet(...) d'une servlet.</p>");
	    out.println("</body>");
	    out.println("</html>");
		
	} // Fin de doGet(...).________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doHead(
			final HttpServletRequest pArg0
				, final HttpServletResponse pArg1) 
						throws ServletException, IOException {

		super.doHead(pArg0, pArg1);
		
	} // Fin de doHead(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(
			final HttpServletRequest pReq
				, final HttpServletResponse pResp) 
						throws ServletException, IOException {
		
		super.doPost(pReq, pResp);
		
	} // Fin de doPost(...)._______________________________________________
	
	
	
	
} // FIN DE LA CLASSE ServletJ2eeAccueil.------------------------------------
