<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../partials/header.jsp"%>

<body>

<table class="table text-center" style="margin-top: 60px;">
    <tr>
        <th colspan="2">
            <h3>Weight Logs</h3>
        </th>
    </tr>
    <c:forEach var="userWeight" items="${myWeights}">
        <tr>
            <td>${userWeight.date}</td>
            <td>${userWeight.weight}</td>
        </tr>
    </c:forEach>
</table>

<form:form cssClass="footer" action="/weightLog" modelAttribute="newWeightLog" method="post">
<div class="input-group mb-3">
        <form:input path="logWeight" type="number" placeholder="Enter new weight" min="100" max="500" class="form-control" required="true"/>
        <div class="input-group-append">
            <input type="submit" value="Add Log" class="btn btn-primary"/>
        </div>
</div>
</form:form>


<%@include file="../partials/footer.jsp"%>