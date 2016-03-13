<%@ page import="enums.L_Visibility; enums.Seriousness" %>
%{--<div class="col-xs-4" style="float: right" >--}%

<g:select class="btn dropdown-toggle" noSelection="['': 'Select visibility']"
          value="${visibility}" name="visibility"
          id="visibility-${topicId}"
          onchange="changeVisibility(${topicId})"
          style="width:200px;float:right;padding: 0px;" from="${enums.L_Visibility.values()}"/>

<g:select class="btn dropdown-toggle" noSelection="['': 'Select Seriousness']" name="seriousness"
          id="seriousness-${subscription.id}"
          onchange="changeSeriousness(${subscription.id});" value="${subscription.seriousness}"
          style="width:200px;float:right;padding: 0px;" from="${Seriousness.values()}"/>

%{--</div>--}%



<div style="float:right">
    <div class="col-xs-2">
        <div class="glyphicon glyphicon-envelope" style="color: #366EE0;"></div>
    </div>

    <div class="col-xs-2">
        <div class="glyphicon glyphicon-edit" style="color: #366EE0;" onclick="changeTopicName()"></div>
    </div>

    <div class="col-xs-2">
        <div class="glyphicon glyphicon-trash" style="color: #366EE0;" onclick="deleteTopic(${topicId})"></div>
    </div>
</div><br>