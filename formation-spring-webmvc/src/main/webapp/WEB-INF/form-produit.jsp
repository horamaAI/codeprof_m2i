<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Ajouter un produit</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div>
				<label>Libellé</label>
				<input type="text" name="libelle" />
			</div>
			
			<div>
				<label>Prix</label>
				<input type="text" name="prix" />
			</div>
			
			<div>
				<label>Fournisseur ID</label>
				<input type="text" name="fournisseur.id" />
			</div>
			
			<div>
				<label>Fournisseur Nom</label>
				<input type="text" name="fournisseur.nom" />
			</div>
			
			<div>
				<label>Autre param</label>
				<input type="text" name="autre" />
			</div>
			
			<div>
				<input type="submit" value="Ajouter" />
			</div>
		</form>
	</jsp:body>
</t:layout>