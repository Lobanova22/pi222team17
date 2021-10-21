<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат вычислений</title>
</head>
<body>
<body bgcolor="#FFEBCD">
<h1>Результат вычислений</h1>
<p><strong> Первая сторона:</strong> ${first_result}</p>
<p><strong> Вторая сторона:</strong> ${second_result}</p>
<p><strong>Периметр параллелограмма:</strong> ${perimetr}</p>
<form action="${pageContext.request.contextPath}/Form.jsp"> <input type="submit" name="sign" value="Назад"></form>
</body>
</html>
