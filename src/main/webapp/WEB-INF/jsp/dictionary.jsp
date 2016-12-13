<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Справочники</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/ajax.js" type="text/javascript"></script>
</head>
<body>
<h3>Справочники</h3>
<a href="<c:url value="/"/>">Главная</a> |
<a href="/admin/">Панель администратора</a>
<br>
<table>
    <tr valign="top">
        <td>
            <h3>Типы мотоциклов</h3>
            <c:if test="${not empty categories}">
                <form:form id="categoriesForm">
                    <table id="categoriesTable" border=1 cellspacing=0>
                        <thead style="background:lightgrey">
                        <tr>
                            <th>ID</th>
                            <th>Тип</th>
                            <th>English</th>
                        </tr>
                        </thead>
                        <c:forEach items="${categories}" var="entry">
                        <tr>
                            <td>${entry.id}</td>
                            <td><input name="${entry.id}" value="${entry.name}"/></td>
                            <td>${entry.nameEng}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <input id="saveCategories" type="button" value="Сохранить" onclick="submitCategories()"/>
                </form:form>
            </c:if>
            <c:if test="${empty categories}">No records found</c:if>
        </td>
        <td>
        <h3>Типы двигателей</h3>
            <div id="test"></div>
        <c:if test="${not empty engineTypes}">
            <form:form id="engineTypeForm">
                <table id="engineTypeTable" border=1 cellspacing=0>
                    <thead style="background:lightgrey">
                    <tr>
                        <th>ID</th>
                        <th>Тип</th>
                        <th>English</th>
                    </tr>
                    </thead>
                    <c:forEach items="${engineTypes}" var="entry">
                        <tr>
                            <td>${entry.id}</td>
                            <td><input name="${entry.id}" value="${entry.name}"/></td>
                            <td>${entry.nameEng}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <input id="saveEngineTypes" type="button" value="Сохранить" onclick="submitEngineTypes()"/>
            </form:form>
        </c:if>
        <c:if test="${empty engineTypes}">No records found</c:if>
        </td>
    </tr>
</table>
</body>
</html>
