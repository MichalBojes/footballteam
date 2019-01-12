
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
            
            <span class="bigtitle">Dane Treningu :</span>
			<a href="trainings"><div class="admin-button" style="float:right; padding: 10px; font-size:20px; text-align:center; text-decoration: none;
                color:white;"  >Powrót</div> </a> 
                <div style="clear:both"></div>

			<div class="dottedline"></div>
			
		<div id="squad-container" style="width:550px">

			<div class="fixtures-title" style="width:155px;">Nazwa stadionu</div>
			<div class="fixtures-title" style="width:105px;">Data</div>
			<div class="fixtures-title" style="width:155px;">Typ</div>
			<div style="clear:both"></div>

			<div class="fixtures-tables" style="width:159px;">${training.stadium.name}</div>
			<div class="fixtures-tables" style="width:109px;">${training.data}</div>
			<div class="fixtures-tables" style="width:159px;">${training.type}</div>
			<div style="clear:both"></div>
		</div> 

		<div id="squad-container" style="width:350px">
<c:if test="${fn:length(selectedPlayers) > 0}">


<div class="fixtures-title" style="width:288px; margin-top: 30px;">Wybrani zawodnicy:  </div>

	<c:forEach items="${selectedPlayers}" var = "player">
			<div class="fixtures-tables" style="width:140px;">${player.player.username.name}</div>
			<div class="fixtures-tables" style="width:140px;">${player.player.username.surname}</div>
	</c:forEach>
</c:if>
 
<c:if test="${fn:length(avaliablePlayers) > 0}">

<div class="fixtures-title" style="width:288px;  margin-top: 30px;">Dostepni zawodnicy: </div>
<div style="clear:both"></div>

	<c:forEach items="${avaliablePlayers}" var = "player">
			<div class="fixtures-tables" style="width:109px;">${player.username.name}</div>
			<div class="fixtures-tables" style="width:109px;">${player.username.surname}</div>
	 
	<form:form id="add-player-to-training-hidden-form" action="addPlayerToTraining" modelAttribute="trainingDTO" method="post" style="height:20px;">
		<form:input type="hidden" path="trainingid" value="${training.trainingid}" id="trainingid" style="height:1px;"></form:input>
		<form:input type="hidden" path="playerid" value="${player.playerid}" id="playerid" style="height:1px;"></form:input>
		<input type="submit" class="submit-button" value="Wybierz" style="margin-left: 1px; height: 31px; padding: 4px; margin-top:4px;" />
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
