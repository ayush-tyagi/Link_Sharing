<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 25/2/16
  Time: 11:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>



    <style>
    a{
        text-decoration:underline;
    }
    #search-panel
    {
        border:solid black;
        border-radius:8px;
    }

    </style>
</head>

<body>

<!-- *******************************************************************
-->



<div class="container">
    <div class="col-xs-7">

        <div class="panel panel-default" style="border:3px solid black;border-radius:8px">
            <div class="panel-heading" style="border-bottom:3px solid black;">
                Recent Shares
            </div>

            <div class="panel-body">

                <div class="col-xs-2">
                    <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
                </div>

                <div class="col-xs-10">Uday Pratap Singh<span class="text-muted"> @Uday 5mins</span>
                    <span class="pull-right"><a href="#">Grails</a></span>
                    <p>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
                    "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."</br>
                        <i class="fa fa-facebook-official"></i>
                        <i class="fa fa-tumblr"></i>
                        <i class="fa fa-google-plus"></i>  </p>
                </div>

                <div class="col-xs-2">
                    <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
                </div>


                <div class="col-xs-10">Uday Pratap Singh<span class="text-muted"> @Uday 5mins</span>
                    <span class="pull-right"><a href="#">Grails</a></span>
                    <p>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
                    "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..." </br>
                        <i class="fa fa-facebook-official"></i>
                        <i class="fa fa-tumblr"></i>
                        <i class="fa fa-google-plus"></i>  </p>
                </div>
            </div>

        </div>


        <!-- *******************************************************************
-->


        <div class="panel panel-default" style="border:3px solid black;border-radius:8px">
            <div class="panel-heading" style="border-bottom:3px solid black;">
                Recent Shares
            </div>
            <div class="panel-body">

                <div class="col-xs-2">
                    <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
                </div>
                <div class="col-xs-10">Uday Pratap Singh<span class="text-muted"> @Uday 5mins</span>
                    <span class="pull-right"><a href="#">Grails</a></span>
                    <p>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
                    "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."</br>
                        <i class="fa fa-facebook-official"></i>
                        <i class="fa fa-tumblr"></i>
                        <i class="fa fa-google-plus"></i>  </p>
                </div>


            </div>

        </div>


    </div>

    <!-- *******************************************************************
-->




    <div class="col-xs-5">
        <div class="panel panel-default" style="border:3px solid black;border-radius:8px">
            <div class="panel-heading" style="border-bottom:3px solid black;">
                Login
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="email">Username:</label>
                        <div class="col-xs-8">
                            <g:textField class="form-control" name="userName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="pwd">Password:</label>
                        <div class="col-xs-8">
                            <g:passwordField class="form-control" name="password"  placeholder="Enter password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-6">
                            <a href="#" style="text-decoration:underline;text-align:centre">Forgot Password</a>
                        </label>
                        <div class="col-xs-6">
                            <g:submitButton class="form-control btn btn-default active" name="submit" value="Login" formaction="/LinkSharing/login/loginHandler" style="color:black;border:solid black;border-radius:7px"/>
                        </div>
                    </div>

                </form>
            </div>
        </div>



        <!-- *******************************************************************
-->




        <div class="panel panel-default" style="border:3px solid black;border-radius:8px">
            <div class="panel-heading" style="border-bottom:3px solid black;">
                Login
            </div>
            <div class="panel-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-xs-4" for="name">First Name:</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="name" placeholder="Enter email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="lastName">Last Name:</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="email">Email:</label>
                        <div class="col-xs-8">
                            <input type="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="pwd">Password:</label>
                        <div class="col-xs-8">
                            <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="rePwd">Confirm Password:</label>
                        <div class="col-xs-8">
                            <input type="password" class="form-control" id="repwd" placeholder="Renter password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="pull-left control-label col-xs-2" for="pwd">Photo:</label>
                        <div class="col-xs-7">
                            <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                        </div>
                        <div class="col-xs-3">
                            <input type="login" class="form-control btn btn-default active" id="pwd" placeholder="Browse" style="color:black;border:solid black;border-radius:7px">
                        </div>
                    </div>

                    <div class="form-group">


                        <label class="control-label col-xs-6">
                            <a href="#" style="text-decoration:underline;text-align:centre"></a>
                        </label>

                        <input type="login" class="col-xs-5 form-control btn btn-default active pull-left" id="pwd" placeholder="Register" style="font-color:black;border:solid black;border-radius:7px:;width:100px;">

                    </div>


                </form>


            </div>

        </div>

    </div>

</html>

</body>
</html>