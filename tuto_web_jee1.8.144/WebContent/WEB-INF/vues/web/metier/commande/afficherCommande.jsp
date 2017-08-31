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
		<title>afficherCommande.jsp</title>
	</head>
	
	<body>
	
		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
		<%-- TEST SUR LE VIDE --%>
	    <c:if test="${not empty message }" >
	    	<p class="info">${ message }</p>
	    </c:if>

		<div class="client">
	        <%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
	        <h1><u>Client</u></h1>
	        <%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande --%>
	        <p>Nom : <c:out value="${ requestScope.commande.client.nom }" default="" escapeXml="true" /></p>
	        <p>Prénom : <c:out value="${ requestScope.commande.client.prenom }" default="" escapeXml="true" /></p>
	        <p>Adresse : <c:out value="${ requestScope.commande.client.adresseLivraison }" default="" escapeXml="true" /></p>
	        <p>Numéro de téléphone : <c:out value="${ requestScope.commande.client.telephone }" default="" escapeXml="true" /></p>
	        <p>Email : <c:out value="${ requestScope.commande.client.email }" default="" escapeXml="true" /></p>
		</div>
		
		<div class="commande">
	        <h1><u>Commande</u></h1>
	        <p>Date  : <c:out value="${ requestScope.commande.dateCommande }" default="" escapeXml="true" /></p> 
	        <p>Montant  : <c:out value="${ requestScope.commande.montant }" default="" escapeXml="true" /> euros</p> 
	        <p>Mode de paiement  : <c:out value="${ requestScope.commande.modePaiement }" default="" escapeXml="true" /></p> 
	        <p>Statut du paiement  : <c:out value="${ requestScope.commande.statutPaiement }" default="" escapeXml="true" /></p> 
	        <p>Mode de livraison  : <c:out value="${ requestScope.commande.modeLivraison }" default="" escapeXml="true" /></p> 
	        <p>Statut de la livraison  : <c:out value="${ requestScope.commande.statutLivraison }" default="" escapeXml="true" /></p>
        </div> 
		
	</body>
	
</html>