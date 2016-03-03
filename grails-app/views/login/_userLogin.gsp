<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">
        Login
    </div>

    <div class="panel-body">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-xs-4" >Username:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" name="userName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" name="password" placeholder="Enter password"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-xs-6">
                    <a href="#" style="text-decoration:underline;text-align:center;">Forgot Password</a>
                </label>

                <div class="col-xs-6">
                    <g:submitButton class="form-control btn btn-default active" name="submit" value="Login"
                                    formaction="/LinkSharing/login/loginHandler"
                                    style="color:black;border:solid black;border-radius:7px"/>
                </div>
            </div>

        </form>
    </div>
</div>
