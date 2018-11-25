<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<title>Logowanie</title>

<c:set var="loginUrl">
	<c:url value="login" />
</c:set>

<div id="container">
	<div id="logo">Logowanie</div>
	<form method="post" action="${loginUrl}">
		<input type="text" name="username" />
		<input type="password" name="password" />
		<input type="submit" value="Zaloguj" />
	</form>
</div>