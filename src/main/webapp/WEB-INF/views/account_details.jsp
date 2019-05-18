<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Edit User Details" scope="request"/>

<%@include file="partials/header.jsp"%>
<%@include file="partials/navbar.jsp"%>


<div class="container account-details-container">

<form:form action="${pageContext.request.contextPath}/userAccount" modelAttribute="tempUserAccount" method="post">

    <p class="badge badge-info badge-nobottom">Group:</p>
    <p class="badge badge-warning badge-nobottom">Permanent</p>
    <div class="input-group mb-3">
        <input type="text" class="form-control" value="${tempUserAccount.groupName}" disabled >
    </div>
    <p class="badge badge-info badge-nobottom">Username:</p>
    <p class="badge badge-warning badge-nobottom">Permanent</p>
    <div class="input-group mb-3">
        <input type="text" class="form-control" value="${tempUserAccount.userName}" disabled >
    </div>

    <%--FIRSTNAME--%>
    <p class="badge badge-info badge-nobottom">First Name:</p>
    <form:errors path="firstName" class="badge badge-danger"/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon4">
                <i class="fas fa-signature"></i>
            </span>
        </div>
        <form:input path="firstName" class="form-control"/>*
        <br>
    </div>

    <p class="badge badge-info badge-nobottom">Last Name:</p>
    <form:errors path="lastName" class="badge badge-danger" />
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon5">
                <i class="fas fa-signature"></i>
            </span>
        </div>
        <form:input path="lastName"  class="form-control"/>*
        <br>
    </div>


    <%--BIRTHDAY--%>
    <p class="badge badge-info badge-nobottom">Birthday:</p>
    <form:errors path="birthday" class="badge badge-danger" />
    <div class="input-group mb-3">
            <%--<label for="birthdayInput">Birthday</label>--%>
        <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon7">
                    <i class="fas fa-birthday-cake"></i>
                </span>
        </div>
        <form:input id="birthdayInput" type="date" path="birthday" min="1950-01-01" max="2005-12-31" class="form-control" value="${tempUserAccount.birthday}" required="true"/>*
        <br>
    </div>


    <%--HEIGHT FEET AND INCHES--%>
    <p class="badge badge-info badge-nobottom">Height:</p>
    <div class="input-group mb-3">
            <%--<label for="heightInput">Height</label>--%>
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
    <form:errors path="gender" class="badge badge-danger" />
    <div class="input-group mb-3">
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
        <form:input path="email" class="form-control"/>*
        <br>
    </div>

    <%--PHONE NUMBER--%>
    <p class="badge badge-info badge-nobottom">Phone Number:</p>
    <p class="badge badge-warning badge-nobottom">Optional</p>
    <form:errors path="phoneNumber" class="badge badge-pill badge-danger"/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon11">
                    <i class="fas fa-phone"></i>
                </span>
        </div>
        <form:input type="number" path="phoneNumber" class="form-control"/>
        <br>
    </div>

    <%--PHONE SERVICE--%>
    <p class="badge badge-info badge-nobottom">Phone Carrier:</p>
    <p class="badge badge-warning badge-nobottom">Optional</p>
    <form:errors path="phoneService" class="badge badge-danger" />
    <div class="input-group mb-3">
        <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon12">
                    <i class="fas fa-globe"></i>
                </span>
        </div>
        <form:input path="phoneService" class="form-control"/>
        <br>
    </div>

    <%--Defaults--%>
    <form:hidden path="startingWeight" value="${tempUserAccount.startingWeight}"/>
    <form:hidden path="currentWeight" value="${tempUserAccount.currentWeight}"/>
    <form:hidden path="authority" value="${tempUserAccount.authority}"/>
    <form:hidden path="enabled" value="${tempUserAccount.enabled}"/>
    <form:hidden path="groupName" value="${tempUserAccount.groupName}"/>
    <form:hidden path="userName" value="${tempUserAccount.userName}"/>



    <%--PASSWORD AND REPEAT--%>
    <p style="color:white;">Enter password to submit changes</p>
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




    <input type="submit" value="Save All Changes" id="submitButton" class="btn btn-primary" disabled>
    <input type="button" value="Cancel" class="btn btn-warning" onclick="window.location.href='${pageContext.request.contextPath}/'"/>
    <input type="button" id=deleteBtn" value="Delete Account" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">

</form:form>

    <!-- DELETE Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="modelTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modelTitle">Delete Account</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form:form action="${pageContext.request.contextPath}/deleteUser" method="POST">
                        <p>Deleting your account cannot be undone.</p>
                        <p>Enter your username to confirm.</p>
                        <input type="text" class="form-control" name="deleteUsername" id="deleteUsername" onkeyup="usernameMatch('${tempUserAccount.userName}')">
                        <button type="submit" id="deleteBtn" class="btn btn-danger" disabled>Confirm Delete</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
<!--Validate passwords match (disable submit button if no)-->
<script src="/js/validation.js" type="application/javascript" ></script>

    <!--VALIDATE MATCHING USERNAME FOR DELETION -- ; CANNOT PASS VARIABLE TO EXTERNAL JS FILE -->
    <script>
        const deleteBtn = document.querySelector("#deleteBtn");
        const deleteInput = document.querySelector("#deleteUsername");

        function usernameMatch(actualUsername){
            let username = actualUsername.toString();
            if(username === "" || deleteInput.value === ""){
                deleteBtn.setAttribute("disabled", "true");
            }else{
                if(username === deleteInput.value){
                    deleteBtn.removeAttribute("disabled");
                }else{
                    deleteBtn.setAttribute("disabled", "true") ;
                }
            }
        }
    </script>


<%@include file="partials/footer.jsp"%>