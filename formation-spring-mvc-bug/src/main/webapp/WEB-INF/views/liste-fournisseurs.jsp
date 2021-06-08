<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des fournisseurs</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ fournisseurAjout == true }">
			<div class="alert alert-success" role="alert">
				Le fournisseur a bien été ajouté !
			</div>
		</c:if>
		
		<c:if test="${ param.fournisseurModifie == true }">
			<div class="alert alert-success" role="alert">
				Le fournisseur a bien été modifié !
			</div>
		</c:if>
		
		<c:if test="${ param.fournisseurSupprime == true }">
			<div class="alert alert-success" role="alert">
				Le fournisseur a bien été supprimé !
			</div>
		</c:if>
		
		<a href="fournisseur/ajouter" class="btn btn-success">Ajouter un fournisseur</a>
		
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
							<a href="fournisseur/modifier?id=<c:out value="${ fournisseur.id }" />" class="btn btn-warning">Modifier</a>
							<a href="fournisseur/supprimer?id=${ fournisseur.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>