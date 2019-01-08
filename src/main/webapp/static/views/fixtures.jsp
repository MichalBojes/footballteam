
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
            <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <a href="addFixture"><div class="admin-button" style="float:right; padding: 10px; font-size:21px; text-decoration: none;
             color:white;"  >Dodaj nowy Mecz</div> </a> 
             <div style="clear:both"></div>
            </sec:authorize>
            <div class="dottedline"></div>

          	<div class="fixtures-title" style="width:95px;">Data</div>
          	<div class="fixtures-title" style="width:50px;">Sezon</div>
          	<div class="fixtures-title" style="width:50px;">Runda</div>
          	<div class="fixtures-title" style="width:55px;">Stadion</div>
          	<div class="fixtures-title" style="width:105px;">Przeciwnik</div>
          	<div class="fixtures-title" style="width:100px;">Liga</div>
            <div class="fixtures-title" style="width:100px;">Sędzia</div>
            <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <div class="fixtures-title" style="width:55px;">Skład</div>
            </sec:authorize>
            <div style="clear:both"></div>
        
         
          <c:forEach items="${fixturesList}" var="fixture" >
                <div class="fixtures-tables" style="width:99px;">${fixture.dataFormated}</div>
				<div class="fixtures-tables" style="width:54px; font-size:15px;">${fixture.season}</div>
				<div class="fixtures-tables" style="width:54px;">${fixture.round}</div>
				<div class="fixtures-tables" style="width:59px;">${fixture.stadium.name}</div>
				<div class="fixtures-tables" style="width:109px;">${fixture.opponent}</div>
				<div class="fixtures-tables" style="width:104px;">${fixture.league}</div>
                <div class="fixtures-tables" style="width:104px;">${fixture.referee}</div>
                <sec:authorize access="hasAuthority('ROLE_TRAINER')">
                <a href = "<c:url value = '/match/{fixture.fixtureid}'/>"><div class="fixtures-tables2" style="width:59px;">Edytuj</div></a>
                </sec:authorize>
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
