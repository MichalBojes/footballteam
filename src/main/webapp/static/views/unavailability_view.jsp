
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
            
			<span class="bigtitle">Niedostępności</span>
			<a href="squad"><div class="admin-button" style="float:right; padding: 5px; font-size:20px; text-align:center; text-decoration: none;
                     color:white;"  >Powrót</div> </a> 
                     <div style="clear:both"></div>
            
            <div class="dottedline"></div>

			<div id="squad-container" style="width:700px"></div>

			<div class="fixtures-title" style="width:90px;">Imię</div>
			<div class="fixtures-title" style="width:90px;">Nazwisko</div>
			<div class="fixtures-title" style="width:125px;">Data zdarzenia</div>
			<div class="fixtures-title" style="width:105px;">Dlugość(dni)</div>
			<div class="fixtures-title" style="width:155px;">Powód</div>
			<div class="fixtures-title" style="width:75px;">ID meczu</div>
			<div style="clear:both"></div>
					
					<c:forEach items="${unavailabiltiesDTO}" var = "unavailabilty">
							<div class="fixtures-tables" style="width:94px;">${unavailabilty.player.username.name}</div>
							<div class="fixtures-tables" style="width:94px;">${unavailabilty.player.username.surname}</div>
							<div class="fixtures-tables" style="width:129px;">${unavailabilty.occurreDate}</div>
							<div class="fixtures-tables" style="width:109px;">${unavailabilty.durationInDays}</div>
							<div class="fixtures-tables" style="width:159px;">${unavailabilty.reason}</div>
							<a href ="<c:url value ='fixture?id=${unavailabilty.fixture.fixtureid}'/>">
							<div class="fixtures-tables2" style="width:79px; text-decoration: none;">${unavailabilty.fixture.fixtureid}</div></a>
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
