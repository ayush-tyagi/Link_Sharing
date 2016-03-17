<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 3/3/16
  Time: 5:09 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>DashBoard</title>
</head>

<body>
<div class="col-xs-5">
    <g:render template="/user/users" model="[user:user,numberOfSubscription:numberOfSubscription]"/>
    <div id="ajaxifiedSubscription">
        <g:render template="/subscription/subscriptions" model="[subscribedTopics: subscribedTopics]"/>
    </div>

</div>

<div class="col-xs-7">
    <g:render template="/readingItem/inbox" model="[readingItems: readingItems]"/>
    <my:trendingTopics/>
</div>
</body>
</html>