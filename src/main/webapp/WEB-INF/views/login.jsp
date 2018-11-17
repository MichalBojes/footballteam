<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<title>Logowanie</title>
<h1>Zaloguj się aby korzystać ze wszystkich możliwości strony</h1>
	
<form:form id="login-user-form" action="login" modelAttribute="form" method="post">
		Nazwa Użytkownika: 
		<form:input path="username" id="username"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="username" cssclass="error" /> <br /></c:if>
		Hasło: 
		<form:input path="password" id="password" type="password"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" cssclass="error" /> <br /></c:if>
 		<a href="home"> Anuluj </a>
		<input type="submit" class="submit-button" value="Zaloguj" />
</form:form>