<div class="panel panel-primary" style="border:3px solid #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;">Your Topics
    <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Search']" name="topicName"
              id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 330px;">
        <g:each in="${topics}" var="item">
            <div class="col-xs-2">
                <my:userImage  width="64px" height="64px"
                               class="img img-responsive img-thumbnail"/>
            </div>

            <div class="col-xs-10">Last Updated -${item.lastUpdated}<span class="text-muted">@${item.createdBy}</span><span class="pull-right"><a
                    href="#">${item}</a></span>

                <p>".${item.name}.."<br></p>

                <div class="col-xs-2"><i class="fa fa-facebook-official" style="color: #0000ff;"></i>
                    <i class="fa fa-tumblr" style="color: #0000ff;"></i>
                    <i class="fa fa-google-plus" style="color: red"></i>
                </div>
                %{--<div class="col-xs-10">"${item.isRead}"</div>--}%
                <div class="col-xs-2">%{--<my:isLinkOrDoc id="${item.resources.id}"/>--}%
                </div>

                <div class="col-xs-3"><a href="/" style="text-decoration:underline;font-size:10px">View full site</a>
                </div>

                <div class="col-xs-3">
                    %{--<a href="#" style="text-decoration:underline;font-size:10px">--}%
                    %{--<my:showMarkReadLink id="${item.id}"/>--}%

                    %{--</a>--}%
                    %{--<my:markAsRead id="${item.id}" isRead="${item.createdBy}" />--}%
                </div>

                <div class="col-xs-2">
                    %{--<g:link controller="topic" action="userPost" style="font-size: 10px" params= "[id: item.resource.id]">View Post</g:link>--}%
                </div>
            </div>

            <div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:silver"></div>
        </g:each>
    </div>
</div>