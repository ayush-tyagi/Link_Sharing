<div class="panel panel-primary" style="border:3px solid #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">User Subscriptions
        <div class="pull-right">
            <a href="#" style="text-decoration:underline;color:whitesmoke">View ALL</a>
        </div>
    </div>

    <div class="panel-body" id="subscribedTopics" style="overflow-y: auto;height: 300px;">
        <g:each in="${subscribedTopics}" var="topic">
            <div class="col-xs-2">
                <my:userImage  width="64px" height="64px"
                               class="img img-responsive img-thumbnail"/>
            </div>

            <div class="col-xs-10 pull-right"><a href="#" class="col-xs-8"
                                                style="text:decoration-underline">Grails</a></br></br>
                <span class="col-xs-4 text-muted pull-right">"${topic}"</span><br>
            <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
            <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
            <span class="col-xs-4" style="color:blue;padding-left:1px">
                <my:subscriptionCount topicId="${topic.id}"/></span>
            <span class="col-xs-4" style="color:blue;padding-left:1px">
                <my:topicCount/></span>
            </div>

            <div class="col-xs-4 pull-right">

                <my:showSubscribe topicId="${topic.id}"/></div>
            <my:showSeriousness topicId="${topic.id}"/>
            <div class="col-xs-12"><hr style="border-width:1px;padding:0px;border-color:silver"></div>
            </br>
        </g:each>
    </div>
</div>
