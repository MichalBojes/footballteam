<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Zarzadzanie uzytkownikami</title>
</head>
<body>
<table>
	<tr>
		<th>Nazwa uztkownika</th>
		<th>Aktualna Rola</th>
		<th>Nadaj role</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.role}</td>
			<td>
			<a href="<c:url value='/changeRole/${user.username}/A' />" >Administrator</a>
			<a href="<c:url value='/changeRole/${user.username}/T' />" >Trener</a>
			<a href="<c:url value='/changeRole/${user.username}/P' />" >Pilkarz</a>
			<a href="<c:url value='/changeRole/${user.username}/F' />" >Fan</a>
			</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>