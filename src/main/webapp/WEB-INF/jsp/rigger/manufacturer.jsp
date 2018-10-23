<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики ${manufacturer}</title>
    <script>var manufacturerId = ${manufacturerId};
            var manufacturer = '${manufacturer}';
    </script>
    //= templates/head.jsp
</head>
<body>
    <div class="wrapper">
        //= templates/header.jsp
        <div class="content">
            <table>
                <tr>
                    <td>
                        //= templates/search.jsp
                        <br>
                        //= templates/manufacturersList.jsp
                    </td>
                    <td id="searchResult">
                        <h1 class="title">Мотокаталог моделей ${manufacturer}</h1>
                        <div id="searchResultAfterTitle"></div>
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
                    </td>
                </tr>
            </table>
        </div>
        //= templates/footer.jsp
    </div>
</body>
</html>