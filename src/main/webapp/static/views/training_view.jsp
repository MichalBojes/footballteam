<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file = "header.jsp" %>
<head>
<title>Pedał tytuł dodał ale prawdziwy gej go usunie</title>
</head>
<body>
Dane Treningu :<br>
${training.stadium.name}
${training.data}
${training.type}

<c:if test="${fn:length(selectedPlayers) > 0}">
<br>
Wybrani zawodnicy: 
<br>
	<c:forEach items="${selectedPlayers}" var = "player">
	${player.player.username.name} ${player.player.username.surname}<br>
	</c:forEach>
</c:if>
<c:if test="${fn:length(avaliablePlayers) > 0}">
<br>
Dostepni zawodnicy: 
<br>
	<c:forEach items="${avaliablePlayers}" var = "player">
	${player.username.name} ${player.username.surname}
	<form:form id="add-player-to-training-hidden-form" action="addPlayerToTraining" modelAttribute="trainingDTO" method="post">
		<form:input type="hidden" path="trainingid" value="${training.trainingid}" id="trainingid"></form:input>
		<form:input type="hidden" path="playerid" value="${player.playerid}" id="playerid"></form:input>
		<input type="submit" class="submit-button" value="Wybierz" />
	</form:form>
	</c:forEach>
</c:if>
</body>