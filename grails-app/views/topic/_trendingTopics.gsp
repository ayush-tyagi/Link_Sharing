
<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 26/2/16
  Time: 12:09 AM
--%>

<div class="col-xs-5">
    <div class="panel panel-default" style="border:3px solid black;border-radius:8px">
        <div class="panel-heading" style="border-bottom:3px solid black;">Trending Topics
            <div class="pull-right">
                <a href="#" style="text-decoration:underline">View ALL</a></div>
        </div>

        <div class="panel-body" style="overflow-y: auto;height: 250px">

            <g:each in="${trendingTopics}" var="topic">
                <div stye="overflow:scroll">
                    <div class="col-xs-2">
                        <span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>
                    </div>

                    <div class="col-xs-10 pull-left">
                        <div class="col-xs-8">"${topic.createdBy}"</div>
                        %{--<a href="/topic/topicShow" class="col-xs-4" style="text-decoration:underline">"${topic.name}"</a></br></br>--}%
                       <g:link controller="topic" action="show" params="[topicId:topic.id]"> ${topic.name}</g:link>
                        <span class="col-xs-4 text-muted">@"${topic.createdBy}"</span>
                        <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
                        <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
                        <span class="col-xs-4" style="color:blue;"><a href="#" style="text-decoration:underline">Unsubscribe</a>
                        </span>
                        <span class="col-xs-4" style="color:blue;padding-left:1px">${topic.count}</span>
                        <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>

                    </div>
                    <br><br><br><br>
                    <hr style="border-width:3px;padding:0px;border-color:black">
                </div>
            </g:each>
        %{--<div class="col-xs-2">--}%
        %{--<span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>--}%
        %{--</div>--}%

        %{--<div class="col-xs-10 pull-left">--}%
        %{--</br>--}%
        %{--<div class="col-xs-8">Uday Pratap Singh</div>--}%
        %{--<a href="#" class="col-xs-4" style="text-decoration : underline">Grails</a></br></br>--}%
        %{--<span class="col-xs-4 text-muted"> @Uday</span>--}%
        %{--<span class="col-xs-4" style="padding-left:1px">Subscriptions</span>--}%
        %{--<span class="col-xs-4" style="padding-left:1px">Topics</span><br>--}%
        %{--<span class="col-xs-4" style="color:blue;">--}%
        %{--<a href="#" style="text-decoration:underline">Subscribe--}%
        %{--</a></span>--}%
        %{--<span class="col-xs-4" style="color:blue;padding-left:1px">50</span>--}%
        %{--<span class="col-xs-4" style="color:blue;padding-left:1px"> 50</span>--}%

        %{--</div>--}%


        %{--<div class="col-xs-4"></div>--}%

        %{--<div class="col-xs-4"></div>--}%

        %{--<div class="col-xs-4">--}%
        %{--<a href="#" class="col-xs-4" style="text-decoration:underline">Edit</a>--}%
        %{--<a href="#" class="col-xs-4" style="text-decoration:underline">Delete</a>--}%
        %{--</div>--}%

        </div>
    </div>
</div>







%{--<div class="col-xs-5">--}%
    %{--<div class="panel panel-default" style="border:3px solid black;border-radius:8px">--}%
        %{--<div class="panel-heading" style="border-bottom:3px solid black;">Trending Topics--}%
            %{--<div class="pull-right">--}%
                %{--<a href="#" style="text-decoration:underline">View ALL</a></div>--}%
        %{--</div>--}%
        %{--<div class="panel-body">--}%

            %{--<div class="col-xs-2">--}%
                %{--<span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>--}%
            %{--</div>--}%

            %{--<div class="col-xs-10 pull-left">--}%
                %{--<div class="col-xs-8">Uday Pratap Singh</div>--}%
                %{--<a href="#" class="col-xs-4" style="text-decoration:underline">Grails</a></br></br>--}%
                %{--<span class="col-xs-4 text-muted"> @Uday</span>--}%
                %{--<span class="col-xs-4" style="padding-left:1px">Subscriptions</span>--}%
                %{--<span class="col-xs-4" style="padding-left:1px">Topics</span><br>--}%
                %{--<span class="col-xs-4" style="color:blue;"><a href="#" style="text-decoration:underline">Unsubscribe</a></span>--}%
                %{--<span class="col-xs-4" style="color:blue;padding-left:1px">50</span>--}%
                %{--<span class="col-xs-4" style="color:blue;padding-left:1px"> 50</span>--}%

            %{--</div>--}%
            %{--<br><br><br><br>--}%
            %{--<hr style="border-width:3px;padding:0px;border-color:black">--}%
            %{--<div class="col-xs-2">--}%
                %{--<span class="glyphicon glyphicon-user" style="font-size:60px;border:solid black;"></span>--}%
            %{--</div>--}%

            %{--<div class="col-xs-10 pull-left">--}%
            %{--</br>--}%
                %{--<div class="col-xs-8">Uday Pratap Singh</div>--}%
                %{--<a href="#" class="col-xs-4" style="text-decoration : underline">Grails</a></br></br>--}%
                %{--<span class="col-xs-4 text-muted"> @Uday</span>--}%
                %{--<span class="col-xs-4" style="padding-left:1px">Subscriptions</span>--}%
                %{--<span class="col-xs-4" style="padding-left:1px">Topics</span><br>--}%
                %{--<span class="col-xs-4" style="color:blue;"><a href="#"--}%
                                                              %{--style="text-decoration:underline">Subscribe</a></span>--}%
                %{--<span class="col-xs-4" style="color:blue;padding-left:1px">50</span>--}%
                %{--<span class="col-xs-4" style="color:blue;padding-left:1px"> 50</span>--}%

            %{--</div>--}%


            %{--<div class="col-xs-4"></div>--}%

            %{--<div class="col-xs-4"></div>--}%

            %{--<div class="col-xs-4">--}%
                %{--<a href="#" class="col-xs-4" style="text-decoration:underline">Edit</a>--}%
                %{--<a href="#" class="col-xs-4" style="text-decoration:underline">Delete</a>--}%
            %{--</div>--}%


        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%

