<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Технические характеристики</title>
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
        //= templates/header.jsp
        <div class="content">
            <table>
                <tr>
                    <td>
                        //= templates/search.jsp
                        <br>
                        //= templates/manufacturersList.jsp
                    </td>
                    <td id="searchResult">
                        //= templates/main.jsp
                    </td>
                </tr>
            </table>
        </div>
        //= templates/footer.jsp
    </div>
</body>
</html>