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

