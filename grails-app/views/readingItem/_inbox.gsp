<div class="panel panel-primary" style="border:3px solid #0000ff;border-radius:8px">
    <div class="panel-heading" style="border-bottom:3px solid  #0000ff;float: left;width: 100%;">Inbox

        <div class="input-group" style="float: right">
            <g:textField type="text" class="form-control" placeholder="Search" name="search"
                         id="searchTopicId" style="width: inherit;"/>

            <g:submitButton name="Change" class="btn btn-primary"
                            value="Search"
                            onclick="searchTopic()"/>
        </div>
    </div>

    <div class="panel-body" id="topicContent" style="overflow-y: auto;height: 330px;">
        <g:render template="/readingItem/readingItemsInbox" model="[readingItems: readingItems]"/>
    </div>
</div>




%{--
        <g:textField name="search" id="searchTopicId" placeholder="Search here" style="color:red;" />
    <button class=" btn btn-default active"
            name="Change"
             value="Search"
            onclick="searchTopic()"
            style="border:solid #0000ff; border-radius:3px;width:100px;height:30px;color:red;"></button>--}%