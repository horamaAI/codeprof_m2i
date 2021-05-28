<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Ajouter un nouveau fournisseur</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div>
				<label>Nom</label>
				<input type="text" name="nom" />
			</div>
			
			<div>
				<label>Adresse e-mail</label>
				<input type="email" name="mail" />
			</div>
			
			<div>
				<label>SIRET</label>
				<input type="text" name="siret" />
			</div>
			
			<div>
				<label>Téléphone</label>
				<input type="tel" name="telephone" />
			</div>
			
			<div>
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</div>
		</form>
	</jsp:body>
</t:layout>