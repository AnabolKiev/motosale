<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Test parser</title>
</head>
<body>
<form:form method="POST" action="/parser" commandName="parser">
    <table>
        <tr>
            <td>URL</td>
            <td><form:input path="url"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Получить"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
