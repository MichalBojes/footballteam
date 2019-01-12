
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
            
            <span class="bigtitle">Statystyki zawodnika - ${player.username.name} ${player.username.surname}</span>
            
            <div class="dottedline"></div>
			
			<div id="fixture-add">

            <form:form id="edit-contract-form" action="confirmEditContract" modelAttribute="contractDTO" method="post">
			<form:input type="hidden" path="playerid" id="playerid"></form:input>
		<div class="part">
				Wartość:
			<form:input class="input-class" path="value" id="value"></form:input>
		</div>
		<div class="part">
				Data zawarcia:
			<form:input class="input-class" path="startDate" id="startDate"></form:input>
		</div>
		<div class="part">
				Czas trwania:
			<form:input class="input-class" path="durationInMonths" id="durationInMonths"></form:input>
		</div>
		<div class="part">
			Pensja:
			<form:input class="input-class" path="salary" id="salary"></form:input>
		</div>
		<div class="part">
			Premie:
			<form:input class="input-class" path="extras" id="extras"></form:input>
		</div>
		
		<div id="cancel">

			<a href="squad"><input type="button" class="submit-button"
				value="Powrót"></a>
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
