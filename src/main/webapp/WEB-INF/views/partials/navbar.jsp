
<ul class="navbar nav fixed-top nav-justified" style="background-color: #235f99;">

    <li class="nav-item">
        <a style="color: #FFFFFF;" class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
    </li>


    <li class="nav-item">
        <a style="color: #FFFFFF;" class="nav-link disabled-nav-item" href="#">Stats<span class="sr-only">(current)</span></a>
    </li>


    <li class="nav-item">
        <a style="color: #FFFFFF;" class="nav-link disabled-nav-item" href="#">Tips<span class="sr-only">(current)</span></a>
    </li>

    <li class="nav-item dropdown">
        <div style="color: #FFFFFF;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Account
        </div>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/userAccount">Settings</a>
            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" class="dropdown-item">
            </form:form>
        </div>
    </li>


</ul>
<!-- END NAVBAR -->