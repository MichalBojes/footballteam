<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


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
            <div class="dottedline"></div>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a mi odio. Cras molestie tellus interdum ullamcorper porttitor. 
            Sed eu arcu diam. Morbi venenatis pharetra eros, at vehicula leo porttitor eu. Phasellus iaculis ac nisi ut vehicula. 
            Morbi vulputate tortor eu odio scelerisque posuere. Pellentesque in consequat diam, ac bibendum ante. In sagittis,
             erat at pulvinar egestas, sapien dui laoreet est, vel blandit lectus nisl ac lacus.

             <br/>
             Vestibulum posuere nibh vitae sem faucibus mattis. Donec rhoncus porttitor sagittis. Ut id tempus odio. 
             Fusce sed nisl dignissim, pellentesque ligula vitae, rutrum est.
              Phasellus sit amet velit ac dui facilisis malesuada. Nullam at congue velit. 
              Integer bibendum consequat nisl, ut malesuada nulla rhoncus eget
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
