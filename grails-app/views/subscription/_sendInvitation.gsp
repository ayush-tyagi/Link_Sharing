<div id="myModal14" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body">

                <g:uploadForm class="form-group"  controller="topic" action="invite">
                    <label class="control-label col-xs-4">Email*</label>

                    <div class="col-xs-8">
                        <g:textField type="email" name="email" class="form-control" id="link" placeholder="Email*"/>
                    </div>
<br>
                        <label class="col-xs-2">Topic:</label>

                        <div class="col-xs-8 pull-right">
                            <g:select class="btn dropdown-toggle" data-toggle="dropdown" name="topicName" id="doctopic"
                                      style="width:200px; " from="${subscribedTopics}"/>



                            <g:submitButton type="submit" name="Invite"
                                            class="form-control btn btn-default active" id="submit"
                                            style="color:red;border:solid black;border-radius:3px"/>
                        </div>



                </g:uploadForm>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
