<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "header.jsp" %>

<head>
<meta charset="UTF-8">
<title>Kontrakt</title>
</head>
<body>
<table>
		<tr>
			<th>P</th>
			<th>R</th>
			<th>Z</th>
			<th>P</th>
			<th>N</th>
		</tr>
		<tr>
			<td>${contract.value}</td>
			<td>${contract.startDate}</td>
			<td>${contract.durationInMonths}</td>
			<td>${contract.salary}</td>
			<td>${contract.extras}</td>
		</tr>
	</table>
	<a href = "<c:url value = 'editContract?id=${contract.playerid}'/>">Edytuj kontrakt</a>
</body>
</html>