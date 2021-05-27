<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Accueil</title>
	</head>
	
	<body>
		<h1>Hello</h1>
		
		<c:if test="${ sessionUser == null }">
			<p>Vous n'êtes pas connecté</p>
		</c:if>
		
		<c:if test="${ sessionUser != null }">
			<p>Bonjour à ${ sessionUser } (<c:out value="${ utilisateur }" />) !!!</p>
		</c:if>
		
		<c:choose>
			<c:when test="${ sessionUser != null }">
				<p>Bonjour à ${ sessionUser } (<c:out value="${ utilisateur }" />) !!!</p>
			</c:when>
			
			<c:otherwise>
				<p>Vous n'êtes pas connecté</p>
			</c:otherwise>
		</c:choose>
		
		<h2>Liste des prénoms</h2>
		<ul>
			<c:forEach var="prenom" items="${ prenoms }">
				<li>${ prenom }</li>
			</c:forEach>
			
			<!-- <li>${ prenoms[0] }</li>
			<li>${ prenoms[1] }</li>
			<li>...</li> -->
		</ul>
		
		<%-- <img src="assets/img/${ utilisateur.id }.png" /> --%>
	</body>
</html>