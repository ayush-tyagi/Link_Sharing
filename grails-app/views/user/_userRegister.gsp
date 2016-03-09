<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">
        Register
    </div>

    <div class="panel-body">
        <form class="form-horizontal">

            <div class="form-group">
                <label class="control-label col-xs-4" >First Name:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Enter First Name" name="firstName" />
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left control-label col-xs-4" >Last Name:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Last Name" name="lastName"/>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4" >Email:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Email" name="email_Id"/>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4" >UserName:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="UserName" name="userName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" placeholder="Password" name="password"/>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Confirm Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" placeholder="Confirm Password" name="confirmPassword"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left control-label col-xs-2" for="pwd">Photo:</label>

                <div class="col-xs-7">
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                </div>

                <div class="col-xs-3">
                    <input type="login" class="form-control btn btn-default active" id="pwd"
                           placeholder="Browse" style="color:black;border:solid black;border-radius:7px">
                </div>
            </div>

            <div class="form-group">

                <label class="control-label col-xs-6">
                    <a href="#" style="text-decoration:underline;text-align:center"></a>
                </label>

                <g:submitButton class="form-control btn btn-default active" name="submit" value="Register"
                                formaction="/user/register"
                                style="color:black;border:solid black;border-radius:7px"/>

            </div>

        </form>

    </div>

</div>
