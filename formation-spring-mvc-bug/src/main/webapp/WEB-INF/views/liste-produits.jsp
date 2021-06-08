<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des produits</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.produitAjout == true }">
			<div class="alert alert-success" role="alert">
				Le produit a bien été ajouté !
			</div>
		</c:if>
		
		<c:if test="${ param.produitModifie == true }">
			<div class="alert alert-success" role="alert">
				Le produit a bien été modifié !
			</div>
		</c:if>
		
		<a href="produit/ajouter" class="btn btn-success">Ajouter un produit</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prix</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="produit" items="${ produits }">
					<tr>
						<td>${ produit.getId() }</td>
						<td>${ produit.libelle }</td>
						<td><c:out value="${ produit.prix }" /></td>
						<td>
							<a href="produit/modifier?id=${ produit.id }" class="btn btn-warning">Modifier</a>
							<a href="produit/supprimer/${ produit.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>