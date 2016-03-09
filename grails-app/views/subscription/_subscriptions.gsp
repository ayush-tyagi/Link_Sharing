<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">Subscriptions
        <div class="pull-right">
            <a href="#" style="text-decoration:underline">View ALL</a>
        </div>
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 238px">
        <g:each in="${subscribedTopics}" var="topics">
            <div class="col-xs-2">
                <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
            </div>

            <div class="col-xs-10 pull-left"><a href="#" class="col-xs-8"
                                                style="text:decoration-underline">Grails</a></br></br>
                <span class="col-xs-4 text-muted">"${topics}"</span>
            <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
            <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>
            </div>

            <div class="col-xs-4"></div>

               <my:showSubscribe topicId="${topics.id}"/>
           <div class="col-xs-12"><hr style="border-width:1px;padding:0px;border-color:silver"></div>
            </br>
        </g:each>
    </div>
</div>
