<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики</title>
    <meta charset="UTF-8" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/lib/jquery.multiselect.js"></script>
    <script src="https://unpkg.com/react@16.5.2/umd/react.production.min.js"></script>
    <script src="https://unpkg.com/react-dom@16.5.2/umd/react-dom.production.min.js"></script>
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
            <form class="search">
                <input id="searchText" type="text">
                <button id="searchButton" type="submit" value="Поиск">
                    <svg class="icon-svg" width="24" height="24" viewBox="0 0 32 32" aria-hidden="true" version="1.1" role="img">
                        <path d="M21.416 13.21c0 4.6-3.65 8.34-8.14 8.34S5.11 17.81 5.11 13.21c0-4.632 3.65-8.373 8.167-8.373 4.488 0 8.14 3.772 8.14 8.372zm1.945 7.083c1.407-2.055 2.155-4.57 2.155-7.084C25.515 6.277 20.04.665 13.277.665S1.04 6.278 1.04 13.21c0 6.93 5.475 12.542 12.237 12.542 2.454 0 4.907-.797 6.942-2.208l7.6 7.79 3.14-3.22-7.6-7.82z"/>
                    </svg>
                </button>
            </form>
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
                                        <a href="/bike/Ducati">Ducati</a>
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