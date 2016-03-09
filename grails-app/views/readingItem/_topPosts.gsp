<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">
        Top Posts
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 250px;">
    <g:each in="${resources}" var="posts">
        <div class="col-xs-2">
            <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>
        </div>

        <div class="col-xs-10">"${posts}"<span class="text-muted">@Uday 5mins</span>
            <span class="pull-right"><a href="${createLink(controller: 'resource',action: 'show', params: [id:"${posts.id}"])}">"View Post"</a></span>

            <p>"${posts}"</br>
                <i class="fa fa-facebook-official"></i>
                <i class="fa fa-tumblr"></i>
                <i class="fa fa-google-plus"></i></p>
        </div><br>
       <br><br><br>
    </g:each>
    </div>
</div>
