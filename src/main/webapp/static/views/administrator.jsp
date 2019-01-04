<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Zarządzanie użytkownikami</title>
</head>
<body>
<table>
	<tr>
		<th>Nazwa użytkownika</th>
		<th>Nadaj rolę</th>
		<th></th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>
			<c:if test = "${user.role == 'ROLE_TRAINER' || user.role == 'ROLE_PLAYER' || user.role == 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/A' />" >Administrator</a>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_TRAINER' || user.role == 'ROLE_PLAYER'}">
			<a href="<c:url value='/changeRole/${user.username}/F' />" >Fan</a>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_TRAINER' || user.role == 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/P' />" >Piłkarz</a>
			</c:if>
			<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_PLAYER' || user.role == 'ROLE_FAN'}">
			<a href="<c:url value='/changeRole/${user.username}/T' />" >Trener</a>
			</c:if>
			</td>
			<td>
			<a href="<c:url value='/deleteUser/${user.username}' />" >Usuń Użytkownika</a>
			</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>