<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des fournisseurs</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="container">
			<h1>Liste des fournisseurs</h1>
			
			<a href="ajouter-fournisseur" class="btn btn-success">Ajouter un fournisseur</a>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>SIRET</th>
						<th>Téléphone</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="fournisseur" items="${ fournisseurs }">
						<tr>
							<td>${ fournisseur.id }</td>
							<td>${ fournisseur.nom }</td>
							<td>${ fournisseur.siret }</td>
							<td>${ fournisseur.telephone }</td>
							<td>
								<a href="modifier-fournisseur?id=<c:out value="${ fournisseur.id }" />" class="btn btn-warning">Modifier</a>
								<a href="supprimer-fournisseur?id=${ fournisseur.id }" class="btn btn-danger">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>