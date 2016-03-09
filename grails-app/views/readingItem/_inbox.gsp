<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">Inbox
    <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Search']" name="topicName"
              id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 330px;">
     <g:each in="${readingItems}" var="item">
        <div class="col-xs-2">
            <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>
        </div>

        <div class="col-xs-10">${item.user}<span class="text-muted">@${item.user}</span><span class="pull-right"><a
                href="#">Grails</a></span>

            <p>".${item.resource}.."<br></p>

            <div class="col-xs-2"><i class="fa fa-facebook-official"></i>
                <i class="fa fa-tumblr"></i>
                0             <i class="fa fa-google-plus"></i>
            </div>
            %{--<div class="col-xs-10">"${item.isRead}"</div>--}%
            <div class="col-xs-2"><a href="#" style="text-decoration:underline;font-size:10px">Download</a>
            </div>

            <div class="col-xs-3"><a href="#" style="text-decoration:underline;font-size:10px">View full site</a>
            </div>

            <div class="col-xs-3">
                %{--<a href="#" style="text-decoration:underline;font-size:10px">--}%
                %{--<my:showMarkReadLink id="${item.id}"/>--}%

                %{--</a>--}%
                <my:markAsRead id="${item.resource.id}" isRead="${item.isRead}" />
            </div>

            <div class="col-xs-2">
                <g:link controller="topic" action="userPost" style="font-size: 10px" params= "[id: item.resource.id]">View Post</g:link>
            </div>
        </div>

        <div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:silver"></div>
     </g:each>
</div>
</div>