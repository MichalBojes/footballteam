
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
            
            <span class="bigtitle">Obecność kibiców na danym meczu </span>
            
			<div class="dottedline"></div>

			<div class="fixtures-title" style="width:95px;">Data</div>
          	<div class="fixtures-title" style="width:50px;">Sezon</div>
          	<div class="fixtures-title" style="width:50px;">Runda</div>
          	<div class="fixtures-title" style="width:65px;">Stadion</div>
          	<div class="fixtures-title" style="width:105px;">Przeciwnik</div>
          	<div class="fixtures-title" style="width:100px;">Liga</div>
			<div class="fixtures-title" style="width:100px;">Sędzia</div>
			<div style="clear:both"></div>
			
			<div class="fixtures-tables" style="width:99px;">${fixture.dataFormated}</div>
			<div class="fixtures-tables" style="width:54px; ">${fixture.season}</div>
			<div class="fixtures-tables" style="width:54px;">${fixture.round}</div>
			<div class="fixtures-tables" style="width:69px;">${fixture.stadium.name}</div>
			<div class="fixtures-tables" style="width:109px;">${fixture.opponent}</div>
			<div class="fixtures-tables" style="width:104px;">${fixture.league}</div>
			<div class="fixtures-tables" style="width:104px;">${fixture.referee}</div>
			<div style="clear:both"></div>

			<p style="font-size:20px; margin-right: auto; margin-left: auto;">W tym meczu wezmą udział następujący użytkownicy:.</p>
			
			<c:forEach items="${matches}" var = "match">
				${match} <br>
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
