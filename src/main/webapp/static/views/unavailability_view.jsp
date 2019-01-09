<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>Kontrakt</title>
</head>
<body>
<table>
		<tr>
			<th>Pimie</th>
			<th>Rnazw</th>
			<th>Zdata wydartz</th>
			<th>dlugosc</th>
			<th>powod</th>
			<th>mecz</th>
		</tr>
		<c:forEach items="${unavailabiltiesDTO}" var = "unavailabilty">
		<tr>
			<td>${unavailabilty.player.username.name}</td>
			<td>${unavailabilty.player.username.surname}</td>
			<td>${unavailabilty.occurreDate}</td>
			<td>${unavailabilty.durationInDays}</td>
			<td>${unavailabilty.reason}</td>
			<td><a href ="<c:url value ='fixture?id=${unavailabilty.fixture.fixtureid}'/>">${unavailabilty.fixture.fixtureid}</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
</body>
</html>