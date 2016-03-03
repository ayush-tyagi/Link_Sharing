<div id="myModal14" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-xs-4" >Email*</label>
                        <div class="col-xs-8">
                            <g:textField type="link" name="link" class="form-control" id="link" placeholder="Email*"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-2 ">

                         </div>
                        <label class="col-xs-2">Topic:</label>

                        <div class="col-xs-8">
                            <g:select class="btn dropdown-toggle" data-toggle="dropdown" name="topicName" id="doctopic" style="width:200px; " from="${subscribedTopics}"/>

                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-xs-4"></div>

                        <div class="col-xs-4">
                            <g:submitButton type="submit" name="submit" formaction="/subscription/sendInvitation"
                                            class="form-control btn btn-default active" id="submit" placeholder="Invite"
                                            style="color:black;border:solid black;border-radius:7px"/>
                        </div>

                        <div class="col-xs-4">
                            <g:submitButton name="cancel" type="Login" class="form-control btn btn-default active" id="cancel"
                                            placeholder="Cancel" style="color:black;border:solid black;border-radius:7px"/>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
