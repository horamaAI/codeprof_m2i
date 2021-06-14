<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ attribute name="title" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<title><jsp:invoke fragment="title" /></title>
		
		<meta charset="UTF-8" />
		<base href="/" />
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/css/style.css" />
	</head>
	
	<body>
		<sec:authorize access="isAuthenticated()">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
	 			<a class="navbar-brand" href="home">eshop</a>
	
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="home">Accueil</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="liste-produit">Liste des produits</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="liste-fournisseur">Liste des fournisseurs</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="liste-categorie">Liste des catégories</a>
						</li>
						
						<li class="nav-item">
							<form method="POST" action="perform_logout">
								<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
								<input type="submit" value="Déconnexion" class="btn btn-danger" />
							</form>
						</li>
					</ul>
				</div>
			</nav>
		</sec:authorize>
		
		<div class="container">
			<h1>
				<jsp:invoke fragment="title" />
			</h1>
			
			LE CONTENU ICI :
			<jsp:doBody />
		</div>
	</body>
</html>