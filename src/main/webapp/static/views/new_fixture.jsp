
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
            
            <span class="bigtitle">Dodawanie meczu</span>
			<div class="dottedline"></div>
			

	<div id="stadium">STADIONY</div>

	<div class="fixtures-title" style="width:160px"> Numer Stadionu </div>
	<div class="fixtures-title" style="width:160px"> Nazwa </div>
	<div class="fixtures-title" style="width:160px"> Pojemność </div>
	<div class="fixtures-title" style="width:160px"> Lokalizacja </div>
	<div style="clear:both"></div>
		
	<c:forEach items="${stadiums}" var="stadium" >
		<div class="fixtures-tables" style="width:164px">${stadium.stadiumid}</div>
		<div class="fixtures-tables" style="width:164px">${stadium.name}</div>
		<div class="fixtures-tables" style="width:164px">${stadium.capacity}</div>
		<div class="fixtures-tables" style="width:164px">${stadium.address}</div>
		<div style="clear:both"></div>
	</c:forEach>

	<div id="fixture-add">

<form:form id="add-fixture-form" action="addFixture" modelAttribute="form" method="post">
		<div class="part">
			Data: 
			<form:input class="input-class" path="data" id="data"></form:input>
		</div>
		<div class="part">
			Runda:
			<form:input class="input-class" type="number"  path="season" id="season"></form:input>
		</div>	
		<div class="part">
			Numer Stadionu:
			<form:input class="input-class" type="number" path="stadiumid" id="stadiumid"></form:input>
		</div>
		<div class="part">
			Przeciwnik:
			<form:input class="input-class" path="opponent" id="opponent"></form:input>
		</div>
		<div class="part">
			Liga: 
			<form:input class="input-class" path="league" id="league" ></form:input>
		</div>
		<div class="part">
			Sędzia: 
			<form:input class="input-class" path="referee" id="referee" ></form:input>
		</div>
 		
		<div id="cancel">
			<a href="fixtures"><input type="button" class="submit-button"  value="Anuluj"></a>
		</div>
		<div id="register">
				<input type="submit" class="submit-button" value="Dodaj Mecz" />
		</div>
		<div style="clear:both;"></div>
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
