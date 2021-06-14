<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Se connecter</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.erreur == true }">
			<div class="alert alert-danger">
				Nom d'utilisateur ou mot de passe incorrect.
			</div>
		</c:if>
		
		<form method="POST" action="perform_login">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			
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