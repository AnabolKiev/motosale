<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
 <title>Объявления</title>
</head>
<body>
 <h3>Пользователи</h3>
<a href="<c:url value="/add"/>">Добавить</a>
 
 <table>
 <thead>
 <tr>
     <td>Логин</td>
     <td>Имя</td>
     <td>E-mail</td>
     <td>Дата рождения</td>
     <td>Действия</td>
   </tr>
 </thead>
   <c:forEach items="${users}" var="user">
   <tr>
     <td>${user.login}</td>
     <td><c:out value="${user.name}" escapeXml="true"/></td>
     <td><a href="mailto:${user.email}">${user.email}</a></td>
     <td><fmt:formatDate value="${user.birthDate}" pattern="dd-MM-yyyy"/></td>
     <td><a href="<c:url value="/edit/${user.id}"/>">Редактировать</a></td>
   </tr>
   </c:forEach>
 </table>
</body>
</html>