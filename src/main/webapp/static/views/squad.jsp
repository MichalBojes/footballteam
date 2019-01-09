
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
            
            <span class="bigtitle">Skład</span>
            <div class="dottedline"></div>
            <table>
	            <tr>
	            	<th>Imię</th>
	            	<th>Nazwisko</th>
	            	<th></th>
	            	<th></th>
	            	<th></th>
	            </tr>
	            <c:forEach items = "${players}" var="player">
		            <tr>
			            <td>${player.username.name}</td> 
			            <td>${player.username.surname}</td>
			            <td><a href = "<c:url value = '/stats?id=${player.playerid}'/>">Wyświetl Statystyki</a></td>
			            <td><a href = "<c:url value = '/contract?id=${player.playerid}'/>">Wyświetl Kontrakt</a></td>
						<td><a href = "<c:url value = '/unavailability?username=${player.username.username}'/>">Zgłoś niedostępność</a></td>
		            </tr>
	            </c:forEach>
            </table>
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
