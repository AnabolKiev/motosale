<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script language="JavaScript">
    function toggle(source) {
        checkboxes = document.getElementsByName('manufacturersList');
        for(var i=0, n=checkboxes.length;i<n;i++) {
            checkboxes[i].checked = source.checked;
        }
    }
</script>

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
                        <%--<form method="POST" action="/parser/getModelPages">--%>
                            <input type="submit" value="Загрузить страницы" form="manufacturerForm"/>
                        <%--</form>--%>
                    </td>
                </tr>
            </table>
        </td>
        <td>
            <table>
                <tr>
                    <td>
                        <form method="GET" action="/parser/clearModelList" commandName="clearModelList">
                            <input type="submit" value="Очистить"/>
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="/parser/getModelsAttr" commandName="getModelsAttr">
                            <input type="submit" value="Загрузить все"/>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <c:if test="${not empty manufacturers}">
            <form:form id="manufacturerForm" action="/parser/getModelPages" method="post" modelAttribute="checkedWrapper">
            <table border=1 cellspacing=0>
            <thead style="background:lightgrey">
            <tr>
                <th>#</th>
                <th>Производитель</th>
                <th>Стр.</th>
                <th>Мод.</th>
                <th><input type="checkbox" onclick="toggle(this)"/></th>
            </tr>
            </thead>
                <c:forEach items="${manufacturers}" var="entry" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${entry.value.name}</td>
                    <td>${entry.value.pagesCount}</td>
                    <td>${entry.value.modelsCount}</td>
                    <td><input type="checkbox" name="manufacturersList" value="${entry.key}"/></td>
                </tr>
                </c:forEach>
            </table>
            </form:form>
          </c:if>
          <c:if test="${empty manufacturers}">No records found</c:if>
        </td>
        <td valign="top">
                <c:if test="${not empty models}">
                    <table border=1 cellspacing=0>
                        <thead style="background:lightgrey">
                        <tr>
                            <th>#</th>
                            <th>Модель</th>
                            <th>URL</th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${models}" var="entry" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${entry.value.modelName}</td>
                                <td>${entry.key}</td>
                                <td>
                                    <form method="GET" action="/parser/getModel">
                                        <input type="hidden" name="pageUrl" value="${entry.key}"/>
                                        <input type="submit" value="Загрузить"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                     </table>
                </c:if>
                <c:if test="${empty models}">No records found</c:if>
        </td>
    </tr>
    <tr>
        <td>Аттрибуты модели</td>
    </tr>
    <tr>
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
            <c:if test="${not empty bikeModel}">
                <table border=1 cellspacing=0>
                    <thead style="background:lightgrey">
                    <tr>
                        <th>#</th>
                        <th>Производитель</th>
                        <th>Модель</th>
                        <th>Год</th>
                        <th>Аттрибут</th>
                        <th>Значение</th>
                    </tr>
                    </thead>
                    <c:forEach items="${bikeModel}" var="entry" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${entry.manufacturer}</td>
                            <td>${entry.modelName}</td>
                            <td>${entry.modelYear}</td>
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
