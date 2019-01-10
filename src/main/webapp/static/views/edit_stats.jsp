
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
            
            <span class="bigtitle">Edycja statystyk zawodnika -${playerDTO.username.name} ${playerDTO.username.surname}</span>
            <div class="dottedline"></div>
         
			<div id="player-add">
			<form:form id="edit-stats-form" action="confirmEditStats" modelAttribute="playerDTO" method="post">
					<form:input type="hidden" path="playerid" id="playerid"></form:input>
					<div class="part">
						Pozycja:
						<form:input class="input-class" path="position" id="position"></form:input>
					</div>
					<div class="part">
						Rozegrane mecze:
						<form:input class="input-class" path="matchesPlayed" id="matchesPlayed"></form:input>
					</div>
					<div class="part">
						Gole:
						<form:input class="input-class" path="goalScored" id="goalScored"></form:input>
					</div>
					<div class="part">
						Preferowana prawa noga:
						<form:checkbox class="checkbox-class" path="preferedFootRight" id="preferedFootRight"></form:checkbox>
					</div>
					<div class="part">
						Numer koszulki:
						<form:input class="input-class" path="shirtNumber" id="shirtNumber"></form:input>
					</div>
					<div class="part">
						Kartki:
						<form:input class="input-class" path="cardsReceived" id="cardsReceived"></form:input>
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
