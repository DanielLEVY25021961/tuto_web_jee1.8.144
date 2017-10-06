<%-- DOCTYPE (DTD pour HTML5) --%>
<!doctype html>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false" %>

<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_coyote.css" />" />
		<title>fragmentAfficherClient.jsp</title>
	</head>
	
	<body>
	             
		<%-- affichage des données enregistrées dans le bean "client" 
		transmis par la servlet --%>
        <h1><span class="souligne">Client</span></h1>
        <%-- Les 5 expressions suivantes accèdent aux propriétés 
        du client dans le scope de la request --%>
        <p>Nom : <c:out value="${ requestScope.client.nom }" default="" escapeXml="true" /></p>
        <p>Prénom : <c:out value="${ requestScope.client.prenom }" default="" escapeXml="true" /></p>
        <p>Adresse : <c:out value="${ requestScope.client.adresseLivraison }" default="" escapeXml="true" /></p>
        <p>Numéro de téléphone : <c:out value="${ requestScope.client.telephone }" default="" escapeXml="true" /></p>
        <p>Email : <c:out value="${ requestScope.client.email }" default="" escapeXml="true" /></p>
        		
	</body>
	
</html>