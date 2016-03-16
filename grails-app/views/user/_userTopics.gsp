<div class="panel panel-primary" style="border:3px solid blue;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">Topics
        <div class="pull-right">

        <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Search']" name="topicName"
                  id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
        </div>
    </div>

    <div class="panel panel-default" >

        <div class="panel-body" style="overflow-y: auto;height: 232px;" >
            <g:each in="${subscribedTopics}" var="topics">
            <div class="col-xs-2">
                <my:userImage userId="${user.id}" width="64px" height="64px"
                              class="img img-responsive img-thumbnail"/>
            </div>
                <div class="hide" id="changeTopic" width="200px;">
                    <g:textField class="form-control" id="textTopicName"  name="topicName" value="Change"/>

                    <button class="form-control btn btn-primary active"
                                    name="Change"
                                    onclick="changeTopicNameByButton(${topics.id})"
                                    >

                </button>

                    <button class="form-control btn btn-primary active"
                            name="HideEdit"
                            onclick="hideEdit()"
                            ></button>


                </div>

            <div class="col-xs-10">${topics.name}<span class="text-muted"><br>@Uday<br>
                <span class="col-xs-6" style="padding-left:1px">Subscriptions</span>
                <span class="col-xs-6" style="padding-left:1px">Posts</span><br>
            </span>
                <span class="col-xs-6" style="color:blue;padding-left:1px"><my:subscriptionCount topicId="${topics.id}"/></span>
                <span class="col-xs-6" style="color:blue;padding-left:1px"><my:topicCount /></span>

            </div>
                <my:canUpdateTopic topicId="${topics.id}"/>
            </g:each>
        </div>
    </div>

</div>