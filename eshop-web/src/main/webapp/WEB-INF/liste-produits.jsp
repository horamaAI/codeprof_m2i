<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des produits</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="container">
			<h1>Liste des produits</h1>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prix</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="produit" items="${ produits }">
						<tr>
							<td>${ produit.getId() }</td>
							<td>${ produit.libelle }</td>
							<td><c:out value="${ produit.prix }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>