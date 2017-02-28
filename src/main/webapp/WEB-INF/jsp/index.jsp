<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/jquery.multiselect.js"></script>
    <script src="js/script.js"></script>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/styles.css" rel="stylesheet" type="text/css" >
    <link href="css/jquery.multiselect.css" rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <table>
        <tr>
            <td>
                Поиск по параметрам
                <div id="search">
                    <form id="searchForm">
                        <select id="categorySelect" name="categoryId" required multiple>
                            <c:forEach items="${categories}" var="entry">
                                <option value="${entry.id}">${entry.name}</option>
                            </c:forEach>
                        </select>
                        <select id="finalDriveTypeSelect" name="finalDriveTypeId" required multiple>
                            <c:forEach items="${finalDriveTypes}" var="entry">
                                <option value="${entry.id}">${entry.name}</option>
                            </c:forEach>
                        </select>
                        Год
                        <select id="yearFromSelect" class="year">
                            <option value="">от</option>
                        </select>
                        <select id="yearToSelect" class="year">
                            <option value="">до</option>
                        </select>
                        <select id="engineTypeSelect" name="engineTypeId" required multiple>
                            <c:forEach items="${engineTypes}" var="entry">
                                <option value="${entry.id}">${entry.name}</option>
                            </c:forEach>
                        </select>
                        Объем двигателя
                        <select id="displacementFromSelect" class="displacement">
                            <option value="">от</option>
                        </select>
                        <select id="displacementToSelect" class="displacement">
                            <option value="">до</option>
                        </select>
                        <br>
                        <input id="searchModels" type="submit" value="Поиск"/>
                    </form>
                </div>
                <br>
                <h3>Производители</h3>
                <table>
                <c:forEach items="${manufacturers}" var="entry">
                    <tr>
                        <td><a href="<c:url value="/${entry.name}"/>">${entry.name}</a></td>
                    </tr>
                </c:forEach>
                </table>
            </td>
            <td>
                <div id="test"></div>
            </td>
        </tr>
    </table>
</body>
</html>