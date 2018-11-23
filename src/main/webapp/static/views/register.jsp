<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<title>Rejestracja</title>
<script src='https://www.google.com/recaptcha/api.js'></script>
<link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Comfortaa" rel="stylesheet">

<link rel="stylesheet" href="/css/style_register.css" type="text/css"/> 

<div id="container">
		<div id="logo">
			Rejestracja
		</div>
		

	<form:form id="register-user-form" action="register" modelAttribute="form" method="post">
		<div class="part">
			Nazwa Użytkownika: 
			<form:input class="input-class" path="username" id="username"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="username" cssclass="error" /> </c:if>
		</div>
		<div class="part">
			Imie:
			<form:input class="input-class" path="name" id="name"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" cssclass="error" />  </c:if>
		</div>	
		<div class="part">
			Nazwisko:
			<form:input class="input-class" path="surname" id="surname"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" cssclass="error" /> </c:if>
		</div>
		<div class="part">
			Wiek:
			<form:input class="input-class" path="age" id="age"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" cssclass="error" /> </c:if>
		</div>
		<div class="part">
			Hasło: 
			<form:input class="input-class" path="password" id="password" type="password"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" cssclass="error" /> </c:if>
		</div>
		<div class="part">
			Powtórz hasło: 
			<form:input class="input-class" path="passwordConfirm" id="passwordConfirm"></form:input>
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="passwordConfirm" cssclass="error" /> </c:if>
		</div>
		<div class="g-recaptcha" data-sitekey="6LcLBnoUAAAAAPzOYoxMTBLsS7cTVyAR5ECF50Iy">
 		</div>
 		
		<div id="cancel">
			
			<a href="home"><input type="button" class="submit-button"  value="Anuluj"></a>
		</div>
		<div id="register">
				<input type="submit" class="submit-button" value="Zarejestruj mnie" />
		</div>
		<div style="clear:both;"></div>
	</form:form>




</div>