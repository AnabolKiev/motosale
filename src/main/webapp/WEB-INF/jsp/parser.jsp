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
<table>
    <tr>
        <td>Главные страницы производителей</td>
        <td>Страницы производителей</td>
        <td>Аттрибуты модели</td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td>
                        <form method="GET" action="/parser/getManufacturerList" commandName="getManufacturerList">
                            <input type="submit" value="Получить"/>
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="/parser/clearManufacturerList" commandName="clearManufacturerList">
                            <input type="submit" value="Очистить"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="/parser/getModelPages">
                            <input type="submit" value="Загрузить страницы"/>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
        <td>
            <form method="GET" action="/parser/clearModelList" commandName="clearModelList">
                <input type="submit" value="Очистить"/>
            </form>
        </td>
        <td>
            <table>
                <tr>
                    <td>
                        <form method="GET" action="/parser/saveModelAttr" commandName="saveModelAttr">
                            <input type="submit" value="Сохранить"/>
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="/parser/clearModelAttr" commandName="clearModelAttr">
                            <input type="submit" value="Очистить"/>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <c:if test="${not empty manufacturerList}">
            <table border=1 cellspacing=0>
            <thead style="background:lightgrey">
            <tr>
                <th>#</th>
                <th>Производитель</th>
                <th>Стр.</th>
                <th>Мод.</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <form:form id="form1" action="/parser/getModelPages" commandName="manufacturerList" method="POST">
                <c:forEach items="${manufacturerList}" var="entry" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${entry.value.name}</td>
                    <td>${entry.value.pagesCount}</td>
                    <td>${entry.value.modelsCount}</td>
                    <td>
                        <form method="GET" action="/parser/getModelPages">
                            <input type="hidden" name="manufacturerUrl" value="${entry.key}"/>
                            <input type="submit" value="Загрузить"/>
                        </form>
                    </td>
                    <td>
                        <input type="checkbox" value="isChecked"/>
                    </td>
                </tr>
                </c:forEach>
            </form:form>
            </table>
          </c:if>
          <c:if test="${empty manufacturerList}">No records found</c:if>
        </td>
        <td valign="top">
                <c:if test="${not empty modelList}">
                    <table border=1 cellspacing=0>
                        <thead style="background:lightgrey">
                        <tr>
                            <th>#</th>
                            <th>Модель</th>
                            <th>URL</th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${modelList}" var="entry" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${entry.value.modelName}</td>
                                <td>${entry.key}</td>
                                <td>
                                    <form method="GET" action="/parser/getModel">
                                        <input type="hidden" name="pageUrl" value="${entry.key}"/>
                                        <input type="submit" value="Загрузить модель"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                     </table>
                </c:if>
                <c:if test="${empty modelList}">No records found</c:if>
        </td>
        <td valign="top">
            <c:if test="${not empty bikeModel}">
                <table border=1 cellspacing=0>
                    <thead style="background:lightgrey">
                    <tr>
                        <th>#</th>
                        <th>Аттрибут</th>
                        <th>Значение</th>
                    </tr>
                    </thead>
                    <c:forEach items="${bikeModel}" var="entry" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${entry.attrName}</td>
                            <td>${entry.attrValue}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty bikeModel}">No records found</c:if>
        </td>
    </tr>
</table>
</body>
</html>
