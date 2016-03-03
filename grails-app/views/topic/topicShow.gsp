<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 3/3/16
  Time: 4:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="col-xs-5">
    <g:render template="/topic/showPost" model="[topic:topic]"/>
    <g:render template="/topic/showPost2" model="[subscribedUsers:subscribedUsers]"/>
</div>
<div class="col-xs-7">
    <g:render template="/topic/showPost3" model="[subscribedTopics:subscribedTopics ]"/>
</div>
</body>
</html>