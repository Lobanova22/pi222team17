<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор - периметр параллелограмма</title>
</head>
	<body>
        <body bgcolor="#00FFFF">
	<h1>Калькулятор - периметр параллелограмма</h1>
	<form action="${pageContext.request.contextPath }/JavaCalc" method="post">
	<label for="first"> Первая сторона: </label>
	<input type="text" name="first" id="first" value="${first}"
	pattern="[0-9]+([.,][0-9]+)"/> <br>
	
	<label for="second"> Вторая сторона:</label>
	<input type="text" name="second" id="second" value="${second}"
	pattern="[0-9]+([.,][0-9]+)"/> <br>
	
		<input type="submit" name="sign" value="Calculate"> 
	</form>
	</body>
</html>
