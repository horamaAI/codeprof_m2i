<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des catégories</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.categorieAjout == true }">
			<div class="alert alert-success" role="alert">
				La catégorie a bien été ajoutée !
			</div>
		</c:if>
		
		<c:if test="${ param.categorieModifie == true }">
			<div class="alert alert-success" role="alert">
				La catégorie a bien été modifiée !
			</div>
		</c:if>
		
		<c:if test="${ param.categorieSupprime== true }">
			<div class="alert alert-success" role="alert">
				La catégorie a bien été supprimée !
			</div>
		</c:if>
		
		<a href="categorie/ajouter" class="btn btn-success">Ajouter une catégorie</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Description</th>
					<th>Parent</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="categorie" items="${ categories }">
					<tr>
						<td>${ categorie.id }</td>
						<td>${ categorie.libelle }</td>
						<td>${ categorie.description }</td>
						<td>${ categorie.parent.libelle }</td>
						<td>
							<a href="categorie/modifier?id=${ categorie.id }" class="btn btn-warning">Modifier</a>
							<a href="categorie/supprimer?id=${ categorie.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>