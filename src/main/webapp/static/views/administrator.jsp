<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
	<%@ include file = "header.jsp" %>
<body onload="start()">

	<div id="wrapper">  
	<%@ include file = "menu.jsp" %>
			
	<div id="container">
					<div id="photos">
						<div id="player"></div>
						<div id="team">
							<img src="/images/team1.jpg" width="250px" height=300px />
						</div>
				 
				</div>
				<div id="main">
				
			
					<%@ include file = "topbar.jsp" %>
			
					<%@ include file = "sidebar.jsp" %>
			
					<div id="content">
						
						<span class="bigtitle">Panel administratora</span>
						<div class="dottedline"></div>

						
								
									<div id="admin-title">Nazwa użytkownika</div>
									<div id="admin-title" style="width:296px;">Nadaj rolę</div>
									<!--
									<div id="admin-title" style="width:176px; margin-right:0px;">Usuń</div>-->
									<div style="clear:both"></div>
								
								
								<c:forEach items="${users}" var="user">
										
										<div id="admin-username">${user.username}</div>
										<div id="admin-username" style="width:288px ; margin-left: 20px ">
										<c:if test = "${user.role == 'ROLE_TRAINER' || user.role == 'ROLE_PLAYER' || user.role == 'ROLE_FAN'}">
										<a href="<c:url value='/changeRole/${user.username}/A' />" > <div class="admin-button">Admin</div></a>
										</c:if>
										<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_TRAINER' || user.role == 'ROLE_PLAYER'}">
										<a href="<c:url value='/changeRole/${user.username}/F' />" > <div class="admin-button">Fan</div></a>
										</c:if>
										<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_TRAINER' || user.role == 'ROLE_FAN'}">
										<a href="<c:url value='/changeRole/${user.username}/P' />" > <div class="admin-button">Piłkarz</div></a>
										</c:if>
										<c:if test = "${user.role == 'ROLE_ADMIN' || user.role == 'ROLE_PLAYER' || user.role == 'ROLE_FAN'}">
										<a href="<c:url value='/changeRole/${user.username}/T' />" > <div class="admin-button">Trener</div></a>
										</c:if>
										</div>
										<!--
										<div id="admin-username" style="width:168px ; margin-left: 20px">
										<c:choose>
										<c:when  test = "${user.role == 'ROLE_TRAINER' || user.role == 'ROLE_PLAYER' || user.role == 'ROLE_FAN'}">
										<a href="<c:url value='/deleteUser/${user.username}' />" > <div class="admin-button">Usuń Użytkownika</div></a>
										</c:when>	
										<c:otherwise>
										<div class="admin-button">Nie można usunąć</div>
										</c:otherwise>
									</c:choose>
								</div>-->
									<div style="clear:both"></div>
									</c:forEach>
							

						</div>
			
					<%@ include file = "footer.jsp" %>
					
				</div>
			
				<%@ include file = "reje.jsp" %>
			
				<%@ include file = "czat.jsp" %>
			
				</div>
				
					
					<script>
					
					$(document).ready(function(){
						var NavY = $('#menu').offset().top;
			
						var stickyNav = function(){
						var Scrolly = $(window).scrollTop();
			
						if(Scrolly>NavY) {
							$('#menu').addClass('sticky');
						}else{
							$('#menu').removeClass('sticky');
						}
						};
			
						stickyNav();
			
						$(window).scroll(function(){
							stickyNav();
						});
					});
					
					
					</script>
			   
			</div>  
			</body>
			





</body>
</html>