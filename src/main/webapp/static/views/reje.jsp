<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<div id="reje">
    Panel użytkownika </br>
    <div class="dottedline" style="margin-top:0px; margin-bottom: 0px;"></div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
	   <a href="login"><input type="submit" class="submit-button" style="margin-top:30px;" value="Logowanie"></a>
	   <a href="register"><input type="submit"  class="submit-button" style="margin-top:30px;" value="Rejestracja"></br></a>
    </c:if>
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
    	<a href="admin"><input type="submit" class="submit-button" style="margin-top:30px;"  value="Administracja"></a>
    </sec:authorize>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
   		<a href="logout"><input type="submit" class="submit-button" style="margin-top:30px;" value="Wyloguj"></br></a>
    </c:if>
</div>