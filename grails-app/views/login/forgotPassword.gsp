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
    <form class="form-horizontal">
    <div class="form-group">
        <label class="pull-left control-label col-xs-4" for="email">Email:</label>

        <div class="col-xs-8">
            <input type="email" class="form-control" id="email" placeholder="Enter email">
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-6">
            <a href="#" style="text-decoration:underline;text-align:center"></a>
        </label>

        <div class="col-xs-4">
        <span>    <g:submitButton type="submit" name="submit" formaction=""
                            class="form-control btn btn-primary " id="submit"
                            placeholder="Share"
                            style="color:blue;border:solid black;border-radius:7px"/>



            <g:submitButton name="cancel" type="cancel"
                            class="form-control btn btn-primary " id="cancel"
                            placeholder="Cancel"
                            style="color:blue;border:solid black;border-radius:7px"/>
</span>        </div>


 </div>

</form>
    </div>
    </div>
</body>
</html>