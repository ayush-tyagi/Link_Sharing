<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 4/3/16
  Time: 3:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
<meta name="layout" content="main">
</head>

<body>
<div class="container">
<div class="col-xs-5">
    <g:render template="/resource/users" model="[resource:resource,score:score]"/>
</div>
<div class="col-xs-7">
<my:trendingTopics/>
</div>
</div>
</body>
</html>