
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
                      
                      <span class="bigtitle">Spis treningów</span>
                   
                      <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <a href="addTraining"><div class="admin-button" style="float:right; padding: 10px; font-size:20px; text-decoration: none;
             color:white;"  >Dodaj nowy Trening</div> </a> 
             <div style="clear:both"></div>
            </sec:authorize>
            <div class="dottedline"></div>

            <div id="squad-container" style="width:400px">
          	<div class="fixtures-title" style="width:95px;">Data</div>
          	<div class="fixtures-title" style="width:55px;">Stadion</div>
          	<div class="fixtures-title" style="width:105px;">Typ</div>
            <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <div class="fixtures-title" style="width:55px;">Skład</div>
            </sec:authorize>
            <div style="clear:both"></div>
        
         
          <c:forEach items="${trainingsList}" var="training" >
                <div class="fixtures-tables" style="width:99px;">${training.data}</div>
				<div class="fixtures-tables" style="width:59px;">${training.stadium.name}</div>
				<div class="fixtures-tables" style="width:109px;">${training.type}</div>
                <sec:authorize access="hasAuthority('ROLE_TRAINER')">
                <a href = "<c:url value = '/training?id=${training.trainingid}'/>"><div class="fixtures-tables2" style="width:59px;">Ustal</div></a>
                </sec:authorize>
                <div style="clear:both"></div>
				
          </c:forEach>
                      
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
          