<div class="panel panel-primary" style="border:3px solid blue;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid #0000ff;">User Posts
    <g:select class="btn dropdown-toggle" data-toggle="dropdown"  noSelection="['':'Search']"  name="topicName" id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${subscribedTopics}"/>
    </div>

    <div class="panel-body" style="overflow-y: auto;height: 238px">
   <g:each in="${subscribedTopics}" var="topics">
        <div class="col-xs-2">
           %{--<span class="glyphicon glyphicon-user" style="font-size:60px;border:solid lightgrey;color: #366EE0;"></span>--}%

           <my:userImage userId="${topics.createdBy.id}" width="64px" height="64px"
                         class="img img-responsive img-thumbnail"/>
        </div>

        <div class="col-xs-10">${}<span class="text-muted">@Uday 5mins</span><span class="pull-right"><a
                href="#">Grails</a></span>

            <p>${}<br></p>

            <div class="col-xs-2"><i class="fa fa-facebook-official"  style="color: #0000ff;"></i>
                <i class="fa fa-tumblr"  style="color: #0000ff;"></i>
               <i class="fa fa-google-plus"  style="color: red;"></i></div>

            <div class="col-xs-2">
                <my:isLinkOrDoc id="${topics.id}"/>
            </div>

            <div class="col-xs-3"><a href="#" style="text-decoration:underline;font-size:10px">View full site</a></div>

            <div class="col-xs-3"><a href="#" style="text-decoration:underline;font-size:10px">Mark as Read</a></div>

            <div class="col-xs-2"><a href="#" style="text-decoration:underline;font-size:10px">View Post</a></div>
        </div>

        <div class="col-xs-12"><hr style="border-width:3px;padding:0px;border-color:silver"></div>
   </g:each>

    </div>

</div>
