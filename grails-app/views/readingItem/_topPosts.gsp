<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">
        Top Posts
    </div>
<g:each in="${resources1}" var="posts">
    <div class="panel-body">

        <div class="col-xs-2">
            <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
        </div>

        <div class="col-xs-10">"${posts}"<span class="text-muted">@Uday 5mins</span>
            <span class="pull-right"><a href="#">""</a></span>

            <p>"${posts}"</br>
                <i class="fa fa-facebook-official"></i>
                <i class="fa fa-tumblr"></i>
                <i class="fa fa-google-plus"></i></p>
        </div>

    </div>

</g:each>

</div>
