
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
            <c:forEach items="${news}" var="news_value">			    
            <a href="<c:url value='/editNews?id=${news_value.newsid}'/>">Edytuj</a><br>
            <div id="news-data">
                ${news_value.data}<br>
            </div>
            <div id="news">
               
                ${news_value.value} 
            </div>
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
