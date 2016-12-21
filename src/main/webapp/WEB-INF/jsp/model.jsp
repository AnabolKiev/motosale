<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики</title>
</head>
<body>
<h3>Характеристики ${model.manufacturer.name} ${model.name} ${model.year}</h3>
<table>
    <tr>
        <td>Модель</td>
        <td>${model.manufacturer.name} ${model.name}</td>
    </tr>
    <tr>
        <td>Год выпуска</td>
        <td>${model.year}</td>
    </tr>
    <c:if test="${not empty model.category.name}">
        <tr>
            <td>Тип</td>
            <td>${model.category.name}</td>
        </tr>
    </c:if>
    <c:if test="${not empty model.displacement}">
        <tr>
        <td>Объем двигателя, см3</td>
        <td>${model.displacement}</td>
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
    <c:if test="${not empty model.boreStroke}">
        <tr>
            <td>Диаметр и ход поршня, мм</td>
            <td>${model.boreStroke}</td>
        </tr>
    </c:if>
    <c:if test="${not empty model.altSeatHeight}">
        <tr>
            <td>Альтернативная высота по седлу, мм</td>
            <td>${model.altSeatHeight}</td>
        </tr>
    </c:if>

</table>
</body>
</html>