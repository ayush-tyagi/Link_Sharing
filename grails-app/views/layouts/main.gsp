<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">



    <style>

    a {
        text-decoration: underline;
    }

    #search-panel {
        border: solid black;
        border-radius: 8px;
    }

    .btn:focus {
        outline: none;
    }

    </style>


    <g:layoutHead/>
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <div class="panel panel-default" style="background-color:lightgrey ;">
                <div class="panel-body" style="border:3px solid  #0000ff;border-radius:5px;">
                    <div class="col-xs-4">
                        <a href="${createLink(controller: 'login',action: 'index')}" style="font-size:28px;color:  #0000ff">Link Sharing</a>
                    </div>

                    <div class="col-xs-3">
                        <div class="panel" id="search-panel" style="border:orangered;">
                            <div class="glyphicon glyphicon-search" style="color: #366EE0;"></div>

                            <div class="badge pull-right">
                                <div class="glyphicon glyphicon-remove" style="color: #366EE0;"></div>
                            </div>
                            <input type="text" placeholder="search" style="border:orangered;color: #366EE0;">
                        </div>
                    </div>


                    <div class="col-xs-5">
                        <g:if test="${session.user}">
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#myModal4"
                                    style="border:none;background:none;">
                                <div class="glyphicon glyphicon-comment" style="color: #366EE0;"></div></button>
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#myModal14"
                                    style="border:none;background:none;">
                                <div class="glyphicon glyphicon-envelope" style="color: #366EE0;"></div></button>
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#myModal2"
                                    style="border:none;background:none;">
                                <div class="glyphicon glyphicon-paperclip" style="color: #366EE0;"></div></button>
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#myModal3"
                                    style="border:none;background:none;">
                                <div class="glyphicon glyphicon-edit" style="color: #366EE0;"></div></button>
                        </g:if>
                        <div class=" pull-right">

                            <div class="dropdown" style="color: #366EE0;">
                                <button class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"
                                        style="border:none;color: #366EE0;">

                                    <div class="glyphicon glyphicon-user"
                                         style="font-size:40px;color: #366EE0;">

                                    </div>
                                    <span class="caret" style="color: #366EE0;"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="${createLink(controller: 'user',action: 'profile')}">Profile</a></li>
                           <g:if test="${session.user}">
                                    <li><a href="#">Users</a></li>
                                    <li><a href="${createLink(controller: 'user',action: 'topics')}">Topic</a></li>
                                    <li><a href="#">Post</a></li>
                                    <li><a href="/login/logout">Logout</a></li></g:if>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <div class="container-fluid">
        <div class="hide messageAlert" id="alert" style="text-align: center; height:50px;padding-top: 20px;"></div>
    </div>
    <g:render template="/topic/create"/>
    <g:render template="/topic/email"/>
    <g:render template="/resource/createDocumentResource"/>
    <g:render template="/resource/createLinkResource"/>
    <g:render template="/subscription/sendInvitation"/>
    <g:layoutBody/>


    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="bootstrap-theme.min.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <asset:javascript src="jquery-2.2.1.min.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:javascript src="application.js"/>

</body>
</html>