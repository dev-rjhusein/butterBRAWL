<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../partials/header.jsp"%>
<body>


<table class="table text-center">
    <tr>
        <th colspan="2">
            <h3>Group Rankings</h3>
        </th>
    </tr>
    <tr>
        <th scope="col">Username</th>
        <th scope="col">Percent Lost</th>
    </tr>

    <c:forEach var="userRank" items="${namesAndPercents}">
        <tr>
            <td>${userRank.key}</td>
            <td>${userRank.value}%</td>
        </tr>
    </c:forEach>
</table>


<%@include file="../partials/footer.jsp"%>