

    <div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px;" >
        <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">Recent Shares
        </div>

        <div class="panel-body">
            <g:each in="${recentShares}" var="recent">
                <div class="col-xs-2">
                    <my:userImage userId="${recent.createdBy.id}" width="64px" height="64px"
                                  class="img img-responsive img-thumbnail"/>
                </div>

                <div class="col-xs-10">"${recent.createdBy}"<span class="text-muted">@Uday 5mins</span><span
                        class="pull-right"><a href="#">View Post</a></span>

                    <p>"${recent.name}"<br></p>

                    <div class="col-xs-2"><i class="fa fa-facebook-official" style="color: #366EE0;"></i>
                        <i class="fa fa-tumblr" style="color: #366EE0;"></i>
                        <i class="fa fa-google-plus" style="color:red;"></i></div>

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

