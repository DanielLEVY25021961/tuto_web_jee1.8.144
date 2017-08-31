<?xml version="1.0" encoding="UTF-8" ?>

<%-- Import d'un Objet métier.  --%>
<%@page import="levy.daniel.application.model.metier.personne.impl.PersonneGenius"%>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
 	isELIgnored="false" pageEncoding="UTF-8" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>personne.jsp</title>
	
	</head>
	
	<body>
	
		<h1>Personne.jsp (sous WEB-INF/vues/metier/personne/)</h1>


		<%--============================= --%>
		<%-- CODE JAVA INSERE DANS LA JSP --%>
		<%--============================= --%>
				
		<h2><u>CODE JAVA DANS LA JSP</u></h2>
		
		<%-- Utilisation de l'objet implicite request 
		et récupération de son attribut attrMessageServlet --%>
		<h3>Message récupéré en Java dans la JSP</h3>
		<p><% String messageProvenantServlet = (String) request.getAttribute("attrMessageServlet");
		out.println(messageProvenantServlet); %></p>
		
		<%-- Récupération directe du paramètre auteur dans la requête GET. --%>
		<h3>Paramètre 'auteur' récupéré en Java dans la JSP directement dans la requête GET</h3>
		<% String paramAuteur = request.getParameter("auteur"); 
		String affich = "Paramètre 'auteur' récupéré directement dans la requête GET" 
		+ "(http:///localhost:8080/tuto_web_jee1.8.144/personne?auteur= Daniel Lévy) : "; %>
		<p><% out.println(affich + paramAuteur); %></p>
		
		<%-- Récupération du bean inséré dans un attribut de la requête GET. --%>
		<h3>Bean récupéré en Java dans la JSP</h3>
		<p>
		<% PersonneGenius papy = (PersonneGenius) request.getAttribute("attrPremierBeanPapy"); 
		out.println("prénom : " + papy.getPrenom());
		out.println("<br/>");
		out.println("nom : " + papy.getNom());
		out.println("<br/>");
		out.println("génial ? : " + papy.getGenius());%>
		</p>
		
		<br/><br/>

		<%--============================= --%>
		<%-- UTILISATION DE TAGLIB JSTL   --%>
		<%--============================= --%>

		<h2><u>TAGLIBS JSTL DANS LA JSP</u></h2>
		
		<%-- Utilisation de l'objet implicite request 
		et récupération de son attribut attrMessageServlet --%>		
		<h3>Message récupéré par la taglib jstl c:out et les Expression Langage (EL) dans la JSP</h3>
		<p>Message provenant de la Servlet : <c:out value="${requestScope.attrMessageServlet}" default="Daniel Lévy" escapeXml="true" /> </p>
		
		<%-- Récupération directe du paramètre auteur dans la requête GET. --%>
		<h3>Paramètre 'auteur' récupéré par la taglib jstl c:out et les Expression Langage (EL) directement dans la requête GET</h3>		
		<p>Paramètre 'auteur' récupéré directement dans la requête GET 
		(http:///localhost:8080/tuto_web_jee1.8.144/personne?auteur= Daniel Lévy) : 
		<c:out value="${requestScope.param.auteur}" default="Daniel Lévy" escapeXml="true" /></p>
		
		<%-- Récupération du bean inséré dans un attribut de la requête GET. --%>
		<h3>Bean récupéré par la taglib jstl c:out et les Expression Langage (EL) dans la JSP</h3>
		<p>
			prénom : <c:out value="${requestScope.attrPremierBeanPapy.prenom}" default="zorro" escapeXml="true"/><br/>
			nom : <c:out value="${requestScope.attrPremierBeanPapy.nom}" default="Gonzalez" escapeXml="true"/><br/>
			génial ? : <c:out value="${requestScope.attrPremierBeanPapy.genius}" default="false" escapeXml="true"/><br/>
		</p>
		
	</body>
	
</html>