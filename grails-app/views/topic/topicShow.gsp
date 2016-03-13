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
    <title>Topic Show</title>
</head>

<body>
<div class="col-xs-5">
    <g:render template="/topic/showPostTopic" model="[topic:topic]"/>
    <g:render template="/subscription/subscriptions" model="[subscribedUsers:subscribedUsers]"/>
</div>
<div class="col-xs-7">
    <g:render template="/topic/showPostUserPost" model="[subscribedTopics:subscribedTopics]"/>
    <my:trendingTopics/>
    <my:topPosts/>
</div>
</body>
</html>