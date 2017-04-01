<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/jquery.multiselect.js"></script>
    <script src="/js/script.js"></script>
    <link href="/img/favicon.ico" rel="shortcut icon">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/jquery.multiselect.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <h1 class="logo">
                <a href="/">
                    <img src="/img/logo.jpg"/>
                </a>
            </h1>
        </div>
        <div class="content">
            <table>
                <tr>
                    <td>
                        <h3>Поиск по параметрам</h3>
                        <form class="searchForm">
                            <div>
                                <select id="manufacturerSelect" name="manufacturerId" required multiple>
                                    <c:forEach items="${manufacturers}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <select id="categorySelect" name="categoryId" required multiple>
                                    <c:forEach items="${categories}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <select id="finalDriveTypeSelect" name="finalDriveTypeId" required multiple>
                                    <c:forEach items="${finalDriveTypes}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                Год
                                <select id="yearFromSelect" class="year">
                                    <option value="">от</option>
                                </select>
                                <select id="yearToSelect" class="year">
                                    <option value="">до</option>
                                </select>
                            </div>
                            <div>
                                <select id="engineTypeSelect" name="engineTypeId" required multiple>
                                    <c:forEach items="${engineTypes}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                Объем двигателя
                                <select id="displacementFromSelect" class="displacement">
                                    <option value="">от</option>
                                </select>
                                <select id="displacementToSelect" class="displacement">
                                    <option value="">до</option>
                                </select>
                            </div>
                            <div>
                                <input id="searchModels" type="submit" value="Поиск"/>
                            </div>
                        </form>
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
                    <td id="searchResult">
                        <%--<div id="searchResult"></div>--%>
                    </td>
                </tr>
            </table>
        </div>
        <div class="footer">
            <div class="copyright">© 2017</div>
            <div class="contact">Пожелания и предложения -
                <a href="mailto: anabol.ua@gmail.com"> Александр Ковальчук</a>
            </div>
        </div>
    </div>
</body>
</html>