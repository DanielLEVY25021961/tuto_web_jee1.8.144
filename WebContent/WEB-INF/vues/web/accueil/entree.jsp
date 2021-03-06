<%-- DOCTYPE (DTD pour HTML5) --%>
<!doctype html>


<%-- Import d'un Objet métier.  --%>
<%@page import="levy.daniel.application.model.metier.personne.impl.PersonneGenius"%>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8" isErrorPage="false"%>
	
<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>
	
		<!-- Description du contenu de la page (HTML) et de son encodage. -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<!-- Lien vers les css. -->
		<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_coyote.css" />" />
		
		<!-- Titre s'affichant dans l'onglet. -->
		<title>context/WEB-INF/vues/web/accueil/entree.jsp</title>
	
	</head>
	
	<body>
	
		<%-- FIL D'ARIANE --%>
		<div class="ariane">
			<p>
				<img alt="accueil" src="<c:url value="/static/images/home.png" />" />
				<span class="filariane">
					<a href="<c:url value="/entree" />"><c:out value="${ariane}" /></a>
				</span>
			</p>
			<c:set var="ariane" value="accueil" scope="session" />
		</div>
		
		
		
		<h1>Point d'entrée de l'Application (sous context/WEB-INF/vues/web/accueil/entree.jsp)</h1>
		
		<%--============================= --%>
		<%-- CODE JAVA INSERE DANS LA JSP --%>
		<%--============================= --%>
		
		<%-- Utilisation de l'objet implicite request 
		et récupération de son attribut attrMessageServlet --%>
		<% String messageProvenantServlet = (String) request.getAttribute("attrMessageServlet");
		out.println(messageProvenantServlet); %>
		
		<br/><br/>
		
		<%-- Récupération directe du paramètre auteur dans la requête GET. --%>
		<% String paramAuteur = request.getParameter("auteur"); 
		String affich = "Paramètre 'auteur' récupéré directement dans la requête GET" 
		+ "(http:///localhost:8080/tuto_web_jee1.8.144/entree?auteur= Daniel Lévy) : "; 
		out.println(affich + paramAuteur); %>
		
		<br/><br/>
		
		<div>
			<p><a href="<c:url value="/personne" />">voir une personne</a></p>
			<p><a href="<c:url value="entree/createCommande" />">Créer une Commande</a></p>
			<p><a href="<c:url value="entree/createClient" />">Créer un Client</a></p>
		</div>
		
		
	</body>
	
</html>