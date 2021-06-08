<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Hello</jsp:attribute>
	
	<jsp:body>
		Bonjour ${ username } !
	</jsp:body>
</t:layout>