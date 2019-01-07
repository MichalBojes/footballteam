<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file = "header.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

STADIONY 
<table>
	<tr>
		<th> Numer Stadionu</th>
		<th> Nazwa</th>
		<th> Pojemność</th>
		<th> Lokalizacja</th>
	</tr>
	<c:forEach items="${stadiums}" var="stadium" >
		<tr>
			<td>${stadium.stadiumid}</td>
			<td>${stadium.name}</td>
			<td>${stadium.capacity}</td>
			<td>${stadium.address}</td>
		</tr>
	</c:forEach>
</table>

<form:form id="add-fixture-form" action="addFixture" modelAttribute="form" method="post">
		<div class="part">
			Data: 
			<form:input class="input-class" path="data" id="data"></form:input>
		</div>
		<div class="part">
			Runda:
			<form:input class="input-class" path="season" id="season"></form:input>
		</div>	
		<div class="part">
			Numer Stadionu:
			<form:input class="input-class" path="stadiumid" id="stadiumid"></form:input>
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

</body>
