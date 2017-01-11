<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
    <script src="https://unpkg.com/react@latest/dist/react.min.js"></script>
    <script src="https://unpkg.com/react-dom@latest/dist/react-dom.min.js"></script>
    <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
    <script type="text/babel" src="js/script.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div id="test"></div>
<h3>Мотокаталог</h3>
<table>
    <c:forEach items="${manufacturers}" var="entry">
        <tr>
            <td><a href="<c:url value="/${entry.name}"/>">${entry.name}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>