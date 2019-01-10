<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<body>
	<div class="fixtures-tables" style="width:99px;">${fixture.dataFormated}</div>
	<div class="fixtures-tables" style="width:54px; font-size:15px;">${fixture.season}</div>
	<div class="fixtures-tables" style="width:54px;">${fixture.round}</div>
	<div class="fixtures-tables" style="width:59px;">${fixture.stadium.name}</div>
	<div class="fixtures-tables" style="width:109px;">${fixture.opponent}</div>
	<div class="fixtures-tables" style="width:104px;">${fixture.league}</div>
    <div class="fixtures-tables" style="width:104px;">${fixture.referee}</div>
    
    W tym meczu wezmą udział następujący użytkownicy:
    <c:forEach items="${matches}" var = "match">
    	${match} <br>
    </c:forEach>
                
</body>
</html>