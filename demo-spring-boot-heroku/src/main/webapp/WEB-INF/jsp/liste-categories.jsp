<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
	
	</head>
	
	<body>
		<ul>
			<c:forEach var="categorie" items="${ categories }">
				<li>${ categorie.libelle }</li>
			</c:forEach>
		</ul>
	</body>
</html>