<div class="panel panel-primary" style="border:3px solid #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">Subscriptions
        <div class="pull-right">
            <a href="#" style="text-decoration:underline;color:whitesmoke">View ALL</a>
        </div>
    </div>

    <div class="panel-body" id="subscribedTopics" style="overflow-y: auto;height: 300px;">
        <g:render template="/subscription/subscribedTopics" model="[subscribedTopics: subscribedTopics]"/>
    </div>
</div>
