<?xml version="1.0" encoding="UTF-8" ?>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
    
<!-- DTD pour  XHTML 1.0 Transitional -->    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->

<!-- DTD pour HTML 5 -->
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="static/css/style_coyote.css" />
		<title>createClient.jsp</title>
	</head>
	
	<body>

		<%-- FIL D'ARIANE --%>
		<div class="ariane">
			<p>
				<img alt="accueil" src="static/images/home.png" />
				<span class="filariane">
					<a href="<c:url value="/entree" />"><c:out value="accueil" /></a>
				</span>
				<span><img src="static/images/arrow-right.png" alt="flèche droite" /></span>
				<span class="filariane">
					<a href="<c:url value="/createClient" />"><c:out value="${ ariane }" /></a>
				</span>				
			</p>
			<c:set var="ariane" value="créer un client" scope="session" />
		</div>
	
		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
		<%-- TEST SUR LE VIDE --%>
	    <c:if test="${not empty message }" >
	    	<p class="info">${ message }</p>
	    </c:if>
        		
		 <div>

            <form method="get" action="createClient">

                <c:import url="/WEB-INF/vues/web/metier/client/formulaires/fragmentCreateClient.jsp"/>

                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />

            </form>

        </div>
        
        <!-- LIENS -->
        <div>
			<p>
				<a href="<c:url value="/entree" />">Retour à l'accueil</a>
			</p>
		</div>
        
	</body>
	
</html>