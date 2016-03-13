<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 13/3/16
  Time: 11:02 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Admin</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid">
    <div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px">
        <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">
            Users
            <div class="pull-right">

                <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Search']" name="topicName"
                          id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
            </div>
        </div>

        <div class="panel-body">

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>UserName</th>
                    <th>Email</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Active</th>
                    <th>Manage</th>
                </tr>
                </thead>
                <tbody>
            <g:each in="${users}" var="user"><div class="myUser">
                <g:if test="${user.isActive}">
                <tr class="alert-success">
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email_id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td><g:if test="${users.isActive}">Yes</g:if><g:else>No</g:else></td>
                    <td><my:activateDeacivate id="${user.id}"/></td>
                </tr>
                </g:if>
                <g:else>
                    <tr class="alert-danger">
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.email_id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td><g:if test="${users.isActive}">Yes</g:if><g:else>No</g:else></td>
                        <td><my:activateDeacivate id="${user.id}"/></td>
                    </tr>

                </g:else></div>

            </g:each>
                </tbody>
            </table>

        </div>
    </div>

</div>
</body>
</html>