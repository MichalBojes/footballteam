<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>Statystyki</title>
</head>
<body>
	${player.username.name} ${player.username.surname}
	<table>
		<tr>
			<th>Pozycja</th>
			<th>Rozegrane mecze</th>
			<th>Zdobyte bramki</th>
			<th>Preferowana noga</th>
			<th>Numer Koszulki</th>
			<th>Otrzymane Kartki</th>
		</tr>
		<tr>
			<td>${player.position}</td>
			<td>${player.matchesPlayed}</td>
			<td>${player.goalScored}</td>
			<td><c:if test = "${player.preferedFootRight == true}"> Prawa </c:if>
			<c:if test = "${player.preferedFootRight == false}"> Lewa </c:if>
			</td>
			<td>${player.shirtNumber}</td>
			<td>${player.cardsReceived}</td>
		</tr>
	</table>
	<a href = "<c:url value = 'editStats?id=${player.playerid}'/>">Edytuj Statystyki</a>
	<a href = "<c:url value = 'unavailability/${player.username.username}'/>">Zgłoś niedostępność</a> 
</body>