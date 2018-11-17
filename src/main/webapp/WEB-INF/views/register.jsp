<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<title>Rejestracja</title>
<script src='https://www.google.com/recaptcha/api.js'></script>
<h1>Zarejestruj sie aby korzystać ze wszystkich możliwości strony</h1>
	
<form:form id="register-user-form" action="register" modelAttribute="form" method="post">
		Nazwa Użytkownika: 
		<form:input path="username" id="username"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="username" cssclass="error" /> <br /></c:if>
		Imie:
		<form:input path="name" id="name"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" cssclass="error" /> <br /> </c:if>
		Nazwisko:
		<form:input path="surname" id="surname"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" cssclass="error" /> <br /></c:if>
		Wiek:
		<form:input path="age" id="age"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" cssclass="error" /> <br /></c:if>
		Hasło: 
		<form:input path="password" id="password" type="password"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" cssclass="error" /> <br /></c:if>
		Powtórz hasło: 
		<form:input path="passwordConfirm" id="passwordConfirm"></form:input>
		<c:if test="${pageContext.request.method=='POST'}"><form:errors path="passwordConfirm" cssclass="error" /> <br /></c:if>
		<div class="g-recaptcha" data-sitekey="6LcLBnoUAAAAAPzOYoxMTBLsS7cTVyAR5ECF50Iy">
 		</div>
 		<a href="home"> Anuluj </a>
		<input type="submit" class="submit-button" value="Zarejestruj mnie" />
</form:form>