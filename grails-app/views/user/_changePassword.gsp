<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">
    Change Password
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="changePassword">


            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" name="password" placeholder="Enter password"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Confirm Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" name="confirmPassword" placeholder="Confirm password"/>
                </div>
            </div>

            <div class="form-group">

                <div class="col-xs-6">
                    <g:submitButton class="form-control btn btn-primary active" name="submit" value="Login"
                                    style="color:black;border:solid  #0000ff;border-radius:3px;color:#d9edf7"/>
                </div>
            </div>

        </g:form>
    </div>
</div>
