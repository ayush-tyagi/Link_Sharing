

    <div class="panel panel-default" style="border:3px solid black;border-radius:8px;" >
        <div class="panel-heading" style="border-bottom:3px solid black;">Recent Shares
        </div>

        <div class="panel-body">
            <g:each in="${recentShares}" var="recent">
                <div class="col-xs-2">
                    <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>
                </div>

                <div class="col-xs-10">"${recent.createdBy}"<span class="text-muted">@Uday 5mins</span><span
                        class="pull-right"><a href="#">View Post</a></span>

                    <p>"${recent.name}"<br></p>

                    <div class="col-xs-2"><i class="fa fa-facebook-official" style="color: #366EE0;"></i>
                        <i class="fa fa-tumblr" style="color: #366EE0;"></i>
                        <i class="fa fa-google-plus" style="color: #366EE0;"></i></div>

                    <div class="col-xs-2"><a href="#" style="text-decoration:underline;font-size:10px">Delete</a></div>

                    <div class="col-xs-2"><a href="#" style="text-decoration:underline;font-size:10px">Edit</a></div>

                    <div class="col-xs-2"><a href="#" style="text-decoration:underline;font-size:10px">Download</a>
                    </div>

                    <div class="col-xs-3"><a href="#"
                                             style="text-decoration:underline;font-size:10px">View Full Site</a>
                    </div>
                </div>
            </g:each>
        </div>
    </div>

