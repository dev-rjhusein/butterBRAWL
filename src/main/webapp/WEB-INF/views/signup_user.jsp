<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Signup New User" scope="request"/>

<%@ include file="partials/header.jsp"%>
<div class="container signup-user-container">

<form:form action="${pageContext.request.contextPath}/signup/user" modelAttribute="newUser" method="POST">

    <%--GROUP NAME--%>
    <p class="badge badge-info badge-nobottom">Group:</p>
                <%--Display error if Group Name doesn't exists--%>
    <c:if test="${groupNameError != null}">
        <div class="badge badge-danger">
            ${groupNameError}
        </div>
    </c:if>

    <form:errors path="groupName" class="badge badge-danger"/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">
                <i class="fas fa-users"></i>
            </span>
        </div>
        <form:input path="groupName" placeholder="Group Name" class="form-control"/>*
        <br>
    </div>


    <%--USERNAME--%>
    <p class="badge badge-info badge-nobottom">Username:</p>
            <%--Display error if username is taken--%>
    <c:if test="${usernameExistsError != null}">
        <div class="badge badge-danger">
            ${usernameExistsError}
        </div>
    </c:if>

    <form:errors path="userName" class="badge badge-danger"/>
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon2">
                    <i class="fas fa-user"></i>
                </span>
            </div>
        <form:input path="userName" placeholder="Username" class="form-control"/>*
        <br>
    </div>

    <%--PASSWORD AND REPEAT--%>
    <p class="badge badge-info badge-nobottom">Password:</p>
    <form:errors path="password" class="badge badge-danger"/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon3">
                <i class="fas fa-unlock-alt"></i>
            </span>
        </div>
        <form:password path="password" id="password1" placeholder="Password" required="true" class="form-control"/>*
        <br>
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon16">
                <i class="fas fa-unlock-alt"></i>
            </span>
        </div>
        <input type="password" id="password2" placeholder="Re-Enter Password" class="form-control" required>*
        <br>
    </div>

    <%--FIRST NAME--%>
    <p class="badge badge-info badge-nobottom">First Name:</p>
    <form:errors path="firstName" class="badge badge-danger"/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon4">
                <i class="fas fa-signature"></i>
            </span>
        </div>
        <form:input path="firstName" placeholder="First Name" class="form-control"/>*
        <br>
    </div>

    <%--LAST NAME--%>
    <p class="badge badge-info badge-nobottom">Last Name:</p>
    <form:errors path="lastName" class="badge badge-danger" />
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon5">
                <i class="fas fa-signature"></i>
            </span>
        </div>
        <form:input path="lastName" placeholder="Last Name" class="form-control"/>*
        <br>
    </div>


        <%--STARTING WEIGHT--%>
    <p class="badge badge-info badge-nobottom">Weight:</p>
    <form:errors path="startingWeight" class="badge badge-danger" />
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon6">
                <i class="fas fa-weight"></i>
            </span>
        </div>
        <form:input type="number" path="startingWeight" placeholder="Weight" class="form-control"/>*
        <br>
    </div>


        <%--BIRTHDAY--%>
    <p class="badge badge-info badge-nobottom">Birthday:</p>
    <form:errors path="birthday" class="badge badge-danger" />
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon7">
                    <i class="fas fa-birthday-cake"></i>
                </span>
            </div>
            <form:input id="birthdayInput" type="date" path="birthday" min="1950-01-01" max="2005-12-31" class="form-control" required="true"/>*
            <br>
    </div>


        <%--HEIGHT FEET AND INCHES--%>
    <p class="badge badge-info badge-nobottom">Height:</p>
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon8">
                    <i>FT</i>
                </span>
            </div>
            <form:select id="heightInput" path="heightFt" class="form-control">
                <form:option value="4"/>
                <form:option value="5"/>
                <form:option value="6"/>
            </form:select>*
            <br>
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon15">
                    <i>IN</i>
                </span>
            </div>
            <form:select path="heightIn" class="form-control">
                <form:option value="0"/>
                <form:option value="1"/>
                <form:option value="2"/>
                <form:option value="3"/>
                <form:option value="4"/>
                <form:option value="5"/>
                <form:option value="6"/>
                <form:option value="7"/>
                <form:option value="8"/>
                <form:option value="9"/>
                <form:option value="10"/>
                <form:option value="11"/>
            </form:select>*
            <br>
    </div>



    <%--GENDER--%>
    <p class="badge badge-info badge-nobottom">Gender:</p>
    <div class="input-group mb-3">
        <form:errors path="gender" class="badge badge-danger" />
        <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon13">
                    <i class="fas fa-transgender"></i>
                </span>
        </div>
        <form:select id="genderInput" path="gender" class="form-control">
            <form:option value="Female"/>
            <form:option value="Male"/>
        </form:select>*
        <br>
    </div>


    <%--NOTIFICATIONS--%>
    <p class="badge badge-info badge-nobottom">Notifications:</p>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon9">
                <i class="fas fa-bell"></i>
            </span>
        </div>
        <form:select id="notificationsInput" path="notifications" class="form-control">
            <form:option value="None"/>
            <form:option value="Email"/>
            <form:option value="Text"/>
        </form:select>*
        <br>
    </div>

            <%--EMAIL--%>
    <p class="badge badge-info badge-nobottom">Email:</p>
    <form:errors path="email" class="badge badge-pill badge-danger" />
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon10">
                    <i class="fas fa-envelope"></i>
                </span>
            </div>
            <form:input path="email" placeholder="Email Address" class="form-control"/>*
            <br>
    </div>

            <%--PHONE NUMBER--%>
    <p class="badge badge-info badge-nobottom">Phone Number:</p>
    <form:errors path="phoneNumber" class="badge badge-pill badge-danger"/>
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon11">
                    <i class="fas fa-phone"></i>
                </span>
            </div>
            <form:input type="number" path="phoneNumber" placeholder="Phone Number (Optional)" class="form-control"/>
            <br>
    </div>

            <%--PHONE SERVICE--%>
    <p class="badge badge-info badge-nobottom">Phone Carrier:</p>
    <form:errors path="phoneService" class="badge badge-danger" />
    <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon12">
                    <i class="fas fa-globe"></i>
                </span>
            </div>
            <form:input path="phoneService" placeholder="Phone Carrier (Optional)" class="form-control"/>
            <br>
        </div>

    <%--Default values--%>
    <form:hidden path="authority" value="ROLE_USER"/>
    <form:hidden path="enabled" value="true"/>
    <form:hidden path="currentWeight" value="100"/>

    <input type="submit" value="Create Account" id="submitButton" class="btn btn-primary" disabled>
    <input type="button" value="Cancel" class="btn btn-danger" onclick="window.location.href='${pageContext.request.contextPath}/'"/>

</form:form>

</div>

<!--Validate passwords match (disable submit button if no)-->
<script src="/js/validation.js" type="application/javascript" ></script>

<%@ include file="partials/footer.jsp"%>