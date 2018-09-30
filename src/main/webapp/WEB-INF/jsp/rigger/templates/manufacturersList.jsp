<h3>Производители</h3>
<table>
    <c:forEach items="${manufacturers}" var="entry">
        <tr>
            <td><a href="<c:url value="/bike/${entry.name}"/>">${entry.name}</a></td>
        </tr>
    </c:forEach>
</table>