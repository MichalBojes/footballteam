
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
            Informacje o składzie będą dostępne niedługo ;)
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
