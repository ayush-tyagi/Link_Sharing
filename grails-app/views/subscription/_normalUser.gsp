<div class="row-fluid">
    <a href="${createLink(controller: 'subscription', action: 'save', params: [topicId: topicId])}">Subscribe</a>


    <div class="col-xs-4" style="float:right">
        <g:select class="btn dropdown-toggle" data-toggle="dropdown" noSelection="['': 'Select']" name="topicName"
                  id="sdsdh" optionKey="${id}" style="width:200px;float:right;padding: 0px;" from="${}"/>
    </div>
</div>
<div >
    <div class="col-xs-4" style="float: right">
        <div class="glyphicon glyphicon-envelope"></div>
    </div>
</div>