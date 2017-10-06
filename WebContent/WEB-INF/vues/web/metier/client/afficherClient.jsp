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
    isELIgnored="false" pageEncoding="UTF-8" isErrorPage="false" %>
    
<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_coyote.css" />" />
		<title>afficherClient.jsp</title>
	</head>
	
	<body>

		<%-- FIL D'ARIANE --%>
		<div class="ariane">
			<p>
				<img alt="accueil" src="<c:url value="/static/images/home.png" />" />
				<span class="filariane">
					<a href="<c:url value="/entree" />"><c:out value="accueil" /></a>
				</span>
				<span><img src="<c:url value="/static/images/arrow-right.png" />" alt="flèche droite" /></span>
				<span class="filariane">
					<a href="<c:url value="/entree/createClient" />"><c:out value="créer client" /></a>
				</span>	
				<span><img src="<c:url value="/static/images/arrow-right.png" />" alt="flèche droite" /></span>
				<span class="filariane">
					<a href="<c:url value="/entree/afficherClient" />"><c:out value="client" /></a>
				</span>				
			</p>
			<c:set var="ariane" value="créer un client" scope="session" />
		</div>
		
		<div>
            
            <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        	<p class="info">${ message }</p>
            
            <%-- INCLUSION DU FRAGMENT --%> 
            <%--INCLUSION DE /WEB-INF/vues/web/metier/client/fragmentAfficherClient.jsp --%>        
            <c:import url="/WEB-INF/vues/web/metier/client/fragmentAfficherClient.jsp" />

        </div>
 
         <!-- LIENS -->
        <div>
			<p>
				<a href="<c:url value="/entree" />">Retour à l'accueil</a>
			</p>
		</div>
        
	</body>
	
</html>