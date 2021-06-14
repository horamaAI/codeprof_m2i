<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
		
		<sec:authorize access="hasRole('ADMIN')">
			<a href="produit/ajouter" class="btn btn-success">Ajouter un produit</a>
		</sec:authorize>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prix</th>
					
					<sec:authorize access="hasRole('ADMIN')">
						<th></th>
					</sec:authorize>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="produit" items="${ produits }">
					<tr>
						<td>${ produit.getId() }</td>
						<td>${ produit.libelle }</td>
						<td><c:out value="${ produit.prix }" /></td>
						
						<sec:authorize access="hasRole('ADMIN')">
							<td>
								<a href="produit/modifier?id=${ produit.id }" class="btn btn-warning">Modifier</a>
								<a href="produit/supprimer?id=${ produit.id }" class="btn btn-danger">Supprimer</a>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>