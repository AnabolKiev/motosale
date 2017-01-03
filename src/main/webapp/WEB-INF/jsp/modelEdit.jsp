<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Производители и модели</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/ajax.js" type="text/javascript"></script>
</head>
<body>
<h3>Модели</h3>
<a href="<c:url value="/"/>">Главная</a> |
<a href="/admin/">Панель администратора</a>
<br>
<table>
    <tr>
        <td><b>Производители</b></td>
        <td><b>Модели</b></td>
        <td><b>Характеристики</b></td>
    </tr>
    <tr valign="top">
        <td>
        <c:if test="${not empty manufacturers}">
            <table id="manufacturerTable2" border=1 cellspacing=0>
                <thead style="background:lightgrey">
                <tr>
                    <th>ID</th>
                    <th>Производитель</th>
                </tr>
                </thead>
                <c:forEach items="${manufacturers}" var="entry">
                    <tr>
                        <td>${entry.id}</td>
                        <td><a href="/admin/${entry.id}" value=${entry.id}>${entry.name}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty manufacturers}">No records found</c:if>
        </td>
        <td>
            <table id="modelsTable" border=1 cellspacing=0>
                <thead style="background:lightgrey">
                <tr>
                    <th>ID</th>
                    <th>Модель</th>
                    <th>Год</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </td>
        <td>
            <form id="modelAttrForm">
                <table id="modelAttrTable">
                    <tr>
                        <td>ID модели</td>
                        <td><input name="id" readonly/></td>
                    </tr>
                    <tr>
                        <td>Производитель</td>
                        <td>
                            <select id="manufacturerSelect" name="manufacturerId" required>
                                <option value="">--- Select ---</option>
                                <c:forEach items="${manufacturers}" var="entry">
                                <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Имя модели</td>
                        <td><input type="text" name="name" required/></td>
                    </tr>
                    <tr>
                        <td>Год выпуска</td>
                        <td><input type="number" name="year" required/></td>
                    </tr>
                    <tr>
                        <td>Тип</td>
                        <td>
                            <select id="categorySelect" name="categoryId" required>
                                <option value="">--- Select ---</option>
                                <c:forEach items="${categories}" var="entry">
                                    <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Двигатель</td>
                        <td><input type="text" name="engine"/></td>
                    </tr>
                    <tr>
                        <td>Двигатель (english)</td>
                        <td><input type="text" name="engineEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Тип двигателя</td>
                        <td>
                            <select id="engineTypeSelect" name="engineTypeId">
                                <option value="">--- Select ---</option>
                                <c:forEach items="${engineTypes}" var="entry">
                                    <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Объем, см3</td>
                        <td><input type="text" name="displacement" required/></td>
                    </tr>
                    <tr>
                        <td>Мощность, л.с.</td>
                        <td><input type="text" name="power"/></td>
                    </tr>
                    <tr>
                        <td>Момент, н*м</td>
                        <td><input type="text" name="torque"/></td>
                    </tr>
                    <tr>
                        <td>Максимальные обороты</td>
                        <td><input type="text" name="maxRPM"/></td>
                    </tr>
                    <tr>
                        <td>Диаметр и ход поршня, мм</td>
                        <td><input type="text" name="boreStroke"/></td>
                    </tr>
                    <tr>
                        <td>Степень сжатия</td>
                        <td><input type="text" name="compression"/></td>
                    </tr>
                    <tr>
                        <td>Клапанов на цилиндр</td>
                        <td><input type="text" name="valverPerCylinder"/></td>
                    </tr>
                    <tr>
                        <td>Объем масла</td>
                        <td><input type="text" name="oilCapacity"/></td>
                    </tr>
                    <tr>
                        <td>Топливная система</td>
                        <td><input type="text" name="fuelSystem"/></td>
                    </tr>
                    <tr>
                        <td>Топливная система (english)</td>
                        <td><input type="text" name="fuelSystemEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Топливная</td>
                        <td><input type="text" name="fuelControl"/></td>
                    </tr>
                    <tr>
                        <td>Топливная (english)</td>
                        <td><input type="text" name="fuelControlEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Зажигание</td>
                        <td><input type="text" name="ignition"/></td>
                    </tr>
                    <tr>
                        <td>Зажигание (english)</td>
                        <td><input type="text" name="ignitionEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Охлаждение</td>
                        <td>
                            <select id="coolingTypeSelect" name="coolingTypeId">
                                <option value="">--- Select ---</option>
                                <c:forEach items="${coolingTypes}" var="entry">
                                    <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Смазка</td>
                        <td><input type="text" name="lubrications"/></td>
                    </tr>
                    <tr>
                        <td>Смазка (english)</td>
                        <td><input type="text" name="lubricationsEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Коробка передач</td>
                        <td><input type="text" name="gearbox"/></td>
                    </tr>
                    <tr>
                        <td>Коробка передач (english)</td>
                        <td><input type="text" name="gearboxEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Привод</td>
                        <td>
                            <select id="finalDriveTypeSelect" name="finalDriveTypeId">
                                <option value="">--- Select ---</option>
                                <c:forEach items="${finalDriveTypes}" var="entry">
                                    <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Сцепление</td>
                        <td><input type="text" name="clutch"/></td>
                    </tr>
                    <tr>
                        <td>Сцепление (english)</td>
                        <td><input type="text" name="clutchEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Рама</td>
                        <td><input type="text" name="frame"/></td>
                    </tr>
                    <tr>
                        <td>Рама (english)</td>
                        <td><input type="text" name="frameEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Высота, мм</td>
                        <td><input type="text" name="height"/></td>
                    </tr>
                    <tr>
                        <td>Длина, мм</td>
                        <td><input type="text" name="length"/></td>
                    </tr>
                    <tr>
                        <td>Ширина, мм</td>
                        <td><input type="text" name="width"/></td>
                    </tr>
                    <tr>
                        <td>Сухой вес, кг</td>
                        <td><input type="text" name="dryWeight"/></td>
                    </tr>
                    <tr>
                        <td>Снаряженный вес, кг</td>
                        <td><input type="text" name="wetWeight"/></td>
                    </tr>
                    <tr>
                        <td>Колесная база, мм</td>
                        <td><input type="text" name="wheelbase"/></td>
                    </tr>
                    <tr>
                        <td>Клиренс, мм</td>
                        <td><input type="text" name="clearance"/></td>
                    </tr>
                    <tr>
                        <td>Багаж</td>
                        <td><input type="text" name="carrying"/></td>
                    </tr>
                    <tr>
                        <td>Багаж (english)</td>
                        <td><input type="text" name="carryingEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Высота по седлу, мм</td>
                        <td><input type="text" name="seatHeight"/></td>
                    </tr>
                    <tr>
                        <td>Альтернативная высота по седлу, мм</td>
                        <td><input type="text" name="altSeatHeight"/></td>
                    </tr>
                    <tr>
                        <td>Сиденье</td>
                        <td><input type="text" name="seat"/></td>
                    </tr>
                    <tr>
                        <td>Сиденье (english)</td>
                        <td><input type="text" name="seatEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Угол наклона вилки, °</td>
                        <td><input type="text" name="rake"/></td>
                    </tr>
                    <tr>
                        <td>Трейл</td>
                        <td><input type="text" name="trail"/></td>
                    </tr>
                    <tr>
                        <td>Соотноешние мощности к весу</td>
                        <td><input type="text" name="powerWeight"/></td>
                    </tr>
                    <tr>
                        <td>Вместимость бака, л</td>
                        <td><input type="text" name="fuelCapacity"/></td>
                    </tr>
                    <tr>
                        <td>Потребление топлива</td>
                        <td><input type="text" name="consumption"/></td>
                    </tr>
                    <tr>
                        <td>Максимальная скорость, км/ч</td>
                        <td><input type="text" name="topSpeed"/></td>
                    </tr>
                    <tr>
                        <td>Разгон 0-100 км/ч, с</td>
                        <td><input type="text" name="acceleration100"/></td>
                    </tr>
                    <tr>
                        <td>Разгон 60-140 км/ч, с</td>
                        <td><input type="text" name="acceleration60_140"/></td>
                    </tr>
                    <tr>
                        <td>1/4 мили, с</td>
                        <td><input type="text" name="quoterTime"/></td>
                    </tr>
                    <tr>
                        <td>Стартер</td>
                        <td>
                            <select id="starterTypeSelect" name="starterTypeId">
                                <option value="">--- Select ---</option>
                                <c:forEach items="${starterTypes}" var="entry">
                                    <option value="${entry.id}">${entry.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Свет</td>
                        <td><input type="text" name="light"/></td>
                    </tr>
                    <tr>
                        <td>Свет (english)</td>
                        <td><input type="text" name="lightEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Эмиссия</td>
                        <td><input type="text" name="emission"/></td>
                    </tr>
                    <tr>
                        <td>Эмиссия (english)</td>
                        <td><input type="text" name="emissionEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Выхлоп</td>
                        <td><input type="text" name="exhaust"/></td>
                    </tr>
                    <tr>
                        <td>Выхлоп (english)</td>
                        <td><input type="text" name="exhaustEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>CO2</td>
                        <td><input type="text" name="co2"/></td>
                    </tr>
                    <tr>
                        <td>Диаметр передних тормозов, мм</td>
                        <td><input type="text" name="frontBrakesDiameter"/></td>
                    </tr>
                    <tr>
                        <td>Передний тормоз</td>
                        <td><input type="text" name="frontBrakes"/></td>
                    </tr>
                    <tr>
                        <td>Передний тормоз (english)</td>
                        <td><input type="text" name="frontBrakesEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Диаметр задних тормозов, мм</td>
                        <td><input type="text" name="rearBrakesDiameter"/></td>
                    </tr>
                    <tr>
                        <td>Задний тормоз</td>
                        <td><input type="text" name="rearBrakes"/></td>
                    </tr>
                    <tr>
                        <td>Задний тормоз (english)</td>
                        <td><input type="text" name="rearBrakesEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Развесовка перед, %</td>
                        <td><input type="text" name="frontWeightPerc"/></td>
                    </tr>
                    <tr>
                        <td>Передняя подвеска</td>
                        <td><input type="text" name="frontSuspension"/></td>
                    </tr>
                    <tr>
                        <td>Передняя подвеска (english)</td>
                        <td><input type="text" name="frontSuspensionEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Ход передней подвески, мм</td>
                        <td><input type="text" name="frontTravel"/></td>
                    </tr>
                    <tr>
                        <td>Развесовка зад, %</td>
                        <td><input type="text" name="rearWeightPerc"/></td>
                    </tr>
                    <tr>
                        <td>Задняя подвеска</td>
                        <td><input type="text" name="rearSuspension"/></td>
                    </tr>
                    <tr>
                        <td>Задняя подвеска (english)</td>
                        <td><input type="text" name="rearSuspensionEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Ход задней подвески, мм</td>
                        <td><input type="text" name="rearTravel"/></td>
                    </tr>
                    <tr>
                        <td>Переднее колесо</td>
                        <td><input type="text" name="frontTyre"/></td>
                    </tr>
                    <tr>
                        <td>Переднее колесо (english)</td>
                        <td><input type="text" name="frontTyreEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Заднее колесо</td>
                        <td><input type="text" name="rearTyre"/></td>
                    </tr>
                    <tr>
                        <td>Заднее колесо (english)</td>
                        <td><input type="text" name="rearTyreEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Колеса</td>
                        <td><input type="text" name="wheels"/></td>
                    </tr>
                    <tr>
                        <td>Колеса (english)</td>
                        <td><input type="text" name="wheelsEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Driveline</td>
                        <td><input type="text" name="driveline"/></td>
                    </tr>
                    <tr>
                        <td>Driveline (english)</td>
                        <td><input type="text" name="drivelineEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Электро</td>
                        <td><input type="text" name="electrical"/></td>
                    </tr>
                    <tr>
                        <td>Электро (english)</td>
                        <td><input type="text" name="electricalEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Приборная панель</td>
                        <td><input type="text" name="instruments"/></td>
                    </tr>
                    <tr>
                        <td>Приборная панель (english)</td>
                        <td><input type="text" name="instrumentsEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Модификации</td>
                        <td><input type="text" name="modifications"/></td>
                    </tr>
                    <tr>
                        <td>Модификации (english)</td>
                        <td><input type="text" name="modificationsEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Цена</td>
                        <td><input type="text" name="price"/></td>
                    </tr>
                    <tr>
                        <td>Цвета</td>
                        <td><input type="text" name="colors"/></td>
                    </tr>
                    <tr>
                        <td>Цвета (english)</td>
                        <td><input type="text" name="colorsEng" readonly/></td>
                    </tr>
                    <tr>
                        <td>Комментарии</td>
                        <td><input type="text" name="comments"/></td>
                    </tr>
                    <tr>
                        <td>Комментарии (english)</td>
                        <td><input type="text" name="commentsEng" readonly/></td>
                    </tr>
                </table>
                <br>
                <input id="saveModelAttr" type="submit" value="Сохранить"/>
                <input id="clearModelAttr" type="reset" value="Очистить"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>

