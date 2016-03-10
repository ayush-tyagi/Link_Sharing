<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">
        Login
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="loginHandler">
            <div class="form-group">
                <label class="control-label col-xs-4" >First Name:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="First Name" name="userName"/>
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
                    <g:submitButton class="form-control btn btn-primary active" name="submit" value="Login"
                                    style="color:black;border:solid  #0000ff;border-radius:3px;color:#d9edf7"/>
                </div>
            </div>

        </g:form>
    </div>
</div>
