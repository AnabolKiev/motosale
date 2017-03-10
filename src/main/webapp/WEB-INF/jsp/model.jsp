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
    <div class="specs-table">
        <h4>Двигатель</h4>
        <div class="specs-value-list">
            <ul>
            <c:if test="${not empty model.engine}">
                <li>
                    <span class="specs-item-label">engine</span>
                    <span class="specs-item-value">${model.engine}</span>
                </li>
            </c:if>
            <c:if test="${not empty model.engineType.name}">
                <li>
                    <span class="specs-item-label">engineType</span>
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
                    <span class="specs-item-label">compression</span>
                    <span class="specs-item-value">${model.compression}</span>
                </li>
            </c:if>
            <c:if test="${not empty model.valverPerCylinder}">
                <li>
                    <span class="specs-item-label">valverPerCylinder</span>
                    <span class="specs-item-value">${model.valverPerCylinder}</span>
                </li>
            </c:if>
            </ul>
        </div>
    </div>

    <div class="specs-table"></div>
    <table>
        <c:if test="${not empty model.coolingType.name}">
            <tr>
                <td>coolingType</td>
                <td>${model.coolingType.name}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.lubrications}">
            <tr>
                <td>lubrications</td>
                <td>${model.lubrications}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.oilCapacity}">
            <tr>
                <td>oilCapacity</td>
                <td>${model.oilCapacity}</td>
            </tr>
        </c:if>



        <%-- POWER SPECS --%>
        <c:if test="${not empty model.power}">
            <tr>
                <td>power</td>
                <td>${model.power}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.torque}">
            <tr>
                <td>torque</td>
                <td>${model.torque}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.topSpeed}">
            <tr>
                <td>topSpeed</td>
                <td>${model.topSpeed}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.maxRPM}">
            <tr>
                <td>maxRPM</td>
                <td>${model.maxRPM}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.acceleration100}">
            <tr>
                <td>Разгон 0-100 км/ч, с</td>
                <td>${model.acceleration100}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.acceleration60_140}">
            <tr>
                <td>Разгон 60-140 км/ч, с</td>
                <td>${model.acceleration60_140}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.quoterTime}">
            <tr>
                <td>quoterTime, с</td>
                <td>${model.quoterTime}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.powerWeight}">
            <tr>
                <td>powerWeight</td>
                <td>${model.powerWeight}</td>
            </tr>
        </c:if>


        <%-- SIZE SPECS --%>
        <c:if test="${not empty model.height}">
            <tr>
                <td>Высота, мм</td>
                <td>${model.height}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.length}">
            <tr>
                <td>length, мм</td>
                <td>${model.length}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.width}">
            <tr>
                <td>width, мм</td>
                <td>${model.width}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.dryWeight}">
            <tr>
                <td>dryWeight</td>
                <td>${model.dryWeight}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.wetWeight}">
            <tr>
                <td>wetWeight</td>
                <td>${model.wetWeight}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.seatHeight}">
            <tr>
                <td>Высота по седлу, мм</td>
                <td>${model.seatHeight}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.altSeatHeight}">
            <tr>
                <td>Альтернативная высота по седлу, мм</td>
                <td>${model.altSeatHeight}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.seat}">
            <tr>
                <td>Seat</td>
                <td>${model.seat}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.wheelbase}">
            <tr>
                <td>wheelbase, мм</td>
                <td>${model.wheelbase}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.clearance}">
            <tr>
                <td>clearance, мм</td>
                <td>${model.clearance}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.frontWeightPerc}">
            <tr>
                <td>frontWeightPerc</td>
                <td>${model.frontWeightPerc}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.rearWeightPerc}">
            <tr>
                <td>rearWeightPerc</td>
                <td>${model.rearWeightPerc}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.rake}">
            <tr>
                <td>rake</td>
                <td>${model.rake}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.trail}">
            <tr>
                <td>trail</td>
                <td>${model.trail}</td>
            </tr>
        </c:if>

        <%-- BRAKES --%>
            <c:if test="${not empty model.frontBrakesDiameter}">
                <tr>
                    <td>frontBrakesDiameter</td>
                    <td>${model.frontBrakesDiameter}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.frontBrakes}">
                <tr>
                    <td>frontBrakes</td>
                    <td>${model.frontBrakes}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.rearBrakesDiameter}">
                <tr>
                    <td>rearBrakesDiameter</td>
                    <td>${model.rearBrakesDiameter}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.rearBrakes}">
                <tr>
                    <td>rearBrakes</td>
                    <td>${model.rearBrakes}</td>
                </tr>
            </c:if>

        <%-- SUSPENSION --%>
            <c:if test="${not empty model.frontSuspension}">
                <tr>
                    <td>frontSuspension</td>
                    <td>${model.frontSuspension}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.rearSuspension}">
                <tr>
                    <td>rearSuspension</td>
                    <td>${model.rearSuspension}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.frontTravel}">
                <tr>
                    <td>frontTravel</td>
                    <td>${model.frontTravel}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.rearTravel}">
                <tr>
                    <td>rearTravel</td>
                    <td>${model.rearTravel}</td>
                </tr>
            </c:if>

        <%-- TYRES --%>
            <c:if test="${not empty model.frontTyre}">
                <tr>
                    <td>frontTyre</td>
                    <td>${model.frontTyre}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.rearTyre}">
                <tr>
                    <td>rearTyre</td>
                    <td>${model.rearTyre}</td>
                </tr>
            </c:if>
            <c:if test="${not empty model.wheels}">
                <tr>
                    <td>wheels</td>
                    <td>${model.wheels}</td>
                </tr>
            </c:if>

        <%-- OTHER --%>
        <c:if test="${not empty model.gearbox}">
            <tr>
                <td>gearbox</td>
                <td>${model.gearbox}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.finalDriveType.name}">
            <tr>
                <td>finalDriveType</td>
                <td>${model.finalDriveType.name}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.frame}">
            <tr>
                <td>frame</td>
                <td>${model.frame}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.clutch}">
            <tr>
                <td>clutch</td>
                <td>${model.clutch}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.ignition}">
            <tr>
                <td>ignition</td>
                <td>${model.ignition}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.starterType.name}">
            <tr>
                <td>starterType</td>
                <td>${model.starterType.name}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.light}">
            <tr>
                <td>light</td>
                <td>${model.light}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.driveline}">
            <tr>
                <td>driveline</td>
                <td>${model.driveline}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.electrical}">
            <tr>
                <td>electrical</td>
                <td>${model.electrical}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.emission}">
            <tr>
                <td>emission</td>
                <td>${model.emission}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.co2}">
            <tr>
                <td>co2</td>
                <td>${model.co2}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.exhaust}">
            <tr>
                <td>exhaust</td>
                <td>${model.exhaust}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.fuelControl}">
            <tr>
                <td>fuelControl</td>
                <td>${model.fuelControl}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.fuelSystem}">
            <tr>
                <td>fuelSystem</td>
                <td>${model.fuelSystem}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.fuelCapacity}">
            <tr>
                <td>fuelCapacity</td>
                <td>${model.fuelCapacity}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.reserveFuel}">
            <tr>
                <td>reserveFuel</td>
                <td>${model.reserveFuel}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.consumption}">
            <tr>
                <td>consumption</td>
                <td>${model.consumption}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.carrying}">
            <tr>
                <td>carrying</td>
                <td>${model.carrying}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.instruments}">
            <tr>
                <td>instruments</td>
                <td>${model.instruments}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.modifications}">
            <tr>
                <td>modifications</td>
                <td>${model.modifications}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.price}">
            <tr>
                <td>price</td>
                <td>${model.price}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.colors}">
            <tr>
                <td>colors</td>
                <td>${model.colors}</td>
            </tr>
        </c:if>
        <c:if test="${not empty model.comments}">
            <tr>
                <td>comments</td>
                <td>${model.comments}</td>
            </tr>
        </c:if>


    </table>
</body>
</html>