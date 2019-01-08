
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
            
            <span class="bigtitle">Statystyki zawodnika - ${player.username.name} ${player.username.surname} </span>
			<div class="dottedline"></div>
			
			
			
			<div class="fixtures-title" style="width:105px; height: 35px;">Pozycja</div>
			<div class="fixtures-title" style="width:105px; height: 35px;">Rozegrane mecze</div>
			<div class="fixtures-title" style="width:105px; height: 35px;">Zdobyte bramki</div>
			<div class="fixtures-title" style="width:105px; height: 35px;">Preferowana noga</div>
			<div class="fixtures-title" style="width:105px; height: 35px;">Numer Koszulki</div>
			<div class="fixtures-title" style="width:105px; height: 35px;">Otrzymane Kartki</div>
			<div style="clear:both"></div>
			
		
				<div class="fixtures-tables" style="width:109px;">${player.position}</div>
				<div class="fixtures-tables" style="width:109px;">${player.matchesPlayed}</div>
				<div class="fixtures-tables" style="width:109px;">${player.goalScored}</div>
				<div class="fixtures-tables" style="width:109px;"><c:if test = "${player.preferedFootRight == true}"> Prawa </c:if>
					<c:if test = "${player.preferedFootRight == false}"> Lewa </c:if></div>
				<div class="fixtures-tables" style="width:109px;">${player.shirtNumber}</div>
				<div class="fixtures-tables" style="width:109px;">${player.cardsReceived}</div>
				<div style="clear:both"></div>
               
                <sec:authorize access="hasAuthority('ROLE_TRAINER')">
				<div id="squad-title">
						<a href = "<c:url value = 'editStats?id=${player.playerid}'/>">
						<div class="admin-button" style="padding: 10px; font-size:21px; text-decoration: none; margin-top: 20px; float:left;">Edytuj dane</div></a>
						<a href = "<c:url value = 'unavailability/${player.username.username}'/>">
						<div class="admin-button" style="padding: 10px; font-size:21px; text-decoration: none; margin-top: 20px; float:right;">Zgłoś niedostępność</div></a> 
						<div style="clear:both"></div>
                </div>
                </sec:authorize>
		
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
