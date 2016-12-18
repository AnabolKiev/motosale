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
    <c:forEach items="${models}" var="entry">
        <tr>
            <td><a href="<c:url value="/${manufacturer}/${entry.name}"/>">${entry.name}</a></td>
            <td>${entry.manufacturer.name}</td>
            <td>${entry.year}</td>
            <td>${entry.displacement}</td>
            <td>${entry.categoryId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>