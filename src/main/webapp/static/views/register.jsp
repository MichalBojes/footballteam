<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<title>Rejestracja</title>
<script src='https://www.google.com/recaptcha/api.js'></script>

<link rel="stylesheet" href="/css/style_register.css" type="text/css"/> 

<div id="container">
		<div id="logo">
			Rejestracja
		</div>
		

	<form:form id="register-user-form" action="register" modelAttribute="form" method="post">
		<div class="part">
			Nazwa Użytkownika: 
			<form:input path="username" id="username"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="username" cssclass="error" /> <br /></c:if>
		</div>
		<div class="part">
			Imie:
			<form:input path="name" id="name"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" cssclass="error" /> <br /> </c:if>
		</div>	
		<div class="part">
			Nazwisko:
			<form:input path="surname" id="surname"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" cssclass="error" /> <br /></c:if>
		</div>
		<div class="part">
			Wiek:
			<form:input path="age" id="age"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" cssclass="error" /> <br /></c:if>
		</div>
		<div class="part">
			Hasło: 
			<form:input path="password" id="password" type="password"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" cssclass="error" /> <br /></c:if>
		</div>
		<div class="part">
			Powtórz hasło: 
			<form:input path="passwordConfirm" id="passwordConfirm"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="passwordConfirm" cssclass="error" /> <br /></c:if>
		</div>
		<div class="g-recaptcha" data-sitekey="6LcLBnoUAAAAAPzOYoxMTBLsS7cTVyAR5ECF50Iy">
 		</div>
 		
		<div id="cancel">
			<a href="home"> Anuluj </a>
		</div>
		<div id="register">
				<input type="submit" class="submit-button" value="Zarejestruj mnie" />
		</div>
		<div style="clear:both;"></div>
	</form:form>




</div>