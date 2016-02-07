<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
 <title>
 <c:if test="${empty user.id}"> Добавление пользователя</c:if>
 <c:if test="${not empty user.id}"> Редактирование пользователя </c:if>
 </title>
</head>
<body>
<form:form method="POST" action="/" commandName="user">
 <form:hidden path="id"/>
 <table>
   <tr>
     <td>Логин</td>
     <td><form:input path="login"/></td>
   </tr>
   <tr>
     <td>Имя пользователя</td>
     <td><form:input path="name"/></td>
   </tr>
   <tr>
     <td>E-mail</td>
     <td><form:input path="email"/></td>
   </tr>
   <tr>
     <td>Дата рождения</td>
     <td><form:input path="birthDate"/></td>
   </tr>
   <tr>
     <td colspan="2"><input type="submit" value="Сохранить"/></td>
   </tr>
 </table>
</form:form>
</body>
</html>