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
<h3>Производители</h3>
<a href="<c:url value="/"/>">Главная</a> |
<a href="/admin/">Панель администратора</a>
<br>
<table>
    <tr>
        <td>Производители</td>
        <td>Модели</td>
        <td>Характеристики</td>
    </tr>
    <tr valign="top">
        <td>
        <c:if test="${not empty manufacturers}">
            <table id="manufacturerTable" border=1 cellspacing=0>
                <thead style="background:lightgrey">
                <tr>
                    <th>ID</th>
                    <th>Производитель</th>
                </tr>
                </thead>
                <c:forEach items="${manufacturers}" var="entry">
                    <tr>
                        <td>${entry.id}</td>
                        <td><a href="/admin/${entry.id}" onclick="showModels(${entry.id})">${entry.name}</a></td>
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
                <tbody>
                </tbody>
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
                        <td><input name="manufacturer.name"/></td>
                    </tr>

                    <tr>
                        <td>Имя модели</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Год выпуска</td>
                        <td><input type="number" name="year"/></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>

