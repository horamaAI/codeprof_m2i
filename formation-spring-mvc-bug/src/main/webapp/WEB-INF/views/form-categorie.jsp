<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ categorie == null }">Ajouter une categorie</c:if>
		<c:if test="${ categorie != null }">Modifier la categorie</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div>
				<label>Libellé</label>
				<input type="text" name="libelle" value="${ categorie.libelle }" />
			</div>
			
			<div>
				<label>Description</label>
				<textarea name="description">${ categorie.description }</textarea>
			</div>
			
			<div>
				<label>Catégorie parent</label>
				<select name="parent.id">
					<option value="0">- Pas de catégorie parent -</option>
					
					<c:forEach var="categorieParent" items="${ categories }">
						<c:if test="${ categorie.id != categorieParent.id }">
							<c:if test="${ categorie.parent.id == categorieParent.id }">
								<option selected value="${ categorieParent.id }">${ categorieParent.libelle }</option>
							</c:if>
							
							<c:if test="${ categorie.parent.id != categorieParent.id }">
								<option value="${ categorieParent.id }">${ categorieParent.libelle }</option>
							</c:if>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<div>
				<c:if test="${ categorie == null }">
					<input type="submit" class="btn btn-success" value="Ajouter" />
				</c:if>
				
				<c:if test="${ categorie != null }">
					<input type="submit" class="btn btn-warning" value="Modifier" />
				</c:if>
			</div>
		</form>
	</jsp:body>
</t:layout>