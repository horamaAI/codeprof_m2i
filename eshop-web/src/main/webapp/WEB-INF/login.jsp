<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Se connecter</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div>
				<label>Nom d'utilisateur</label>
				<input type="text" name="username" />
			</div>
			
			<div>
				<label>Mot de passe</label>
				<input type="password" name="password" />
			</div>
			
			<div>
				<input type="submit" value="Se connecter" />
			</div>
		</form>
	</jsp:body>
</t:layout>