<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 25/2/16
  Time: 10:29 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<my:showList/>
<my:showAdmin isAdmin="${session.user.isAdmin}">User is Admin</my:showAdmin>
<table border="1">
    <th>Id</th>
    <th>Name</th>

    <g:each in="${list}">
        <tr>
            <td>${it.id}</td>
            <td>${it.name}</td>
        </tr>
    </g:each>
</table>

<div class="container">
    <div class="row-fluid">
        <div class="col-lg-12">
            <g:renderErrors bean="${user}"/>
            <g:form action="save">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-5">
                            <label>Name</label>
                        </div>

                        <div class="col-md-7">
                            <g:textField name="Name" value="${user?.name}">
                            </g:textField>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-5">
                            <label>Password</label>
                        </div>

                        <div class="col-md-7">
                            <g:passwordField name="password" value="${user?.password}">
                            </g:passwordField>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-5">
                            <label>Married</label>
                        </div>

                        <div class="col-md-7">
                            <g:checkBox name="checkBox" checked="false">
                            </g:checkBox>
                        </div>
                    </div>
                    <g:submitButton name="Click here"></g:submitButton>
                </div>
            </g:form>
        </div>
    </div>
</div>



</body>
</body>
</html>