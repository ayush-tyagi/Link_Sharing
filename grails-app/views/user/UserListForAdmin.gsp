<html>
<head>
    <meta name="layout" content="main">
    <title>Admin</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid">
    <div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px">
        <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">
            Users
            <g:form controller="user" action="admin">
                <div class="input-group" style="float: right">
                    <g:textField type="text" class="form-control" placeholder="Search" name="q"
                                 id="searchTopicId" style="width: inherit;"/>
                    <g:submitButton name="Change" class="btn btn-primary"
                                    value="Search"/>
                    <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="[null: 'Select']"
                              name="isActive" optionKey="type" value="${co?.isActive}"
                              style="width:200px;padding-right: 20px;float: right;"
                              from="${enums.Active.values()}"/>
                </div>
            </g:form>show

        </div>
    </div>

    <g:render template="/user/listUserForAdmin" model="[users: users]"/>

</div>

</div>
</body>
</html>