<div class="panel panel-primary" style="border:3px solid #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">
        Register
    </div>

    <div class="panel-body">
        %{--<g:hasErrors bean="${user}">
            <div class="alert alert-danger">
                <g:renderErrors bean="${user}" as="list"/>
            </div>
        </g:hasErrors>--}%
        <g:uploadForm class="form-horizontal" controller="user" action="register">

            <div class="form-group">
                <label class="control-label col-xs-4">First Name:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Enter First Name" value="${user?.firstName}" name="firstName"/>
                </div>

                <div class="" role="alert">

                    <span style="color: red;float:right;">
                        <g:fieldError field="firstName" bean="${user}">
                        </g:fieldError></span>
                </div>
            </div>



            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Last Name:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Last Name" value="${user?.lastName}" name="lastName"/>
                </div>

                <div class="" role="alert">
                    <span style="color: red;float:right;"><g:fieldError field="lastName" bean="${user}"/></span>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Email:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control" placeholder="Email" name="email_id" value="${user?.email_id}"/>
                </div>

                <div class="" role="alert">
                    <span style="color: red;float:right;"><g:fieldError field="email_id" bean="${user}"/></span>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4">UserName:</label>

                <div class="col-xs-8">
                    <g:textField class="form-control"  name="userName" value="${user?.userName}" placeholder="UserName"/>
                </div>

                <div class="" role="alert">
                    <span style="color: red;float:right;"><g:fieldError field="userName" bean="${user}"/></span>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" placeholder="Password" value="${user?.password}" name="password"/>
                </div>

                <div class="" role="alert">
                    <span style="color: red;float:right;"><g:fieldError field="password" bean="${user}"/></span>
                </div>
            </div>



            <div class="form-group">
                <label class="pull-left control-label col-xs-4">Confirm Password:</label>

                <div class="col-xs-8">
                    <g:passwordField class="form-control" placeholder="Confirm Password" value="${user?.confirmPassword}" name="confirmPassword"/>
                </div>

                <div class="" role="alert">
                    <span style="color: red;float:right;"><g:fieldError field="confirmPassword" bean="${user}"/></span>
                </div>
            </div>


            <div class="form-group">
                <label class="pull-left control-label col-xs-2" for="photo">Photo:</label>


                <div class="col-xs-3">
                    <input type="file" id="photo"
                           placeholder="Browse" name="photo">
                </div>
            </div>


            <div class="form-group">

                <label class="control-label col-xs-6">
                    <a href="#" style="text-decoration:underline;text-align:center"></a>
                </label>
                <div class="col-xs-12"><div class="col-xs-4"></div>
                    <div class="col-xs-8">
                <g:submitButton class="form-control btn btn-primary active" name="submit" value="Register"
                                style="color:black;border:solid  #0000ff;border-radius:3px;color:whitesmoke ; "/>
                    </div>
            </div>
            </div>

        </g:uploadForm>

    </div>

</div>
