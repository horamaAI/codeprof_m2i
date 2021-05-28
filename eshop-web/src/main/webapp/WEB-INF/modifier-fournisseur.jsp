<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Modifier le fournisseur</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="container">
			<h1>Modifier le fournisseur</h1>
			
			<form method="POST">
				<div>
					<label>Nom</label>
					<input type="text" name="nom" value="${ fournisseur.nom }" />
				</div>
				
				<div>
					<label>Adresse e-mail</label>
					<input type="email" name="mail" value="${ fournisseur.email }" />
				</div>
				
				<div>
					<label>SIRET</label>
					<input type="text" name="siret" value="${ fournisseur.siret }" />
				</div>
				
				<div>
					<label>Téléphone</label>
					<input type="tel" name="telephone" value="${ fournisseur.telephone }" />
				</div>
				
				<div>
					<input type="submit" class="btn btn-success" value="Modifier" />
				</div>
			</form>
		</div>
	</body>
</html>