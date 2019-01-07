
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
            
            <span class="bigtitle">Terminarz na sezon 2019</span>
            <a href="addFixture"><div id="admin-button" style="float:right; padding: 10px; font-size:21px; text-decoration: none;
            background-color: rgb(143, 94, 94); color:white;"  >Dodaj nowy Mecz</div> </a> 
             <div style="clear:both"></div>
            <div class="dottedline"></div>
        
    
          	<div class="fixtures-title" style="width:95px;">Data</div>
          	<div class="fixtures-title" style="width:55px;">Sezon</div>
          	<div class="fixtures-title" style="width:55px;">Runda</div>
          	<div class="fixtures-title" style="width:105px;">Stadion</div>
          	<div class="fixtures-title" style="width:105px;">Przeciwnik</div>
          	<div class="fixtures-title" style="width:105px;">Liga</div>
            <div class="fixtures-title" style="width:105px;">Sędzia</div>
            <div style="clear:both"></div>
        
          	<th></th>
          <c:forEach items="${fixturesList}" var="fixture" >
                <div class="fixtures-tables" style="width:99px; font-size:1px;">${fixture.data}</div>
				<div class="fixtures-tables" style="width:59px; font-size:15px;">${fixture.season}</div>
				<div class="fixtures-tables" style="width:59px;">${fixture.round}</div>
				<div class="fixtures-tables" style="width:109px;">${fixture.stadiumid.name}</div>
				<div class="fixtures-tables" style="width:109px;">${fixture.opponent}</div>
				<div class="fixtures-tables" style="width:109px;">${fixture.league}</div>
                <div class="fixtures-tables" style="width:109px;">${fixture.referee}</div>
                <div style="clear:both"></div>
				<td><a href = "<c:url value = '/match/{fixture.fixtureid}'/>">Wybierz skład</a></td>
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
