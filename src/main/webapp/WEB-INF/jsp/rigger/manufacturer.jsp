<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики ${manufacturer}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>var manufacturerId = ${manufacturerId};
            var manufacturer = '${manufacturer}';
    </script>
    <script src="//unpkg.com/react@16.5.2/umd/react.production.min.js"></script>
    <script src="//unpkg.com/react-dom@16.5.2/umd/react-dom.production.min.js"></script>
    <script src="/resources/js/scriptManufacturer.js"></script>
    <link href="/resources/img/favicon.ico" rel="shortcut icon">
    <link href="/resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper">
        //= templates/header.jsp
        <div class="content">
            <h1 class="title">Мотокаталог моделей ${manufacturer}</h1>
            <div id="searchResult"></div>
            <%--
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
            --%>
        </div>
        //= templates/footer.jsp
    </div>
</body>
</html>