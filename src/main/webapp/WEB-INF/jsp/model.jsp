<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики ${model.manufacturer.name} ${model.name} ${model.year}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="/img/favicon.ico" rel="shortcut icon">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Характеристики ${model.manufacturer.name} ${model.name} ${model.year}</h1>
    <table class="specs-table">
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Двигатель</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.engine}">
                                <li>
                                    <span class="specs-item-label">Двигатель</span>
                                    <span class="specs-item-value">${model.engine}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.engineType.name}">
                                <li>
                                    <span class="specs-item-label">Тип</span>
                                    <span class="specs-item-value">${model.engineType.name}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.displacement}">
                                <li>
                                    <span class="specs-item-label">Объем двигателя, см3</span>
                                    <span class="specs-item-value">${model.displacement}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.boreStroke}">
                                <li>
                                    <span class="specs-item-label">Диаметр и ход поршня, мм</span>
                                    <span class="specs-item-value">${model.boreStroke}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.compression}">
                                <li>
                                    <span class="specs-item-label">Компрессия</span>
                                    <span class="specs-item-value">${model.compression}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.fuelSystem}">
                                <li>
                                    <span class="specs-item-label">Топливная система</span>
                                    <span class="specs-item-value">${model.fuelSystem}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.coolingType.name}">
                                <li>
                                    <span class="specs-item-label">Охлаждение</span>
                                    <span class="specs-item-value">${model.coolingType.name}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.fuelControl}">
                                <li>
                                    <span class="specs-item-label">ГРМ</span>
                                    <span class="specs-item-value">${model.fuelControl}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.valverPerCylinder}">
                                <li>
                                    <span class="specs-item-label">Клапанов на цилиндр</span>
                                    <span class="specs-item-value">${model.valverPerCylinder}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.lubrications}">
                                <li>
                                    <span class="specs-item-label">Смазка</span>
                                    <span class="specs-item-value">${model.lubrications}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.oilCapacity}">
                                <li>
                                    <span class="specs-item-label">Объем масла, л</span>
                                    <span class="specs-item-value">${model.oilCapacity}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Производительность</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.power}">
                            <li>
                                <span class="specs-item-label">Мощность, л.с.</span>
                                <span class="specs-item-value">${model.power}</span>
                            </li>
                            </c:if>
                            <c:if test="${not empty model.torque}">
                                <li>
                                    <span class="specs-item-label">Момент, н*м</span>
                                    <span class="specs-item-value">${model.torque}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.topSpeed}">
                                <li>
                                    <span class="specs-item-label">Максимальная скороть, км/ч</span>
                                    <span class="specs-item-value">${model.topSpeed}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.maxRPM}">
                                <li>
                                    <span class="specs-item-label">Максимальные обороты, об/мин</span>
                                    <span class="specs-item-value">${model.maxRPM}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.acceleration100}">
                                <li>
                                    <span class="specs-item-label">Разгон 0-100 км/ч, с</span>
                                    <span class="specs-item-value">${model.acceleration100}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.acceleration60_140}">
                                <li>
                                    <span class="specs-item-label">Разгон 60-140 км/ч, с</span>
                                    <span class="specs-item-value">${model.acceleration60_140}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.quoterTime}">
                                <li>
                                    <span class="specs-item-label">1/4 мили, с</span>
                                    <span class="specs-item-value">${model.quoterTime}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.powerWeight}">
                                <li>
                                    <span class="specs-item-label">Мощность/вес</span>
                                    <span class="specs-item-value">${model.powerWeight}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Размеры</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.height}">
                                <li>
                                    <span class="specs-item-label">Высота, мм</span>
                                    <span class="specs-item-value">${model.height}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.length}">
                                <li>
                                    <span class="specs-item-label">Длина, мм</span>
                                    <span class="specs-item-value">${model.length}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.width}">
                                <li>
                                    <span class="specs-item-label">Ширина, мм</span>
                                    <span class="specs-item-value">${model.width}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.dryWeight}">
                                <li>
                                    <span class="specs-item-label">Сухой вес, кг</span>
                                    <span class="specs-item-value">${model.dryWeight}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.wetWeight}">
                                <li>
                                    <span class="specs-item-label">Снаряженный вес, кг</span>
                                    <span class="specs-item-value">${model.wetWeight}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.seatHeight}">
                                <li>
                                    <span class="specs-item-label">Высота по седлу, мм</span>
                                    <span class="specs-item-value">${model.seatHeight}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.altSeatHeight}">
                                <li>
                                    <span class="specs-item-label">Альтернативная высота по седлу, мм</span>
                                    <span class="specs-item-value">${model.altSeatHeight}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.seat}">
                                <li>
                                    <span class="specs-item-label">Сиденье</span>
                                    <span class="specs-item-value">${model.seat}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.wheelbase}">
                                <li>
                                    <span class="specs-item-label">Колесная база, мм</span>
                                    <span class="specs-item-value">${model.wheelbase}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.clearance}">
                                <li>
                                    <span class="specs-item-label">Клиренс, мм</span>
                                    <span class="specs-item-value">${model.clearance}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.frontWeightPerc}">
                                <li>
                                    <span class="specs-item-label">Вес на переднюю ось, %</span>
                                    <span class="specs-item-value">${model.frontWeightPerc}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.rearWeightPerc}">
                                <li>
                                    <span class="specs-item-label">Вес на заднюю ось, %</span>
                                    <span class="specs-item-value">${model.rearWeightPerc}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.rake}">
                                <li>
                                    <span class="specs-item-label">Угол наклона вилки, °</span>
                                    <span class="specs-item-value">${model.rake}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.trail}">
                                <li>
                                    <span class="specs-item-label">Трейл, мм</span>
                                    <span class="specs-item-value">${model.trail}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Тормоза</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.frontBrakes}">
                            <li>
                                <span class="specs-item-label">Передний</span>
                                <span class="specs-item-value">${model.frontBrakes}</span>
                            </li>
                            <c:if test="${not empty model.rearBrakes}">
                                    <li>
                                        <span class="specs-item-label">Задний</span>
                                        <span class="specs-item-value">${model.rearBrakes}</span>
                                    </li>
                                </c:if>
                            </c:if>
                            <c:if test="${not empty model.frontBrakesDiameter}">
                                <li>
                                    <span class="specs-item-label">Диаметр переднего диска, мм</span>
                                    <span class="specs-item-value">${model.frontBrakesDiameter}</span>
                                </li>
                            </c:if>

                            <c:if test="${not empty model.rearBrakesDiameter}">
                                <li>
                                    <span class="specs-item-label">Диаметр заднего диска, мм</span>
                                    <span class="specs-item-value">${model.rearBrakesDiameter}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Подвеска</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.frontSuspension}">
                                <li>
                                    <span class="specs-item-label">Передняя</span>
                                    <span class="specs-item-value">${model.frontSuspension}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.rearSuspension}">
                                <li>
                                    <span class="specs-item-label">Задняя</span>
                                    <span class="specs-item-value">${model.rearSuspension}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.frontTravel}">
                                <li>
                                    <span class="specs-item-label">Ход передней подвески, мм</span>
                                    <span class="specs-item-value">${model.frontTravel}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.rearTravel}">
                                <li>
                                    <span class="specs-item-label">Ход задней подвески, мм</span>
                                    <span class="specs-item-value">${model.rearTravel}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Шины</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.frontTyre}">
                                <li>
                                    <span class="specs-item-label">Передняя</span>
                                    <span class="specs-item-value">${model.frontTyre}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.rearTyre}">
                                <li>
                                    <span class="specs-item-label">Задняя</span>
                                    <span class="specs-item-value">${model.rearTyre}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.wheels}">
                                <li>
                                    <span class="specs-item-label">Колеса</span>
                                    <span class="specs-item-value">${model.wheels}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="specs-table-group">
                    <h4>Другое</h4>
                    <div class="specs-value-list">
                        <ul>
                            <c:if test="${not empty model.gearbox}">
                                <li>
                                    <span class="specs-item-label">Коробка передач</span>
                                    <span class="specs-item-value">${model.gearbox}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.finalDriveType.name}">
                                <li>
                                    <span class="specs-item-label">Тип привода</span>
                                    <span class="specs-item-value">${model.finalDriveType.name}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.frame}">
                                <li>
                                    <span class="specs-item-label">Рама</span>
                                    <span class="specs-item-value">${model.frame}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.clutch}">
                                <li>
                                    <span class="specs-item-label">Сцепление</span>
                                    <span class="specs-item-value">${model.clutch}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.ignition}">
                                <li>
                                    <span class="specs-item-label">Зажигание</span>
                                    <span class="specs-item-value">${model.ignition}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.starterType.name}">
                                <li>
                                    <span class="specs-item-label">Стартер</span>
                                    <span class="specs-item-value">${model.starterType.name}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.light}">
                                <li>
                                    <span class="specs-item-label">Фара</span>
                                    <span class="specs-item-value">${model.light}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.driveline}">
                                <li>
                                    <span class="specs-item-label">Трансмиссия</span>
                                    <span class="specs-item-value">${model.driveline}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.electrical}">
                                <li>
                                    <span class="specs-item-label">Электроника</span>
                                    <span class="specs-item-value">${model.electrical}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.emission}">
                                <li>
                                    <span class="specs-item-label">Выхлопные газы</span>
                                    <span class="specs-item-value">${model.emission}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.co2}">
                                <li>
                                    <span class="specs-item-label">СО2</span>
                                    <span class="specs-item-value">${model.co2}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.exhaust}">
                                <li>
                                    <span class="specs-item-label">Выхлоп</span>
                                    <span class="specs-item-value">${model.exhaust}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.fuelCapacity}">
                                <li>
                                    <span class="specs-item-label">Вместимость бака, л</span>
                                    <span class="specs-item-value">${model.fuelCapacity}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.reserveFuel}">
                                <li>
                                    <span class="specs-item-label">Резерв, л</span>
                                    <span class="specs-item-value">${model.reserveFuel}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.consumption}">
                                <li>
                                    <span class="specs-item-label">Потребление топлива, л/100 км</span>
                                    <span class="specs-item-value">${model.consumption}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.carrying}">
                                <li>
                                    <span class="specs-item-label">Багажник</span>
                                    <span class="specs-item-value">${model.carrying}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.instruments}">
                                <li>
                                    <span class="specs-item-label">Приборная панель</span>
                                    <span class="specs-item-value">${model.instruments}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.modifications}">
                                <li>
                                    <span class="specs-item-label">Модификации</span>
                                    <span class="specs-item-value">${model.modifications}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.price}">
                                <li>
                                    <span class="specs-item-label">Цена</span>
                                    <span class="specs-item-value">${model.price}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.colors}">
                                <li>
                                    <span class="specs-item-label">Цвета</span>
                                    <span class="specs-item-value">${model.colors}</span>
                                </li>
                            </c:if>
                            <c:if test="${not empty model.comments}">
                                <li>
                                    <span class="specs-item-label">Комментарии</span>
                                    <span class="specs-item-value">${model.comments}</span>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</body>
</html>