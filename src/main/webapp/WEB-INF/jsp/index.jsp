<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
 <title>Объявления</title>
</head>
<body>
 <h3>Объявления</h3>
<a href="<c:url value="/add"/>">Добавить</a>
<a href="<c:url value="/manufacturer"/>">Производители и модели</a>
 
 <table border=1 cellspacing=0>
 <thead style="background:lightgrey">
 <tr>
     <th>Заголовок</th>
     <th>Производитель</th>
     <th>Модель</th>
     <th>Год выпуска</th>
     <th>Объем двигателя, см3</th>
     <th>Пробег, км</th>
     <th>Описание</th>
     <th>Телефон</th>
     <th>E-mail</th>
     <th>Дата размещения</th>
     <th>Конец размещения</th>
     <th></th><th></th>
   </tr>
 </thead>
   <c:forEach items="${ads}" var="ad">
   <tr>
     <td>${ad.title}</td>
     <td>${ad.manufacturer.name}</td>
     <td>${ad.modelId}</td>
     <td>${ad.produceYear}</td>
     <td>${ad.capacity}</td>
     <td>${ad.mileage}</td>
     <td>${ad.description}</td>
     <td>${ad.phone}</td>
     <td><a href="mailto:${ad.email}">${ad.email}</a></td>
     <td><fmt:formatDate value="${ad.startDate}" pattern="dd-MM-yyyy"/></td>
     <td><fmt:formatDate value="${ad.endDate}" pattern="dd-MM-yyyy"/></td>
     <td><a href="<c:url value="/edit/${ad.id}"/>">Редактировать</a></td>
     <td><a href="<c:url value="/delete/${ad.id}"/>">Удалить</a></td>
   </tr>
   </c:forEach>
 </table>
 <c:if test="${empty ads}">No records found</c:if>
</body>
</html>