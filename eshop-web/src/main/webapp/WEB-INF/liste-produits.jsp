<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des produits</jsp:attribute>
	
	<jsp:body>
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