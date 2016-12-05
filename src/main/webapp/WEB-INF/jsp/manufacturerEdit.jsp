<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Производители и модели</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>

<script language="JavaScript">
    $(document).ready(function(){
        $('#cbtest').click(function() {
            $.ajax( {
                type: 'POST',
                url: '/ajax/manufacturer/',
                data: { checkedManufacturers : $('input:checkbox:checked').val()},
                success: function(data) {
                 $('#ajaxResponse').html(data);
                }
            });
        })
    });
</script>

<body>
<a href="<c:url value="/"/>">Объявления</a>
<h3>Производители и модели</h3>
<form:form method="POST" action="/manufacturer/" commandName="manufacturer">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Производитель</td>
            <td><form:input path="name"/></td>
            <td colspan="2"><input type="submit" value="Сохранить"/></td>
        </tr>
    </table>
</form:form>
<br>
<strong>Ajax Response</strong>:
<div id="ajaxResponse"></div>
<c:if test="${not empty manufacturers}">
    <table border=1 cellspacing=0>
        <thead style="background:lightgrey">
        <tr>
            <th>ID</th>
            <th>Производитель</th>
            <th>Активный</th>
            <th></th><th></th>
        </tr>
        </thead>
        <c:forEach items="${manufacturers}" var="man">
            <tr>
                <td>${man.id}</td>
                <td>${man.name}</td>
                <td><input id="cbtest" type="checkbox" value="${man.active}"/></td>
                <td><a href="<c:url value="/manufacturer/edit/${man.id}"/>">Редактировать</a></td>
                <td><a href="<c:url value="/manufacturer/delete/${man.id}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty manufacturers}">No records found</c:if>
</body>
</html>
