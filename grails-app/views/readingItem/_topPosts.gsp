<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">
        Top Posts
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 250px;">
    <g:each in="${resources}" var="posts">
        <div class="col-xs-2">
            <my:userImage userId="${posts.createdBy.id}" width="64px" height="64px"
                          class="img img-responsive img-thumbnail"/>
        </div>

        <div class="col-xs-10">"${posts.createdBy}"<span class="text-muted">@Uday 5mins</span>
            <span class="pull-right"><a href="${createLink(controller: 'resource',action: 'show', params: [id:"${posts.id}"])}">"View Post"</a></span>

            <p>"${posts.description}"</br>
                <i class="fa fa-facebook-official"></i>
                <i class="fa fa-tumblr"></i>
                <i class="fa fa-google-plus"></i></p>
        </div><br>
       <br><br><br>
    </g:each>
    </div>
</div>
