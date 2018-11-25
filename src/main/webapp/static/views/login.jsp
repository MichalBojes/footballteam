<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false"
    contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
    
    
  <link rel="stylesheet" href="/css/style_login.css" type="text/css"/>

<title>Logowanie</title>

<c:set var="loginUrl">
	<c:url value="login" />
</c:set>

<div id="container">
	<div id="logo">Logowanie</div>
	    <form method="post" action="${loginUrl}">
        <div class="part">
            Nazwa użytkownika:
            <input type="text" class="input-class" name="username" />
        </div>
        <div class="part">
            Hasło:
            <input type="password"  class="input-class" name="password" />
        </div>
        <div id="cancel">
                <a href="home"><input type="button" class="submit-button"  value="Anuluj"></a>
        </div>
        <div id="register">
            <input type="submit" class="submit-button" value="Zaloguj" />
        </div>
	</form>
</div>