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
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="static/css/style_coyote.css" />
		<title>afficherClient.jsp</title>
	</head>
	
	<body>
		
		<div>
            
            <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        	<p class="info">${ message }</p>
             
            <%--INCLUSION DE /WEB-INF/vues/web/metier/client/fragmentAfficherClient.jsp --%>        
            <c:import url="/WEB-INF/vues/web/metier/client/fragmentAfficherClient.jsp" />

        </div>
        
	</body>
	
</html>