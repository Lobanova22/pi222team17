<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Заказ</title>
	</head>
	<body>
        <div class="container">
        		<div class="title">Налог рассчитан!</div>
        		<form action="${pageContext.request.contextPath}/result" method="post">
        			<div class="order-numb">
                </div>
                <div class="user-details">
                <p>
                    ФИО: ${surname} ${name} ${patronymic} <br>
                    Период: ${period} мес.<br>
                    Мощность: ${power} л.с.<br>
                    ${privileges} <br>
                    ${luxury} <br>
                </p>
        			</div>
        			<div class="result">
        				 <p>
                    Ваш налог: ${result} руб.
                		</p>
          			</div>
          			<input type="submit" value="Вернуться назад">
        		</form>
        		<div class="button">
        		    <a href="/WebApp/Check.pdf">Открыть PDF</a>
        		</div>
                <div class="button">
        		    <a href="/WebApp/Check.pdf" download>Скачать PDF</a>
        		</div>
        	</div>

	</body>
	</html>

