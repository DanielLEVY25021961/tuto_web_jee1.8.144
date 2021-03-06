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
    isELIgnored="false" pageEncoding="UTF-8" isErrorPage="false"%>
    
<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_coyote.css" />" />
		<title>createCommande.jsp</title>
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
					<a href="<c:url value="/entree/createCommande" />"><c:out value="${ ariane }" /></a>
				</span>				
			</p>
			<c:set var="ariane" value="créer une commande" scope="session" />
		</div>
		

		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
		<%-- TEST SUR LE VIDE --%>
	    <c:if test="${not empty message }" >
	    	<p class="info">${ message }</p>
	    </c:if>
	
		 <div>

            <form method="get" action="createCommande">
            
            	<%--IMPORT DU FRAGMENT CONCERNANT LE CLIENT. --%>
				<c:import url="/WEB-INF/vues/web/metier/client/formulaires/fragmentCreateClient.jsp"/>
                
                <fieldset>

                    <legend>Informations commande</legend>

                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="${ requestScope.commande.dateCommande }" size="20" maxlength="20" disabled />
                    <br />
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="${ requestScope.commande.montant }" size="20" maxlength="20" />
                    <br />
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="${ requestScope.commande.modePaiement}" size="20" maxlength="20" />
                    <br />
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="${ requestScope.commande.statutPaiement }" size="20" maxlength="20" />
                    <br />
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="${ requestScope.commande.modeLivraison }" size="20" maxlength="20" />
                    <br />
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="${ requestScope.commande.statutLivraison }" size="20" maxlength="20" />
                    <br />

                </fieldset>

                <input type="submit" value="Valider"  />

                <input type="reset" value="Reset" /> <br />

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