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
        var msg = "${flash.message}" ? "${flash.message}" : "${flash.error}";
        if (msg != undefined && msg != "") {
            alert(msg);
        }
        $(document).ready(function () {
            $("#validateForm").validate({
                rules: {
                    firstName: {
                        required: true
                    },
                    lastName: {
                        required: true
                    },
                    userName: {
                        required: true
                    },
                    email_id: {
                        email: true,
                        required: true
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirmPassword: {
                        required: true,
                        minlength: 5,
                        //equalTo:"#password"
                    }
                },
                messages: {
                    firstName: {
                        required: "First Name is required"
                    },

                    lastName: {
                        required: "Last Name"
                    },

                    userName: {
                        required: "User Name is required"
                    },
                    email: {
                        required: "Email is required",
                        email: "email should be in format"
                    },
                    password: {
                        required: "Password is required",
                        minlength: "Password must be atleast 5 characters long"
                    },
                    confirmPassword: {
                        required: "Confirm password is required",
                        minlength: "Confirm Password must be atleast 5 characters long",
                        equalTo: "Confirm Password must match Password"
                    }
                },
                errorPlacement: function (error, element) {
                    console.log(error);
                    $(element).addClass('error');
                    $(element).parent().siblings('.msg').html('<span style="color: red;padding-left: 180px;">' + error[0].innerText + '</span>');
                },
                success: function (errorLabel, element) {
                    $(element).removeClass('error');
                }
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