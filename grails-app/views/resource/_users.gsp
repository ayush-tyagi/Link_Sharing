<div class="panel panel-primary" style="border:3px solid  #0000ff;border-radius:5px">

    <div class="panel-body">
        <div class="col-xs-2">

            <my:userImage userId="${resource.createdBy.id}" width="64px" height="64px"
                          class="img img-responsive img-thumbnail"/>
        </div>

        <div class="col-xs-10">${resource?.createdBy?.userName}<span class="text-muted"><br>@Uday<br></span>


            <g:form class="form-horizontal" controller="resourceRating" action="save" params="[id: resource.id]">
                <div class="col-xs-4" style="float: left">

                    <g:select name="score" from="${[1, 2, 3, 4, 5]}" value="${score}"
                              noSelection="['': '-Select vote-']"/>

                </div><br>

                <div class="col-xs-4" style="">
                    <g:submitButton class="form-control btn btn-default active" name="submit" value="Vote"
                                    style="color:blue;border:solid #b2d1ff;border-radius:2px"/>

                </div>
            </g:form>


            <br><br>
            <span class="col-xs-4" style="padding-left:1px">Subscriptions</span>
            <span class="col-xs-4" style="padding-left:1px">Topics</span><br>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>
            <span class="col-xs-4" style="color:blue;padding-left:1px">50</span>

        </div>
        <h3>Description:</h3>
        <p>  ${resource.description}</p>
        <div class="col-xs-12">
            <div class="col-xs-3"><i class="fa fa-facebook-official" style="color: #0000ff;"></i></div>

            <div class="col-xs-3"><i class="fa fa-tumblr"  style="color: #0000ff;"></i></div>

            <div class="col-xs-3"><i class="fa fa-google-plus" style="color: red"></i>
            </div>
        </div>
        %{--<div class="col-xs-10">"${item.isRead}"</div>--}%
        <br>



        <div class="hide" id="changeDescription" width="200px;">
            <g:textField class="form-control" id="textDescription"  name="topicName"/>

            <button class="form-control btn btn-primary active"
                    name="Change"
                    onclick="changeResourceDescription(${resource.id})"
                    style="color:black;border:solid #0000ff;border-radius:3px;color:whitesmoke;"></button>
        </div>


        <div class="col-xs-3"><my:canDeleteResource id="${resource.id}"/>
        </div>

        <div class="col-xs-3">
            <div class="glyphicon glyphicon-edit" style="color: #366EE0;" onclick="unhideResourceDescription()"></div>
        </div>

        <div class="col-xs-3"><my:isLinkOrDoc id="${resource.id}"/>
        </div>

        <div class="col-xs-3"><a href="#" style="text-decoration:underline;font-size:13px">View full site</a>
        </div>

    </div>
</div>




