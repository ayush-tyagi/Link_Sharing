%{--<g:if test="${!readingitems}">
    <h3 style="color: red;">Oops no matches found </h3>
</g:if>

<g:else>--}%
<g:each in="${readingItems}" var="item">
    <div class="col-xs-2">
        <my:userImage width="64px" height="64px"
                      class="img img-responsive img-thumbnail"/>
    </div>

    <div class="col-xs-10">${item.user}<span class="text-muted">@${item.user}</span><span class="pull-right"><a
            href="#">${item}</a></span>

        <p>".${item.resource}.."<br></p>

        <div class="col-xs-2"><i class="fa fa-facebook-official" style="color: #0000ff;"></i>
            <i class="fa fa-tumblr" style="color: #0000ff;"></i>
            <i class="fa fa-google-plus" style="color: red"></i>
        </div>
        %{--<div class="col-xs-10">"${item.isRead}"</div>--}%
        <div class="col-xs-2"><my:isLinkOrDoc id="${item.resource.id}"/>
        </div>

        <div class="col-xs-3"><a href="/" style="text-decoration:underline;font-size:10px">View full site</a>
        </div>

        <div class="col-xs-3">
            %{--<a href="#" style="text-decoration:underline;font-size:10px">--}%
            %{--<my:showMarkReadLink id="${item.id}"/>--}%

            %{--</a>--}%
            <my:markAsRead id="${item.resource.id}" isRead="${item.isRead}"/>
        </div>

        <div class="col-xs-2">
            <g:link controller="topic" action="userPost" style="font-size: 10px"
                    params="[id: item.resource.id]">View Post</g:link>
        </div>
    </div>

    <div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:silver"></div>
</g:each>
%{--</g:else>--}%