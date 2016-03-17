<div class="panel panel-primary" style="border:3px solid blue;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">Topics
        <div class="pull-right">

            <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Search']" name="topicName"
                      id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
        </div>
    </div>

    <div class="panel panel-default">

        <div class="panel-body" style="overflow-y: auto;height: 232px;">

            <div class="createdTopicOfUser">
           <g:render template="/user/createdTopicsOfUser" model="[subscribedTopics:subscribedTopics]"/>
            </div>

        </div>
    </div>

</div>