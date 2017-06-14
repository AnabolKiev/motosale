<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/jquery.multiselect.js"></script>
	<script src="//unpkg.com/react@15.6.0/dist/react.min.js"></script>
	<script src="//unpkg.com/react-dom@15.6.0/dist/react-dom.min.js"></script>
	<script src="/resources/js/script.js"></script>
    <link href="/resources/img/favicon.ico" rel="shortcut icon">
    <link href="/resources/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/jquery.multiselect.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <h1 class="logo">
                <a href="/">
                    <img src="/resources/img/logo.png"/>
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
                                <select id="manufacturerSelect" name="manufacturerId" multiple>
                                    <c:forEach items="${manufacturers}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <select id="categorySelect" name="categoryId" multiple>
                                    <c:forEach items="${categories}" var="entry">
                                        <option value="${entry.id}">${entry.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <select id="finalDriveTypeSelect" name="finalDriveTypeId" multiple>
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
                                <select id="engineTypeSelect" name="engineTypeId" multiple>
                                    <c:set var="prevGroupOrder" scope="session" value=''/>
                                    <c:forEach items="${engineTypes}" var="entry">
                                            <c:if test="${entry.groupOrder != prevGroupOrder}">
                                                <c:if test="${prevGroupOrder != ''}">
                                                    </optgroup>
                                                </c:if>
                                                <optgroup label="${entry.groupName}">
                                                <c:set var="prevGroupOrder" scope="session" value="${entry.groupOrder}"/>
                                            </c:if>
                                                    <option value="${entry.id}">${entry.shortName}</option>
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
                                <td><a href="<c:url value="/bike/${entry.name}"/>">${entry.name}</a></td>
                            </tr>
                        </c:forEach>
                        </table>
                    </td>
		    <td id="searchResult">
		        <h1 class="title">MotoSearch - справочник технических характеристик мотоциклов</h1>
		        <div>
		            <ul id="mainManufacturers">
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Aprilia">
		                            <img src="/resources/img/bikes/Aprilia.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Aprilia">Aprilia</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/BMW">
		                            <img src="/resources/img/bikes/BMW.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/BMW">BMW</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Ducati">
		                            <img src="/resources/img/bikes/Ducati.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Ducati">BMW</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Harley-Davidson">
		                            <img src="/resources/img/bikes/Harley-Davidson.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Harley-Davidson">Harley-Davidson</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Honda">
		                            <img src="/resources/img/bikes/Honda.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Honda">Honda</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Husqvarna">
		                            <img src="/resources/img/bikes/Husqvarna.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Husqvarna">Husqvarna</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Hyosung">
		                            <img src="/resources/img/bikes/Hyosung.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Hyosung">Hyosung</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Indian">
		                            <img src="/resources/img/bikes/Indian.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Indian">Indian</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Kawasaki">
		                            <img src="/resources/img/bikes/Kawasaki.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Kawasaki">Kawasaki</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/KTM">
		                            <img src="/resources/img/bikes/KTM.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/KTM">KTM</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Moto Guzzi">
		                            <img src="/resources/img/bikes/MotoGuzzi.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Moto Guzzi">Moto Guzzi</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/MV Agusta">
		                            <img src="/resources/img/bikes/MVAgusta.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/MV Agusta">MV Agusta</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Royal Enfield">
		                            <img src="/resources/img/bikes/RoyalEnfield.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Royal Enfield">Royal Enfield</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Suzuki">
		                            <img src="/resources/img/bikes/Suzuki.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Suzuki">Suzuki</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Triumph">
		                            <img src="/resources/img/bikes/Triumph.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Triumph">Triumph</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Vespa">
		                            <img src="/resources/img/bikes/Vespa.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Vespa">Vespa</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Victory">
		                            <img src="/resources/img/bikes/Victory.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Victory">Victory</a>
		                    </div>
		                </li>
		                <li>
		                    <div class="mainManufacturers-img">
		                        <a href="/bike/Yamaha">
		                            <img src="/resources/img/bikes/Yamaha.jpg"/>
		                        </a>
		                    </div>
		                    <div class="mainManufacturers-link">
		                        <a href="/bike/Yamaha">Yamaha</a>
		                    </div>
		                </li>
		            </ul>
		        </div>
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