<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>dupa</title>
</head>
<body>
ostatnio aktualizowany: ${newsDTO.data}
	<form:form id="edit-news-form" action="confirmEditNews" modelAttribute="newsDTO" method="post">
		<form:input type="hidden" path="newsid" id="newsid"></form:input>
		<form:input type="hidden" path="data" id="data"></form:input>
		<div class="part">
			<form:input class="input-class" path="value" id="value"></form:input>
		</div>
		
		<div id="cancel">

		<a href="home"><input type="button" class="submit-button" value="Anuluj"></a>
		</div>
		<div id="register">
			<input type="submit" class="submit-button" value="Zapisz zmiany" />
		</div>
		<div style="clear: both;"></div>
	</form:form>
</body>
</html>