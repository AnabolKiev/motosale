<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики</title>
</head>
<body>
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