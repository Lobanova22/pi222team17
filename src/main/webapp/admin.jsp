<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Администрирование</title>
	</head>
	<body>
		<form class="form" action="${pageContext.request.contextPath}/admin" method="post">
			<div class="input-box">
				<span class="details">Лошадиные силы</span>
				<select size="1" required name="power" id="power" value="${privileges}" style="width: 250;">
					<option>Меньше 100</option>
					<option>Между 100 и 150</option>
					<option>Между 150 и 200</option>
					<option>Между 200 и 250</option>
					<option>Больше 250</option>
				</select>
			</div>
			<input type="number" placeholder="Введите коэффициент"  name="powerNumber">

			<div class="form_b">
				<button class="form_button">Войти</button>
			</div>
		</form>
	</body>
</html>
