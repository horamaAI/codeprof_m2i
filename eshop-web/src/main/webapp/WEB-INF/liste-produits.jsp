<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des produits</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.produitAjout == true }">
			<div class="alert alert-success" role="alert">
				Le produit a bien �t� ajout� !
			</div>
		</c:if>
		
		<a href="ajouter-produit" class="btn btn-success">Ajouter un produit</a>
		
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
	</jsp:body>
</t:layout>