<%-- Liste des attributs --%>
<%@ attribute name="label" %>
<%@ attribute name="name" %>
<%@ attribute name="value" %>

<!-- Composant HTML "input" -->
<div>
	<label>${ label }</label>
	<input type="text" name="${ name }" value="${ value }" />
</div>