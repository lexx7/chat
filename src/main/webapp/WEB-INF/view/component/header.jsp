<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root
		xmlns:jsp="http://java.sun.com/JSP/Page"
		xmlns:sec="http://www.springframework.org/security/tags"
		xmlns:spring="http://www.springframework.org/tags"
		xmlns:form="http://www.springframework.org/tags/form"
		xmlns:c="http://java.sun.com/jsp/jstl/core"
		xmlns:tiles="http://tiles.apache.org/tags-tiles"
		version="2.3">

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="nav navbar-header">
				<div class="navbar-brand"><a href="${pageContext.request.contextPath}/">Chat</a></div>
			</div>
			<ul class="nav navbar-nav navbar-left">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Вход</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li>Hello,&#160;<sec:authentication property="principal.username"/></li>
					<li>
						<form:form action="${pageContext.request.contextPath}/logout">
							<button class="btn btn-link navbar-btn" type="submit"><span class="glyphicon glyphicon-log-out"/> Выход</button>
						</form:form>
					</li>
				</sec:authorize>
			</ul>
		</div>
	</nav>


</jsp:root>