<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 12/3/16
  Time: 1:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Profile</title>
</head>

<body>

<div class="container-fluid">
    <div class="col-xs-5">
        <g:render template="/user/users" model="[user:user,numberOfSubscription:numberOfSubscription]"/>
        <g:render template="/user/userTopics" model="[user:user,subscribedTopics: subscribedTopics]"/>
        <div id="ajaxifiedSubscription">
            <g:render template="/subscription/subscriptions" model="[subscribedTopics: subscribedTopics]"/>
        </div>

    </div>
    <div class="col-xs-7">
     <g:render template="userUpdate"/>
     <g:render template="changePassword"/>
    </div>
</div>
</body>
</html>