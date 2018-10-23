<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Технические характеристики</title>
    //= templates/head.jsp
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