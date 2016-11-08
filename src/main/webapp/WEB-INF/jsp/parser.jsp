<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Test parser</title>
</head>
<body>
<h3>Производители и модели</h3>
<br>
<form:form method="GET" action="/parser/getManufacturerList" commandName="getManufacturerList">
    <input type="submit" value="Получить список производителей"/>
</form:form>
<table>
    <tr>
        <td>Главные страницы производителей</td>
        <td>Страницы производителей</td>
    </tr>
    <tr>
        <td valign="top">
            <c:if test="${not empty manufacturerList}">
            <table border=1 cellspacing=0>
            <thead style="background:lightgrey">
            <tr>
                <th></th>
                <th>Производитель</th>
                <th>URL</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${manufacturerList}" var="entry" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                    <td>
                        <form:form method="GET" action="/parser/getModelPages">
                            <input type="hidden" name="manufacturer" value="${entry.key}"/>
                            <input type="submit" value="Загрузить страницы"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </table>
          </c:if>
          <c:if test="${empty manufacturerList}">No records found</c:if>
        </td>
        <td valign="top">
            <table>
                <c:if test="${not empty modelList}">
                    <table border=1 cellspacing=0>
                        <thead style="background:lightgrey">
                        <tr>
                            <th></th>
                            <th>Модель</th>
                            <th>URL</th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${modelList}" var="entry" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${entry.key}</td>
                                <td>${entry.value}</td>
                                <td>
                                    <form:form method="GET" action="/parser/getModel">
                                        <input type="hidden" name="pageUrl" value="${entry.key}"/>
                                        <input type="submit" value="Загрузить модель"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${empty modelList}">No records found</c:if>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
