<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики ${manufacturer}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="/img/favicon.ico" rel="shortcut icon">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Мотокаталог моделей ${manufacturer}</h1>
    <table class="model-table">
        <th>Модель</th>
        <th>Год выпуска</th>
        <c:forEach items="${modelMap}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <ul>
                        <c:forEach items="${entry.value}" var="year">
                            <li><a href="/${manufacturer}/${entry.key}/${year}">${year}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>