<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:c = "http://java.sun.com/jsp/jstl/core" 
	xmlns:sec="http://www.springframework.org/security/tags" version="2.3">

	<form:form class="form-horizontal" method="post" action="autologin" modelAttribute="userForm">

		<spring:bind path="login">
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="login">Представьтесь:</form:label>
				<div class="col-sm-10">
						<form:input path="login" type="text" class="form-control" placeholder="Введите имя"
									autofocus="autofocus" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<form:input path="password" type="hidden" class="form-control" />
		</spring:bind>

		<spring:bind path="color">
			<div class="form-group">
				<form:label class="control-label col-sm-2" path="color">Выберите цвет текста:</form:label>
				<div class="col-sm-10">
					<form:select path="color" id="color" class="form-control">
						<form:option value="BLACK">Чёрный</form:option>
						<form:option value="RED" style="color:red">Красный</form:option>
						<form:option value="BLUE" style="color:blue">Синий</form:option>
						<form:option value="GREEN" style="color:green">Зелёный</form:option>
					</form:select>
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-default" type="submit" value="Войти" />
			</div>
		</div>
		
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<span class="label label-danger"><strong>Не удалось выполнить вход.</strong> Причина: <c:out
							value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />. </span>
				</div>
			</div>
		</c:if>

	</form:form>

</jsp:root>