<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 12/3/16
  Time: 12:33 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Forgot Password</title>
</head>

<body>

<div class="container-fluid">
    <div class="col-xs-5">
        <g:uploadForm controller="user" action="forgotPassword" >
    <form class="form-horizontal">
    <div class="form-group" >
        <label class="pull-left control-label col-xs-4" >Email:</label>

        <div class="col-xs-8">
            <g:textField  class="form-control" id="email" name="email" placeholder="Enter email"/>
        </div>
    </div>
        <div class="form-group">
            <label class="pull-left control-label col-xs-4" for="userName">UserName</label>

            <div class="col-xs-8">
                <g:textField  class="form-control" name="userName" id="userName" placeholder="User Name"/>
            </div>
        </div>

    <div class="form-group">


        <div class="col-xs-4">
        <span>    <g:submitButton type="submit" name="submit"
                            class="form-control btn btn-success " id="submit"
                            placeholder="Share"
                            style="color:black;border:solid black;border-radius:7px"/>



            <g:submitButton name="cancel" type="cancel"
                            class="form-control btn btn-danger " id="cancel"
                            placeholder="Cancel"
                            style="color:blue;border:solid black;border-radius:7px"/>
</span>        </div>


 </div>

</form>
        </g:uploadForm>
    </div>
    </div>
</body>
</html>