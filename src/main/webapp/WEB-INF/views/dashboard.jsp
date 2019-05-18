<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageTitle" value="${myAccount.firstName}'s Dashboard" scope="request"/>

<%@include file="partials/header.jsp"%>
<%@include file="partials/navbar.jsp"%>


<div class="container text-center dashboard-container">


    <div class="jumbotron">
        <h2 class="title-text text-center">${myAccount.firstName}'s Dashboard</h2>
    </div>

    <div class="row">
        <div class="col-md-6">
            <iframe src="/weightLog"></iframe>
        </div>
        <br>
        <div class="col-md-6">
            <iframe src="/rankings"></iframe>
        </div>
    </div>
</div>
<%@include file="partials/footer.jsp"%>