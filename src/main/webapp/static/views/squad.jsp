
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


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
            
            <span class="bigtitle">Skład</span>
            <div class="dottedline"></div>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <div id="squad-container" style="width:300px">
            </c:if>
            <sec:authorize access="hasAuthority('ROLE_ADMIN')"> 
                    <div id="squad-container" style="width:590px">
            </sec:authorize>
	            	<th></th>
            <sec:authorize access="hasAuthority('ROLE_PLAYER')"> 
                    <div id="squad-container" style="width:600px">
            </sec:authorize>

            <sec:authorize access="hasAuthority('ROLE_FAN')"> 
                    <div id="squad-container" style="width:380px">
            </sec:authorize>
           
         
	            	<div class="fixtures-title" style="width:105px;">Imię</div>
                    <div class="fixtures-title" style="width:105px;">Nazwisko</div>

                    <sec:authorize access="hasAuthority('ROLE_TRAINER')"> 
                    <div class="fixtures-title" style="width:440px;">Działania</div>
                    </sec:authorize>

                    <sec:authorize access="hasAuthority('ROLE_ADMIN')"> 
                    <div class="fixtures-title" style="width:318px;">Działania</div>
                    </sec:authorize>

                    <sec:authorize access="hasAuthority('ROLE_PLAYER')"> 
                    <div class="fixtures-title" style="width:328px;">Działania</div>
                    </sec:authorize>

                    <sec:authorize access="hasAuthority('ROLE_FAN')"> 
                    <div class="fixtures-title" style="width:96px;">Działania</div>
                    </sec:authorize>

                    <div style="clear:both"></div>

	            <c:forEach items = "${players}" var="player">
                        <div class="fixtures-tables" style="width:109px;">${player.username.name}</div> 
                        <div class="fixtures-tables" style="width:109px;">${player.username.surname}</div>
		            
                        <sec:authorize access="hasAuthority('ROLE_TRAINER')"> 
                         <a href = "<c:url value = '/stats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Statystyki</div></a>
                         <a href = "<c:url value = '/editStats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Edytuj dane</div></a>
			            <a href = "<c:url value = '/contract?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Wyświetl Kontrakt</div></a>
						<a href = "<c:url value = '/unavailability?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:110px;">Wyświetl niedostępności</div></a>
                        <a href = "<c:url value = '/addUnavailability?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:110px;">Niedostępność</div></a>
                        </sec:authorize>

                        <sec:authorize access="hasAuthority('ROLE_ADMIN')"> 
                                <a href = "<c:url value = '/stats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Statystyki</div></a>
                                <a href = "<c:url value = '/editStats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Edytuj dane</div></a>
                                <a href = "<c:url value = '/contract?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Kontrakt</div></a>
                        </sec:authorize>

                        <sec:authorize access="hasAuthority('ROLE_PLAYER')"> 
                                <a href = "<c:url value = '/stats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Statystyki</div></a>
                                <a href = "<c:url value = '/contract?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Kontrakt</div></a>
                                <a href = "<c:url value = '/unavailability?username=${player.username.username}'/>"><div class="fixtures-tables2" style="width:110px;">Niedostępność</div></a>
                        </sec:authorize>

                        <sec:authorize access="hasAuthority('ROLE_FAN')"> 
                                <a href = "<c:url value = '/stats?id=${player.playerid}'/>"><div class="fixtures-tables2" style="width:100px;">Statystyki</div></a>
                        </sec:authorize>

                        <div style="clear:both"></div>
                </c:forEach>
                <sec:authorize access="hasAuthority('ROLE_FAN')"> 
                    </div>
                </sec:authorize>
                <sec:authorize access="hasAuthority('ROLE_PLAYER')"> 
                    </div>
                </sec:authorize>
                <sec:authorize access="hasAuthority('ROLE_ADMIN')"> 
                    </div>
                </sec:authorize>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    </div>
                </c:if> 
           
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
