<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>dupa</title>
</head>
<body>
<c:forEach items="${fixturesList}" var="fixture" >
	<div class="fixtures-tables" style="width:99px; font-size:1px;">${fixture.fixtureid}</div>
    <div class="fixtures-tables" style="width:99px; font-size:1px;">${fixture.dataFormated}</div>
	<div class="fixtures-tables" style="width:59px; font-size:15px;">${fixture.season}</div>
	<div class="fixtures-tables" style="width:59px;">${fixture.round}</div>
	<div class="fixtures-tables" style="width:109px;">${fixture.stadium.name}</div>
	<div class="fixtures-tables" style="width:109px;">${fixture.opponent}</div>
	<div class="fixtures-tables" style="width:109px;">${fixture.league}</div>
    <div class="fixtures-tables" style="width:109px;">${fixture.referee}</div>
    <div style="clear:both"></div>
</c:forEach>
<form:form id="add-unavailability-form" action="confirmUnavailability" modelAttribute="unavailabilityDTO" method="post">

		<form:input type="hidden" path="player.playerid" id="player.playerid"></form:input>
		<div class="part">
			<form:input class="input-class" path="fixture.fixtureid" id="fixture.fixtureid"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="occurreDate" id="occurreDate"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="durationInDays" id="durationInDays"></form:input>
		</div>
		<div class="part">
			<form:input class="input-class" path="reason" id="reason"></form:input>
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