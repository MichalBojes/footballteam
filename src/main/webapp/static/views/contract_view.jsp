
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
            
            <span class="bigtitle">Kontrakt - ${player.username.name} ${player.username.surname}</span>
            <a href="squad"><div class="admin-button" style="float:right; padding: 10px; font-size:15px; text-align:center; text-decoration: none;
                color:white;"  >Powrót</div> </a> 

            <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <a href="<c:url value = 'editContract?id=${contract.playerid}'/>"><div class="admin-button" style="float:right; padding: 10px; font-size:15px; text-decoration: none;
            color:white;"  >Edytuj kontrakt</div> </a> 
            </sec:authorize>
            <div style="clear:both"></div>

            <div class="dottedline"></div>
            
            <div id="squad-container" style="width:650px">
            <div class="fixtures-title" style="width:105px;">Wartość</div>
            <div class="fixtures-title" style="width:115px;">Data zawarcia</div>
            <div class="fixtures-title" style="width:105px;">Czas trwania</div>
            <div class="fixtures-title" style="width:105px;">Pensja</div>
            <div class="fixtures-title" style="width:105px;">Premie</div>
            <div style="clear:both"></div>
				
            <div class="fixtures-tables" style="width:109px;">${contract.value}</div> 
            <div class="fixtures-tables" style="width:119px;">${contract.startDate}</div> 
            <div class="fixtures-tables" style="width:109px;">${contract.durationInMonths}</div> 
            <div class="fixtures-tables" style="width:109px;">${contract.salary}</div> 
            <div class="fixtures-tables" style="width:109px;">${contract.extras}</div> 
            <div style="clear:both"></div>
					
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
