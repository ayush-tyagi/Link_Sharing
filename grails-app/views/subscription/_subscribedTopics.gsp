<g:each in="${subscribedTopics}" var="topics">
    <div class="col-xs-2">
        <my:userImage  width="64px" height="64px"
                       class="img img-responsive img-thumbnail"/>
    </div>

    <div class="col-xs-10 pull-right"><a href="#" class="col-xs-8"
                                        style="text:decoration-underline">Grails</a></br></br>
        <span class="col-xs-4 text-muted pull-right">
    <a href="${createLink(controller: 'user' ,action:'publicProfile' ,params: [id:topics.id])}">
    ${topics.name} </a></span><br>
    <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
    <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
    <span class="col-xs-4" style="color:blue;padding-left:1px"><my:subscriptionCount topicId="${topics.id}"/></span>
    <span class="col-xs-4" style="color:blue;padding-left:1px"><my:topicCount/></span>
    </div>

    <div class="col-xs-4 pull-right">

    <my:showSubscribe topicId="${topics.id}"/></div>
    <my:showSeriousness topicId="${topics.id}"/>
    <div class="col-xs-12"><hr style="border-width:1px;padding:0px;border-color:silver"></div>
    </br>
</g:each>