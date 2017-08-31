<?xml version="1.0" encoding="UTF-8" ?>

<%-- 
DIRECTIVE DE PAGE spécifiant :
- le langage java
- le content type qui stipule que la réponse est du texte HTML encodé en UTF-8
- l'interprétation des Expressions Langage (EL) grâce à isELIgnored="false"
- que la navigateur doit décoder le résultat de la JSP en UTF-8 grâce à pageEncoding="UTF-8"
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="static/css/style_coyote.css" />
		<title>fragmentCreateClient.jsp</title>
	</head>
	
	<body>
		
       <fieldset>

           <legend>Informations client</legend>

           <label for="nomClient">Nom <span class="requis">*</span></label>
           <input type="text" id="nomClient" name="nomClient" value="${ requestScope.client.nom }" placeholder="nom du client" size="40" maxlength="40" />
           <br />
           <label for="prenomClient">Prénom </label>
           <input type="text" id="prenomClient" name="prenomClient" value="${ requestScope.client.prenom }" size="20" maxlength="20" />
           <br />
           <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
           <input type="text" id="adresseClient" name="adresseClient" value="${ requestScope.client.adresseLivraison }" size="20" maxlength="20" />
           <br />
          <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
           <input type="text" id="telephoneClient" name="telephoneClient" value="${ requestScope.client.telephone }" size="20" maxlength="20" />
           <br />
           <label for="emailClient">Adresse email</label>
           <input type="email" id="emailClient" name="emailClient" value="${ requestScope.client.email }" size="20" maxlength="60" />
           <br />

        </fieldset>
                
	</body>
	
</html>