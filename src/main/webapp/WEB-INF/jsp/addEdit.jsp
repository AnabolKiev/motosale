<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
 <title>
 <c:if test="${empty ad.id}"> Добавление объявления</c:if>
 <c:if test="${not empty ad.id}"> Редактирование объявления</c:if>
 </title>
</head>
<body>
<form:form method="POST" action="/" commandName="ad">
 <form:hidden path="id"/>
 <table>
   <tr>
     <td>Заголовок</td>
     <td><form:input path="title"/></td>
   </tr>
   <tr>
     <td>Производитель</td>
     <td>
       <form:select path="manufacturer">
         <form:options items="${ad.manufacturer}" id="id" itemValue="name"></form:options>
       </form:select>
     </td>
   </tr>
   <tr>
     <td>Модель</td>
     <td><form:input path="modelId"/></td>
   </tr>
   <tr>
     <td>Год выпуска</td>
     <td><form:input path="produceYear"/></td>
   </tr>
   <tr>
     <td>Объем двигателя, см3</td>
     <td><form:input path="capacity"/></td>
   </tr>
   <tr>
     <td>Пробег, км</td>
     <td><form:input path="mileage"/></td>
   </tr>
   <tr>
     <td>Описание</td>
     <td><form:input path="description"/></td>
   </tr>
   <tr>
     <td>Телефон</td>
     <td><form:input path="phone"/></td>
   </tr>
   <tr>
     <td>E-mail</td>
     <td><form:input path="email"/></td>
   </tr>
   <tr>
     <td>Дата размещения</td>
     <td><form:input path="startDate"/></td>
   </tr>
   <tr>
     <td>Конец размещения</td>
     <td><form:input path="endDate"/></td>
   </tr>
   <tr>
     <td colspan="2"><input type="submit" value="Сохранить"/></td>
   </tr>
 </table>
</form:form>
</body>
</html>