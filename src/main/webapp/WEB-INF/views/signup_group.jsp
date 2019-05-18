<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Signup New Group" scope="request"/>

<%@ include file="partials/header.jsp"%>


<div class="container signup-user-container">
<form:form action="${pageContext.request.contextPath}/signup/group" modelAttribute="newGroup" method="POST">
    <c:if test="${groupTakenError != null}">
        <div class="badge badge-danger">
            ${groupTakenError}
        </div>
    </c:if>
    <form:errors path="groupName" cssClass="badge badge-danger"/>
    <form:input path="groupName" placeholder="Enter Group Name"/>
    <input type="submit" value="Submit" class="btn btn-primary">
    <input type="button" value="Cancel" class="btn btn-danger" onclick="window.location.href='${pageContext.request.contextPath}/'"/>
</form:form>

</div>



<%@include file="partials/footer.jsp"%>