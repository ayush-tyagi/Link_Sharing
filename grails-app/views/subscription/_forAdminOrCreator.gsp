<div class="row-fluid">

    <a href="${createLink(controller: 'subscription', action: 'delete', params: [topicId: topicId])}">Unsubscribe</a>

    <div class="col-xs-4" style="float:right">
        <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Select']" name="topicName"
                  id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${enums.L_Visibility}"/>
    </div>

</div>
<div style="float:right">
<div class="col-xs-2">
    <div class="glyphicon glyphicon-envelope"></div>
</div>

<div class="col-xs-2">
    <div class="glyphicon glyphicon-edit"></div>
</div>

<div class="col-xs-2">
    <div class="glyphicon glyphicon-trash"></div>
</div>
</div>