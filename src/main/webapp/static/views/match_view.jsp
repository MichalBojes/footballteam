
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            
            <span class="bigtitle">Dane Meczu :</span>
			<a href="fixtures"><div class="admin-button" style="float:right; padding: 10px; font-size:20px; text-align:center; text-decoration: none;
                color:white;"  >Powrót</div> </a> 
                <div style="clear:both"></div>

          
			<div class="dottedline"></div>
			
			<div id="squad-container" style="width:730px">

					<div class="fixtures-title" style="width:90px;">Data</div>
					<div class="fixtures-title" style="width:50px;">Sezon</div>
					<div class="fixtures-title" style="width:50px;">Runda</div>
					<div class="fixtures-title" style="width:90px;">Stadion</div>
					<div class="fixtures-title" style="width:90px;">Przeciwnik</div>
					<div class="fixtures-title" style="width:90px;">Liga</div>
					<div class="fixtures-title" style="width:90px;">Sędzia</div>

					<div style="clear:both"></div>

					<div class="fixtures-tables" style="width:94px;">${fixture.dataFormated}</div>
					<div class="fixtures-tables" style="width:54px;">${fixture.season}</div>
					<div class="fixtures-tables" style="width:54px;">${fixture.round}</div>
					<div class="fixtures-tables" style="width:94px;">${fixture.stadium.name}</div>
					<div class="fixtures-tables" style="width:94px;">${fixture.opponent}</div>
					<div class="fixtures-tables" style="width:94px;">${fixture.league}</div>
					<div class="fixtures-tables" style="width:94px;">${fixture.referee}</div>
					<div style="clear:both"></div>
        
				</div>

		<div id="squad-container" style="width:500px">
<c:if test="${fn:length(selectedPlayers) > 0}">

	<div class="fixtures-title" style="width:288px; margin-top: 30px;">Wybrani zawodnicy:</div>
	<div class="fixtures-title" style="width:135px; margin-top: 30px;">Pozycja:</div>
	<div style="clear:both"></div>
	<c:forEach items="${selectedPlayers}" var = "player">
			<div class="fixtures-tables" style="width:140px;">${player.username.name}</div>
			<div class="fixtures-tables" style="width:140px;">${player.username.surname}</div>
			<div class="fixtures-tables" style="width:140px;">${player.position}</div>
			<div style="clear:both"></div>
	</c:forEach>
</c:if>
<c:if test="${fn:length(avaliablePlayers) > 0}">

<div class="fixtures-title" style="width:225px;  margin-top: 30px;">Dostepni zawodnicy: </div>
<div class="fixtures-title" style="width:100px;  margin-top: 30px;">Wpisz pozycję: </div>
<div class="fixtures-title" style="width:75px;  margin-top: 30px;">Zatwierdź </div>
<div style="clear:both"></div>

	<c:forEach items="${avaliablePlayers}" var = "player">
			<div class="fixtures-tables" style="width:109px;">${player.username.name}</div>
			<div class="fixtures-tables" style="width:109px;">${player.username.surname}</div>

	<form:form id="add-unavailability-form" action="addPlayerToMatch" modelAttribute="match" method="post" style="height:20px;">
		<form:input type="hidden" path="fixtureid" value="${fixture.fixtureid}" id="fixtureid" style="height:1px;"></form:input>
		<form:input type="hidden" path="username" value="${player.username.username}" id="username" style="height:1px;"></form:input>
		<form:input class="input-class" path="position" value="${player.position}" id="position" style="width:114px; float:left; margin-top:5px; height: 30px;" ></form:input>
		<input type="submit" class="submit-button" value="Wybierz" style="margin-left: 1px; height: 31px; padding: 4px; margin-top:4px; width: 89px;" />
	</form:form>
	</c:forEach>
</c:if>
</div>
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
