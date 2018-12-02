<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<div id="reje">
    Panel użytkownika </br>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
	   <a href="login"><input type="submit" class="submit-button"  value="Logowanie"></a>
	   <a href="register"><input type="submit"  class="submit-button" value="Rejestracja"></br></a>
    </c:if>
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
    	<a href="admin"><input type="submit" class="submit-button"  value="Administracja"></a>
    </sec:authorize>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
   		<a href="logout"><input type="submit" class="submit-button" value="Wyloguj"></br></a>
    </c:if>
</div>