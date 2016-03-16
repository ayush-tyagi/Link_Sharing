<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <asset:javascript src="jquery.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:stylesheet src="bootstrap.min.css"/>
</head>

<body>
<div style="text-align: center">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <h2 style="color: #990000;">Hello, ${userName} </h2>
                <h4>Your new password for LinkSharing is
                    <h3 style="color:#0000ff;text-decoration: underline;"><strong>"${randomPassword}"</strong></h3></h4>
            </div>

        </div>
    </div>
</div>
</body>
</html>