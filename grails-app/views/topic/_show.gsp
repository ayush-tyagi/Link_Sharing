
<div class="panel-body">
    <div class="row">
        <div class="col-xs-3">
            <my:userImage id="${topic.createdBy.id}"/>
            %{--<img src="" class="img img-thumbnail img-responsive image" />--}%
        </div>

        <div class="col-xs-9">
            <div class="row">
                <div class="col-xs-8">
                    <g:link controller = "user" action = "profile" params = "[id: topic.createdBy.id]">${topic.createdBy.name}</g:link>
                </div>

                <div class="col-xs-4"><a href="/topic/show?id=${topic.id}">${topic.name}</a></div>
            </div>

            <div class="row">
                <div class="col-xs-4 text-muted"><small>(@${topic.createdBy.userName})</small></div>

                <div class="col-xs-4 text-muted">Subscriptions</div>

                <div class="col-xs-4 text-muted">Post</div>
            </div>

            <div class="row">
                <my:showSubscribe id="${topic.id}"/>
                <div class="col-xs-4"><my:subscriptionCount topicId="${topic.id}"/></div>

                <div class="col-xs-4"><my:resourceCount topicId="${topic.id}"/></div>
            </div>
        </div>
    </div>
</div>

<g:if test="${session.user}">

    <div class="panel panel-footer">
        <div class="row">

            <my:canUpdateTopic id="${topic.id}">

                <div class="col-xs-3">
                    %{--<ls:showVisibility id="${topic.id}"/>--}%
                </div>

                <div class="col-xs-3">
                    <a href="topic/update/${topic.id}"><ins>Edit</ins></a>
                </div>


                <div class="col-xs-3">
                    <a href="topic/delete/${topic.id}"><ins>Delete</ins></a>
                </div>

            </my:canUpdateTopic>

        %{--<ls:canDeleteTopic id="${topic.id}"/>--}%
            <div class="col-xs-3">
                %{--<ls:showSeriousness id="${topic.id}"/>--}%
            </div>

        </div>
    </div>

</g:if>