<%@ page import="com.ttnd.linksharing.Resource" %>
<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px;">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">Recent Shares
    </div>

    <div class="panel-body" style="overflow-y:auto;">

        <g:each in="${resources}" var="resource">
            <div class="col-xs-2 pull-left">
                <my:userImage userId="${resource.createdBy.id}" width="64px" height="64px"
                              class="img img-responsive img-thumbnail"/>
            </div>

            <div class="col-xs-10"><h5 style="color: #2a6496;">${resource.createdBy}</h5><span
                class="text-muted">@Uday 5mins</span><span
                class="pull-right"><a href="/">View Post</a></span>
            <br>

            <p><h6 style="color: #985f0d;">${resource.description}<br></p>
            <div class="col-xs-3 pull-right">
                <div class="col-xs-1"><i class="fa fa-facebook-official" style="color: #366EE0;"></i></div>

                <div class="col-xs-1"><i class="fa fa-tumblr" style="color: #366EE0;"></i></div>

                <div class="col-xs-1"><i class="fa fa-google-plus" style="color:red;"></i></div>
            </div>
            </div><br><br><br><br>
            <hr style="border-width:3px;padding:0px;border-color:silver">
        </g:each>
    </div>
</div>

