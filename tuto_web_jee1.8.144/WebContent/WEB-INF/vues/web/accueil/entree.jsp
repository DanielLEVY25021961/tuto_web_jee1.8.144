<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="levy.daniel.application.model.metier.personne.impl.PersonneGenius"%>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>entrée.jsp</title>
	
	</head>
	
	<body>
		<h1>Point d'entrée de l'Application (sous WEB-INF)</h1>
		
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
		
	</body>
	
</html>