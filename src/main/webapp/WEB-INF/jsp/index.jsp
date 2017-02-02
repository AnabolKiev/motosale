<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
<%--<script src="https://unpkg.com/react@latest/dist/react.min.js"></script>
    <script src="https://unpkg.com/react-dom@latest/dist/react-dom.min.js"></script>
    <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script> --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/script.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <table>
        <tr>
            <td>
                Поиск по параметрам
                <div id="search">
                    <form id="searchForm">
                        <select id="categorySelect" name="categoryId" required>
                          <option value="">--- Select ---</option>
                            <c:forEach items="${categories}" var="entry">
                                <option value="${entry.id}">${entry.name}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <input id="searchModels" type="submit" value="Поиск"/>
                    </form>
                </div>
                <br>
                <h3>Производители</h3>
                <table>
                <c:forEach items="${manufacturers}" var="entry">
                    <tr>
                        <td><a href="<c:url value="/${entry.name}"/>">${entry.name}</a></td>
                    </tr>
                </c:forEach>
                </table>
            </td>
            <td>
                <div id="test"></div>
            </td>
        </tr>
    </table>
</body>
</html>