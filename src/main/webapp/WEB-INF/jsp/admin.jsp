<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Панель администратора</title>
</head>
<body>
    <h3>Панель администратора</h3>
    <a href="<c:url value="/"/>">Главная</a>
    <br>
    <a href="/admin/parser">Парсер</a>
    <br>
    <a href="/admin/manufacturer">Производители</a>
    <br>
    <a href="/admin/dictionary">Справочники</a>
</body>
</html>