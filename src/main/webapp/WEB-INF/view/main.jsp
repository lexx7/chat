<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
		  xmlns:sec="http://www.springframework.org/security/tags"
		  version="2.3">

	<script type="application/javascript" src="${pageContext.request.contextPath}/js/message.js" />

	<div id="viewMessage" data-href="${pageContext.request.contextPath}/message/"></div>

	<div id="dataGrid" data-href="${pageContext.request.contextPath}/message/list">
		<table id="messageGrid"></table>
		<div id="pmessageGrid"></div>
	</div>

</jsp:root>