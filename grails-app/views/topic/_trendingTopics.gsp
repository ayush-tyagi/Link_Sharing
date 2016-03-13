<div class="panel panel-primary" style="border:3px solid blue;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">Trending Topics
        <div class="pull-right">
            <a href="#" style="text-decoration:underline">View ALL</a></div>
    </div>

    <div class="panel-body" id="subscribedTopics" style="overflow-y: auto;height: 238px">

        <g:each in="${trendingTopics}" var="topic">
            <div stye="overflow:scroll;color:lightgrey;">
                <div class="col-xs-2">
                    %{--<span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>--}%
                    <my:userImage userId="${topic.createdBy.id}" width="64px" height="64px"
                                  class="img img-responsive img-thumbnail"/>
                </div>

                <div class="col-xs-10 pull-left">
                    <div class="col-xs-8">"${topic.createdBy}"</div>
                    %{--<a href="/topic/topicShow" class="col-xs-4" style="text-decoration:underline">"${topic.name}"</a></br></br>--}%
                    <g:link controller="topic" action="show" params="[topicId: topic.id]">${topic.name}</g:link>
                    <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
                    <span class="col-xs-4" style="padding-left:1px">Topics</span><br><br>
                    %{-- <span class="col-xs-4" style="color:blue;"><a href="#" style="text-decoration:underline">Unsubscribe</a>
                     </span>--}%
                    <span class="col-xs-4" style="color:blue;padding-left:1px">${topic.count}</span>
                    <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>

                </div>
                <br><br><br><br>
                <div class="pull-right"><my:showSubscribe topicId="${topic.id}"/></div>
            <g:if test="${session.user}">
                <my:canUpdateTopic topicId="${topic.id}"/>
                %{--<my:showSeriousness topicId="${topic.id}"/>--}%

                </g:if>
                      <br>
                <div class="col-xs-7 pull-right">
                    <div class="col-xs-1"><i class="fa fa-facebook-official" style="color: #366EE0;"></i></div>
                    <div class="col-xs-1">     <i class="fa fa-tumblr" style="color: #366EE0;"></i></div>
                    <div class="col-xs-1">   <i class="fa fa-google-plus" style="color:red;"></i></div>
                </div>
                <hr style="border-width:3px;padding:0px;border-color:silver">
            </div>
        </g:each>
    </div>
</div>







