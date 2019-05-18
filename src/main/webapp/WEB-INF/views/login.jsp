<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Login" scope="request"/>

<%@ include file="partials/header.jsp"%>

<div class="container text-center login-container">

    <img class="logo-img" src="/images/bblogo.png" alt="ButterBrawl Logo Image">



<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="form-group">

    <%--Test incorrent credentials--%>
    <c:if test="${param.error != null}">
        <div class="alert alert-danger" role="alert">
            <p style="color:red;">Incorrect Username / Password</p>
        </div>
    </c:if>

    <%--Test for logout--%>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success" role="alert">
            <p style="color:green;"> Successfully logged out! </p>
        </div>
    </c:if>
    <div class="alert alert-danger" role="alert">
        Attention!<br> The latest desktop Google Chrome update has introduced many bugs into existing applications implementing Spring Security.
        I'm currently working on fixing the Login feature for Chrome, but in the mean time please use FireFox, Edge, Safari or any mobile
        browser. Sorry about that!
    </div>

        <%--LOGIN INPUT FIELDS--%>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">
                <i class="fas fa-user"></i>
            </span>
        </div>
        <input class="form-control" type="text" name="username" placeholder="Enter Username"><br>
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon2">
                <i class="fas fa-unlock-alt"></i>
            </span>
        </div>
        <input class="form-control" type="password" name="password" placeholder="Password"><br>
    </div>

    <input class="btn btn-success form-control" type="submit" value="Login">
</form:form>

    <!--CREATE USER BUTTON-->
    <div class="input-group mb-3">
    <button type="button" class="btn btn-primary form-control" onclick="window.location.href='${pageContext.request.contextPath}/signup/user'">New User</button>
    <button type="button" class="btn btn-warning form-control" onclick="window.location.href='${pageContext.request.contextPath}/signup/group'">New Group</button>
    </div>

    <div class="card border-warning mb-3" style="max-width: 100%; background: #143351;">
        <div class="card-body text-warning">
            <h5 class="card-title">Important Note:</h5>
            <p class="card-text">To create a user account, first you must have a valid group name. However, you can login with the demo credentials: Username: "username" and Password: "password". You can also create an account with the sample group "testgroup".</p>
        </div>
    </div>

</div>
<%@ include file="partials/footer.jsp"%>