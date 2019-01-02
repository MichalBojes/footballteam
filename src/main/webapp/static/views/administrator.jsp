<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>
			Nazwa uztkownika
		</th>
		<th>
			Nadaj rolw™
		</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>
			<c:if test = "${user.role == 'ROLE_TRAINER' || 'ROLE_PLAYER' || 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/A' />" >Administrator</a><br>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || 'ROLE_PLAYER' || 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/T' />" >Trener</a><br>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || 'ROLE_TRAINER' || 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/P' />" >Pilkarz</a><br>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || 'ROLE_TRAINER' || 'ROLE_PLAYER'}">
			<a href="<c:url value='/changeRole/${user.username}/F' />" >Fan</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>