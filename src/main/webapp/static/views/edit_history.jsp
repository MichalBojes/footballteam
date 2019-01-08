<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form id="edit-history-form" action="editHistory/${history.historyid}" modelAttribute="history" method="post">
		<div class="part">
			<form:input class="input-class" path="value" id="value"></form:input>
		</div>
		<div id="cancel">

			<a href="history"><input type="button" class="submit-button"
				value="Anuluj"></a>
		</div>
		<div id="register">
			<input type="submit" class="submit-button" value="Zapisz zmiany" />
		</div>
		<div style="clear: both;"></div>
	</form:form>
</body>
</html>