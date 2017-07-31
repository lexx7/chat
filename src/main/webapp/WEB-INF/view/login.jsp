<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:c = "http://java.sun.com/jsp/jstl/core" 
	xmlns:sec="http://www.springframework.org/security/tags" version="2.3">

	<form:form class="form-horizontal" method="post" action="login">

		<div class="form-group">
			<label class="control-label col-sm-2" for="username">Представьтесь:</label>
			<div class="col-sm-10">
				<input id="username" name="username" class="form-control"
					placeholder="Введите имя" autofocus="autofocus" />
			</div>
		</div>

		<input id="password" name="password" type="hidden" value="1" />

		<div class="form-group">
			<label class="control-label col-sm-2" for="color">Выберите цвет текста:</label>
			<div class="col-sm-10">
				<select id="color" name="color" class="form-control">
					<option value="BLACK">Чёрный</option>
					<option value="RED" style="color:red">Красный</option>
					<option value="BLUE" style="color:blue">Синий</option>
					<option value="GREEN" style="color:green">Зелёный</option>
				</select>
			</div>
		</div>

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