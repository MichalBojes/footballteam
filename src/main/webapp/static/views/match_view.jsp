<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file = "header.jsp" %>
<head>
<title>Pedał tytuł dodał ale prawdziwy gej go usunie</title>
</head>
<body>
Dane Meczu :<br>
${fixture.dataFormated}
${fixture.season}
${fixture.round}
${fixture.stadium.name}
${fixture.opponent}
${fixture.league}
${fixture.referee}

<c:if test="${fn:length(selectedPlayers) > 0}">
<br>
Wybrani zawodnicy: 
<br>
	<c:forEach items="${selectedPlayers}" var = "player">
	${player.username.name} ${player.username.surname} na pozycji ${player.position} <br>
	</c:forEach>
</c:if>
<c:if test="${fn:length(avaliablePlayers) > 0}">
<br>
Dostepni zawodnicy: 
<br>
	<c:forEach items="${avaliablePlayers}" var = "player">
	${player.username.name} ${player.username.surname} na pozycji 
	<form:form id="add-unavailability-form" action="addPlayerToMatch" modelAttribute="match" method="post">
		<form:input type="hidden" path="fixtureid" value="${fixture.fixtureid}" id="fixtureid"></form:input>
		<form:input type="hidden" path="username" value="${player.username.username}" id="username"></form:input>
		<form:input class="input-class" path="position" value="${player.position}" id="position"></form:input>
		<input type="submit" class="submit-button" value="Wybierz" />
	</form:form>
	</c:forEach>
</c:if>
</body>