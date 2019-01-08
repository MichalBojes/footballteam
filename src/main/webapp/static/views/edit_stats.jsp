<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>dupa</title>
</head>
<body>
${playerDTO.username.name}
${playerDTO.username.surname}
<form:form id="edit-stats-form" action="confirmEditStats" modelAttribute="playerDTO" method="post">
		<form:input type="hidden" path="playerid" id="playerid"></form:input>
		<div class="part">
			<form:input class="input-class" path="position" id="position"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="matchesPlayed" id="matchesPlayed"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="goalScored" id="goalScored"></form:input>
		</div>
		<div class="part">
			<form:checkbox class="checkbox-class" path="preferedFootRight" id="preferedFootRight"></form:checkbox>
		</div>
		<div class="part">
			<form:input class="input-class" path="shirtNumber" id="shirtNumber"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="cardsReceived" id="cardsReceived"></form:input>
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