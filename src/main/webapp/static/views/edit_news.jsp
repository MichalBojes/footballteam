

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
            
            <span class="bigtitle">Aktualności</span>
            <sec:authorize access="hasAuthority('ROLE_TRAINER')">
                    <a href="<c:url value='/addNews'/>"><div class="admin-button" style="float:right; padding: 10px; font-size:21px; text-decoration: none;
                     color:white;"  >Dodaj aktualność</div> </a> 
                     <div style="clear:both"></div>
            </sec:authorize>
            <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                    <a href="<c:url value='/addNews'/>"><div class="admin-button" style="float:right; padding: 10px; font-size:21px; text-decoration: none;
                     color:white;"  >Dodaj aktualność</div> </a> 
                     <div style="clear:both"></div>
            </sec:authorize>

			<div class="dottedline"></div>
			<div id="player-add">
            ostatnio aktualizowany: ${newsDTO.data}
		<form:form id="edit-news-form" action="confirmEditNews" modelAttribute="newsDTO" method="post">
		<form:input type="hidden" path="newsid" id="newsid"></form:input>
		<form:input type="hidden" path="data" id="data"></form:input>
		<div class="part">
			<form:input class="input-class" path="value" id="value"></form:input>
		</div>
		
		<div id="cancel">

		<a href="home"><input type="button" class="submit-button" value="Anuluj"></a>
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