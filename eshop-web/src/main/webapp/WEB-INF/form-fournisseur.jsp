<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ fournisseur == null }">Ajouter un fournisseur</c:if>
		<c:if test="${ fournisseur != null }">Modifier le fournisseur</c:if>
	</jsp:attribute>
	
	<jsp:body>
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
				<c:if test="${ fournisseur == null }">
					<input type="submit" class="btn btn-success" value="Ajouter" />
				</c:if>
				
				<c:if test="${ fournisseur != null }">
					<input type="submit" class="btn btn-warning" value="Modifier" />
				</c:if>
			</div>
		</form>
	</jsp:body>
</t:layout>