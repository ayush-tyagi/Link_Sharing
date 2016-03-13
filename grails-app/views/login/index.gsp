<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 25/2/16
  Time: 11:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
    <style>
    a {
        text-decoration: underline;
    }

    #search-panel {
        border: solid black;
        border-radius: 8px;
    }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="col-xs-7">
        <g:render template="/topic/recentShare" model="[recentShares: recentShares]"/>
        <my:topPosts/>
    </div>

    <div class="col-xs-5">
        <g:render template="/login/userLogin"/>
        <g:render template="/user/userRegister" model="[user: user]"/>
    </div>
</div>
</body>
</html>