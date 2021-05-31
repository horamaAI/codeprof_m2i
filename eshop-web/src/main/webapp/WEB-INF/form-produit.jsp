<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ produit == null }">Ajouter un produit</c:if>
		<c:if test="${ produit != null }">Modifier le produit</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div>
				<label>Libellé</label>
				<input type="text" name="libelle" value="${ produit.libelle }" />
			</div>
			
			<div>
				<label>Prix</label>
				<input type="number" name="prix" value="${ produit.prix }" />
			</div>
			
			<div>
				<label>Prix d'achat</label>
				<input type="number" name="prixAchat" value="${ produit.prixAchat }" />
			</div>
			
			<div>
				<label>Fournisseur</label>
				<select name="fournisseurId">
					<c:forEach var="fournisseur" items="${ fournisseurs }">
						<c:if test="${ produit.fournisseur.id == fournisseur.id }">
							<option selected value="${ fournisseur.id }">${ fournisseur.nom }</option>
						</c:if>
						
						<c:if test="${ produit.fournisseur.id != fournisseur.id }">
							<option value="${ fournisseur.id }">${ fournisseur.nom }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<div>
				<label>Catégorie</label>
				<select name="categorieId">
					<c:forEach var="categorie" items="${ categories }">
						<option
								<c:if test="${ produit.categorie.id == categorie.id }">
									selected
								</c:if>
								value="${ categorie.id }"
							>
								${ categorie.libelle }
						</option>
					</c:forEach>
				</select>
			</div>
			
			<div>
				<c:if test="${ produit == null }">
					<input type="submit" class="btn btn-success" value="Ajouter" />
				</c:if>
				
				<c:if test="${ produit != null }">
					<input type="submit" class="btn btn-warning" value="Modifier" />
				</c:if>
			</div>
		</form>
	</jsp:body>
</t:layout>