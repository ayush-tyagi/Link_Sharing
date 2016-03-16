
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Profile</title>
</head>

<body>
<div class="col-xs-5">
    <g:render template="/user/users" model="[user: user, numberOfSubscription: numberOfSubscription]"/>
    <g:hiddenField name="id" id="id" value="${user.id}"/>
    <div  id="printSubscription">
        <g:render template="/readingItem/profileSubscription" model="[subscribedTopics: subscribedTopics]"/>
    </div>
</div>

<div class="col-xs-7" id="printTopics">
    <g:render template="/readingItem/profileTopics" model="[createdTopics: createdTopics]"/>
</div>
</body>
</html>




