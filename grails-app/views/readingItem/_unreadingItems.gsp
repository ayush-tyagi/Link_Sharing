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
                <g:each in="${resources}" var="resource">
                          You should read the
                  <strong>"${resource.topic.name}"</strong>
                    <p>${user.userName}</p>
                </g:each>
            </div>

        </div>
    </div>
</div>
</body>
</html>