
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
            
			<span class="bigtitle">Zgłaszanie niedostępności </span>
			<a href="squad"><div class="admin-button" style="float:right; padding: 5px; font-size:20px; text-align:center; text-decoration: none;
				color:white;"  >Powrót</div> </a> 
				<div style="clear:both"></div>
         
			<div class="dottedline"></div>
			
			<div class="fixtures-title" style="width:45px;">ID</div>
			<div class="fixtures-title" style="width:85px;">Data</div>
			<div class="fixtures-title" style="width:45px;">Sezon</div>
			<div class="fixtures-title" style="width:55px;">Runda</div>
			<div class="fixtures-title" style="width:85px;">Stadion</div>
			<div class="fixtures-title" style="width:85px;">Przeciwnik</div>
			<div class="fixtures-title" style="width:95px;">Liga</div>
		 	<div class="fixtures-title" style="width:105px;">Sędzia</div>


			<c:forEach items="${fixturesList}" var="fixture" >
	<div class="fixtures-tables" style="width:49px;">${fixture.fixtureid}</div>
    <div class="fixtures-tables" style="width:89px;">${fixture.dataFormated}</div>
	<div class="fixtures-tables" style="width:49px;">${fixture.season}</div>
	<div class="fixtures-tables" style="width:59px;">${fixture.round}</div>
	<div class="fixtures-tables" style="width:89px;">${fixture.stadium.name}</div>
	<div class="fixtures-tables" style="width:89px;">${fixture.opponent}</div>
	<div class="fixtures-tables" style="width:99px;">${fixture.league}</div>
    <div class="fixtures-tables" style="width:109px;">${fixture.referee}</div>
    <div style="clear:both"></div>
</c:forEach>

<div id="player-add">
<form:form id="add-unavailability-form" action="confirmUnavailability" modelAttribute="unavailabilityDTO" method="post">

		<form:input type="hidden" path="player.playerid" id="player.playerid"></form:input>
		<div class="part">
			ID meczu:
			<form:input class="input-class" path="fixture.fixtureid" type="number" id="fixture.fixtureid"></form:input>
		</div>
		<div class="part">
			Data wystąpienia:
			<form:input class="input-class" path="occurreDate" id="occurreDate"></form:input>
		</div>
		<div class="part">
			Długość trwania:
			<form:input class="input-class" path="durationInDays" type="number" id="durationInDays"></form:input>
		</div>
		<div class="part">
			Powód:
			<form:input class="input-class" path="reason" id="reason"></form:input>
		</div>
		
		<div id="cancel">

			<a href="squad"><input type="button" class="submit-button"
				value="Anuluj"></a>
		</div>
		<div id="register">
			<input type="submit" class="submit-button" value="Zapisz zmiany" />
		</div>
		<div style="clear: both;"></div>
	</form:form>
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
