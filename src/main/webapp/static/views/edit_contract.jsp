<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>dupa</title>
</head>
<body>
<form:form id="edit-contract-form" action="confirmEditContract" modelAttribute="contractDTO" method="post">
		<form:input type="hidden" path="playerid" id="playerid"></form:input>
		<div class="part">
			<form:input class="input-class" path="value" id="value"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="startDate" id="startDate"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="durationInMonths" id="durationInMonths"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="salary" id="salary"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="extras" id="extras"></form:input>
		</div>
		
		<div id="cancel">

			<a href="squad"><input type="button" class="submit-button"
				value="Anuluj"></a>
		</div>
		<div id="register">
			<input type="submit" class="submit-button" value="Zapisz zmiany" />
		</div>
		<div style="clear: both;"></div>
	</form:form>
</body>
</html>