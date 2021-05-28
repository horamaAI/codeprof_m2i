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
		
		<h2>Démo VUEJS</h2>
		<div id="vue">
			<form>
				<input v-model="produit.libelle" />
			</form>
			
			<button @click="demo">TEST</button>
			
			<p>Produit 2 = {{ produit.libelle }}</p>
		</div>
		
		
		<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
		
		<script>
			new Vue({
			 	data: {
			 		produit: { libelle: "test" }
			 	},
			 	
			 	methods: {
			 		demo() {
			 			this.produit.libelle = "DEMO";
			 		}
			 	}
			}).$mount("#vue");
		</script>
		
		
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