
<g:each in="${subscribedTopics}" var="topics">
    <div class="col-xs-2">
        <my:userImage userId="${user.id}" width="64px" height="64px"
                      class="img img-responsive img-thumbnail"/>
    </div>

    <div class="hide" id="changeTopic">
        <g:textField class="form-control" id="textTopicName"
                     placeholder="type new topic name here . . ."
                     name="topicName"/>
        <span style="display: inline-block;width: 210px;">
            <g:actionSubmit class="form-control btn btn-warning active"
                            name="Change"
                            value="Change Topic Name"
                            onclick="changeTopicNameByButton(${topics.id})"/>
        </span>
        <span style="display: inline-block;width: 210px;">
            <g:actionSubmit class="form-control btn btn-danger active"
                            name="HideEdit"
                            value="Cancel"
                            onclick="hideEdit()"/>
        </span>
    </div>

    <div class="col-xs-10">${topics.name}<span class="text-muted"><br>@Uday<br>
        <span class="col-xs-6" style="padding-left:1px">Subscriptions</span>
        <span class="col-xs-6" style="padding-left:1px">Posts</span><br>
    </span>
        <span class="col-xs-6" style="color:blue;padding-left:1px"><my:subscriptionCount
                topicId="${topics.id}"/></span>
        <span class="col-xs-6" style="color:blue;padding-left:1px"><my:topicCount/></span>

    </div>
    <my:canUpdateTopic topicId="${topics.id}"/>
</g:each>
