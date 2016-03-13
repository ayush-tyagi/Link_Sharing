<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:5px">

    <div class="panel-body">
        <div class="col-xs-2">
            <my:userImage userId="${user.id}" width="64px" height="64px"
                          class="img img-responsive img-thumbnail"/>
        </div>

<div class="col-xs-8">
            <h2>${user.userName}</h2>
            <br><br>
            <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
            <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
            <span class="col-xs-4" style="color:blue;padding-left:1px">${numberOfSubscription}</span>
            <span class="col-xs-4" style="color:blue;padding-left:1px"><my:topicCount /></span>




    </div>
</div></div>