<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Калькулятор</title>
</head>
<body>
		<div class="container">
			<header class="header">
				<div class="contain">
					<div class="header_body">
						<nav class="header-menu">
						    <span>Навигационное меню</span>
							<ul class="header-list">
								<li><a href="login.jsp" class="header_link">Администрирование</a></li>
								<li><a href="about.jsp" class="header_link">О нас</a></li>
								<li><a href="welcome.jsp" class="header_link">Назад</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>

		    <div class="title"><h1>Налоговой калькулятор</h1></div>

		    <form action="${pageContext.request.contextPath}/index" method="post">
			    <div class="user-details">
				    <div class="input-box">
					    <span class="details">Фамилия</span>
					    <input type="text" placeholder="Ваша фамилия" required name="surname" id="surname" value="${surname}">
				    </div>
				    <div class="input-box">
					    <span class="details">Имя</span>
					    <input type="text" placeholder="Имя" required name="name" id="name" value="${name}">
				    </div>
				    <div class="input-box">
					    <span class="details">Отчество</span>
					    <input type="text" placeholder="Отчество" required name="patronymic" id="patronymic" value="${patronymic}">
				    </div>
				    <div class="input-box">
					    <span class="details">Период (полных месяцев)</span>
					    <input type="number" placeholder="Период" required name="period" id="period" value="${period}">
				    </div>
				    <div class="input-box">
					    <span class="details">Мощность (в л.с.)</span>
					    <input type="number" required placeholder="Мощность" name="power" id="power" value="${power}">
				    </div>
				    <div class="input-box">
                        <span class="details">Льготы</span>
                    	<select size="1" required name="privileges" id="privileges" value="${privileges}" style="width: 250;">
                            <option>Нет льгот</option>
                            <option>
                                Инвалиды всех категорий, ветераны Великой Отечественной войны, ветераны боевых действий на территории СССР, на территории Российский Федерации и территориях других государств, ветераны военной службы, ветераны труда, категории граждан, подвергшихся воздействию радиации вследствие чернобыльской катастрофы
							</option>
                            <option>Герои Советского Союза, Герои Российской Федерации, герои Социалистического Труда, полные кавалеры ордена Славы, полные кавалеры ордена Трудовой Славы</option>
                            <option>Один из родителей (усыновитель) либо опекун (попечитель) в семье, которая признается многодетной</option>
                        </select>
                    </div>
                    <div class="input-box">
                        <span class="details">Налог на роскошь</span>
                        <select size="1" required name="luxury" id="luxury" value="${luxury}">
                            <option>Без налога на роскошь</option>
                            <option>Автомобиль стоит от 3 до 5млн. руб., возраст не более 3 лет</option>
                            <option>Автомобиль стоит от 5 до 10 млн. руб., возраст не более 5 лет</option>
                            <option>Автомобиль стоит от 10 до 15 млн. руб., возраст не более 10 лет</option>
                            <option>Автомобиль стоит от 15 млн. Руб., возраст не более 20 лет</option>
                        </select>
                    </div>
			    </div>
				${error}
    			<div class="price">
        			<div class="button">
		    		    <input type="submit" value="Рассчитать">
			        </div>
		    </form>
</body>
</html>