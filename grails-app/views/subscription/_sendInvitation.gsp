<div id="myModal14" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body">

                <g:form class="form-group">
                    <label class="control-label col-xs-4">Email*</label>

                    <div class="col-xs-8">
                        <g:textField type="email" name="email" class="form-control" id="email" placeholder="Email*"/>
                    </div>
                    <br>
                    <label class="col-xs-2">Topic:</label>

                    <div class="col-xs-8 pull-right">

                        <g:select class="btn dropdown-toggle" data-toggle="dropdown" name="topicName"
                                  id="topicNameSelect"
                                  style="width:200px; " from="${subscribedTopics}"/>

                        <g:actionSubmit value="Invite" type="submit"
                                        class="form-control btn btn-default active"
                                        id="inviteEmail"/>
                    </div>

                </g:form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

