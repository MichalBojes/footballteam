<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<body onload="start()">
<div id="czat">
    <c:forEach items="${messagesList}" var = "message">
    	${message.user.username} ${message.content} ${message.data} <br>
    </c:forEach>
	<form:form id="add-training-form" action="addMessage?page=${pageNumber}" modelAttribute="newMessage" method="post">
		<div class="part"> 
			<form:input class="input-class" path="content" id="content"></form:input>
		</div>
		<div id="butto">
				<input type="submit" class="submit-button" value="Wyślij" />
		</div>
		<div style="clear:both;"></div>
	</form:form>
    <c:if test = "${pageNumber < lastPageNumber}" ><a href= "<c:url value='/chat?page=${next}'/>">Pokaż starsze wiadomości</a></c:if>
    <c:if test = "${pageNumber > 1}" ><a href= "<c:url value='/chat?page=${previous}'/>">Pokaż nowsze wiadomości</a></c:if>
</div>
</body>