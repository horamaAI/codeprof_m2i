<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ produit == null || produit.id == 0 }">Ajouter un produit</c:if>
		<c:if test="${ produit != null && produit.id != 0 }">Modifier le produit</c:if>
	</jsp:attribute>
	
	<jsp:body>
	${ demo } ...
		<form:form method="POST" modelAttribute="produit">
			<%-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" /> --%>
			
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			
			<div>
				<form:errors path="libelle" cssClass="error" />
				<label>Libellé</label>
				<input type="text" name="libelle" value="${ produit.libelle }" />
			</div>
			
			<div>
				<form:errors path="prix" cssClass="error" />
				<label>Prix</label>
				<input type="number" name="prix" value="${ produit.prix }" />
			</div>
			
			<div>
				<form:errors path="prixAchat" cssClass="error" />
				<label>Prix d'achat</label>
				<input type="number" name="prixAchat" value="${ produit.prixAchat }" />
			</div>
			
			<div>
				<label>Fournisseur</label>
				<select name="fournisseur.id">
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
				<select name="categorie.id">
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
				<c:if test="${ produit == null || produit.id == 0 }">
					<input type="submit" class="btn btn-success" value="Ajouter" />
				</c:if>
				
				<c:if test="${ produit != null && produit.id != 0 }">
					<input type="submit" class="btn btn-warning" value="Modifier" />
				</c:if>
			</div>
		</form:form>
	</jsp:body>
</t:layout>