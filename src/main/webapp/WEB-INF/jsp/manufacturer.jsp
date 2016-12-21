<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики</title>
</head>
<body>
<h3>Мотокаталог моделей ${manufacturer}</h3>
<table>
    <c:forEach items="${modelMap}" var="entry">
        <tr>
            <td>${entry.key}</td>
            <c:forEach items="${entry.value}" var="year">
                <td><a href="${manufacturer}/${entry.key}/${year}">${year}</a></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>