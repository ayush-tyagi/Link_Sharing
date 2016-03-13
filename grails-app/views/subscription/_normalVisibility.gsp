<%@ page import="enums.L_Visibility" %>
<div class="row-fluid">

    <g:select class="btn dropdown-toggle" noSelection="['': 'Select visibility']"
              value="${visibility}" name="visibility"
              id="visibility-${topicId}"
              onchange="changeVisibility(${topicId})"
              style="width:200px;float:right;padding: 0px;" from="${enums.L_Visibility.values()}"/>

    <div class="col-xs-3"></div>

    <div style="float:right">
        <div class="col-xs-2">
            <div class="glyphicon glyphicon-envelope" style="color: #0000cc"></div>
        </div>
    </div>
</div>




%{--

<g:select class="btn dropdown-toggle" noSelection="['': 'Select Seriousness']" name="seriousness"
          id="seriousness-${subscription.id}"
          onchange="changeSeriousness(${subscription.id});" value="${subscription.seriousness}"
          style="width:200px;float:right;padding: 0px;" from="${Seriousness.values()}"/>--}%
