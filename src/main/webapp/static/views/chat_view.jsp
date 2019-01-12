
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
            
            <span class="bigtitle">Czat</span>
            
            <div class="dottedline"></div>

            <div id="chat">
				<c:forEach items="${messagesList}" var = "message">
					<div class="chat-message">
						<div class="chat-username">
							${message.user.username} 
						</div>
						<div class="chat-date">
							[${message.time}] : 
						</div>
						<div class="chat-value">
							${message.content}
						</div>
						<div style="clear:both"></div>
					</div>
				</c:forEach>
				<form:form id="add-training-form" action="addMessage?page=${pageNumber}" modelAttribute="newMessage" method="post">
					<div class="part"> 
						<form:input class="input-class" path="content" id="chat-input" style="width:550px;"></form:input>
					</div>
					<div id="button-middle">
					<div id="button">
							<input type="submit" class="submit-button" style=" margin-left:auto; display:inherit; width:300px;  margin-right: auto;" value="Wyślij" />
					</div>
					</div>
					
				</form:form>
				
				<c:if test = "${pageNumber < lastPageNumber}" ><a href= "<c:url value='/chat?page=${next}'/>">
				<div class="admin-button" style="height: 20px; font-size: 15px; margin-bottom: 10px; float:left; ">Pokaż starsze wiadomości</div></a></c:if>
				<c:if test = "${pageNumber > 1}" ><a href= "<c:url value='/chat?page=${previous}'/>">
				<div class="admin-button"  style="height: 20px; font-size: 15px; margin-bottom: 10px; float:right; ">Pokaż nowsze wiadomości</div></a></c:if>
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
