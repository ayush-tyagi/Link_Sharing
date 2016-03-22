<script>
    window.___gcfg = {
        lang: 'en-US',
        parsetags: 'onload'
    };
</script>
<script src="https://apis.google.com/js/platform.js" async defer></script>


%{--................................gmail ends..................................--}%


%{--...................................................fb ends.......................--}%



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

        <p id="RetainedDescription">${item.resource.topic.name}<br></p>


        %{--<div class="col-xs-10">"${item.isRead}"</div>--}%
        <div class="col-xs-2"><my:isLinkOrDoc id="${item.resource.id}"/>
        </div>

        <div class="col-xs-3"><a href="/" style="text-decoration:underline;font-size:10px">View full site</a>
        </div>

        <div class="col-xs-3" id="markAsRead">
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

    <div class="col-xs-2">
        <div class="fb-share-button"
             data-href="${request.getRequestURL().toString()}" data-layout="button_count">

        </div>
    </div>

    <div class="col-xs-3">
        <i class="fa fa-tumblr" style="color: #0000ff;"></i>
    </div>
%{--<div class="g-plus" data-action="share"></div>--}%
    <div class="col-xs-3">
    <input type="button"
           class="g-interactivepost"
           data-contenturl="https://www.google.co.in/?gfe_rd=cr&ei=ZPrwVqGSL8iL8Qel-4HIBA"
           data-contentdeeplinkid="/pages"
           data-clientid="564475723789-vsc4mk1dph6014pv28hknfjqgchm3ipi.apps.googleusercontent.com"
           data-cookiepolicy="single_host_origin"
           data-prefilltext="Want to Say Something..."
           data-calltoactionlabel="CREATE"
           data-calltoactionurl="https://www.google.co.in/?gfe_rd=cr&ei=ZPrwVqGSL8iL8Qel-4HIBA"
           data-calltoactiondeeplinkid="/pages/create"

           value="Share on Google +"
           style="color:white;background-color: #dd4b39;border-radius: 34px;">
    </input>

    </div>

    <div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:silver"></div>
</g:each>
%{--</g:else>--}%