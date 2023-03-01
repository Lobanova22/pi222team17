<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Авторизация администратора</title>
	</head>
	<body>
	<form class="form" action="${pageContext.request.contextPath}/login" method="post">
		<h1 class="form_title">Авторизация</h1>
		<div class="form_group">
			<input class="form_input" placeholder="Логин" name="username" value="${username}">
			<label class="form_label"></label>
		</div>

		<div class="form_group">
			<input class="form_input" type="password" placeholder="Пароль" name="password" value="${password}">
			<label class="form_label"></label>
		</div>
		<div class="form_b">
			<button class="form_button">Войти</button>
		</div>
	</form>
	</body>
	</html>
