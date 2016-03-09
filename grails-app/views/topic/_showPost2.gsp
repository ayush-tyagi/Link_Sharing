<div class="panel panel-default" style="border:3px solid black;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid black;">Subscriptions
        <div class="pull-right">
            <a href="#" style="text-decoration:underline">View ALL</a>
        </div>
    </div>

    <div class="panel-body">
      <g:each in="${subscribedUsers}" var="users">
        <div class="col-xs-2">
            <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>
        </div>

        <div class="col-xs-10 pull-left"><a href="#" class="col-xs-8"
                                            style="text:decoration-underline">Grails</a></br></br>
            <span class="col-xs-4 text-muted">"${users}"</span>
            <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
            <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
            <span class="col-xs-4" style="color:blue;"><a href="#" style="text-decoration:underline">Unsubscribe</a>
            </span>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>
        </div>

        <div class="col-xs-4"><select class="pull-right form-control" id="sel1">
            <option>Public</option>
            <option>Private</option>
            <option>Global</option>
            <option>Mid</option>
        </select></div>

        <div class="col-xs-4"><select class="pull-right form-control" id="sel1">
            <option>Public</option>
            <option>Private</option>
            <option>Global</option>
            <option>Mid</option>
        </select></div>

        <div class="col-xs-4">

            <div class="glyphicon glyphicon-envelope"></div>

            <div class="glyphicon glyphicon-edit"></div>

            <div class="glyphicon glyphicon-trash"></div>

        </div><div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:black"></div>
         </br>
   </g:each>
     </div>
  </div>
