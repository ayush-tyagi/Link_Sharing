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
    <script>
        var msg = "${flash.message}" ? "${flash.message}" :"${flash.error}";
        if (msg != undefined && msg != "") {
            alert(msg);
        }
    </script>
</head>

<body>
<div class="col-xs-5">
    <g:render template="/subscription/subscriptions" model="[subscribedTopics:subscribedTopics]"/>
    <my:trendingTopics/>
</div>

<div class="col-xs-7">
    <g:render template="/readingItem/inbox" model="[readingItems: readingItems]"/>
</div>
</body>
</html>