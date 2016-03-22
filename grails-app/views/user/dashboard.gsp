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
        window.___gcfg = {
            lang: 'en-US',
            parsetags: 'onload'
        };
    </script>
    <script src="https://apis.google.com/js/platform.js" async defer>

    </script>

    %{--..........................................fb...............................--}%


    <div id="fb-root"></div>

    <script>
        window.fbAsyncInit = function () {
            FB.init({
                appId: '1689515041287155', status: true, cookie: true,
                xfbml: true
            });
        };
        (function () {
            var e = document.createElement('script');
            e.async = true;
            e.src = document.location.protocol +
                    '//connect.facebook.net/en_US/all.js';
            document.getElementById('fb-root').appendChild(e);
        }());
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#share_button').click(function (e) {
                e.preventDefault();
                FB.ui(
                        {
                            method: 'feed',
                            name: 'This is the content of the "name" field.',
                            link: 'http://localhost:8080/',
                            picture: 'http://localhost:8080/img.png',
                            caption: 'This is the content of the "caption" field.',
                            description: 'This is the content of the "description" field, below the caption.',
                            message: ''
                        });
            });
        });
    </script>


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