<div class="panel panel-primary" style="border:3px solid blue;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">Topics
        <div class="pull-right">
            <a href="#" style="text-decoration:underline">View ALL</a>
        </div>
    </div>

    <div class="panel panel-default" >

        <div class="panel-body">

            <div class="col-xs-2">
                <my:userImage userId="${topic.createdBy.id}" width="64px" height="64px"
                              class="img img-responsive img-thumbnail"/>
            </div>

            <div class="col-xs-10">${topic.name}<span class="text-muted"><br>@Uday<br>
                <span class="col-xs-6" style="padding-left:1px">Subscriptions</span>
                <span class="col-xs-6" style="padding-left:1px">Topics</span><br>
            </span>
                <span class="col-xs-6" style="color:blue;padding-left:1px">50</span>
                <span class="col-xs-6" style="color:blue;padding-left:1px">50</span>

            </div>
        </div>
    </div>

</div>