<div id="myModal3" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body">


                <g:uploadForm class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-xs-4" >Document:</label>
                        <div class="col-xs-8">

                                <input type="file" id="doc" name="filePath" required>
                        </div>
                    </div>
                    <div  class="form-group">
                        <label class="control-label col-xs-4"  >Description:</label>
                        <div class="col-xs-8">
                            <g:textArea name="description"  id="description"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-4">Topic:</label>
                        <div class="col-xs-8">
                            <g:select class="btn dropdown-toggle" data-toggle="dropdown" name="topicName" id="doctopic" style="width:200px; " from="${topicNames}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-4"></div>
                        <div class="col-xs-4">
                            <g:actionSubmit value="save" type="submit" name="submit"  class="form-control btn btn-default active" formaction="/LinkSharing/resource/saveDocumentResource" id="submit" placeholder="Share" style="color:black;border:solid black;border-radius:7px"/>
                        </div>
                        <div class="col-xs-4">
                        <g:actionSubmit name="cancel" value="cancel" class="form-control btn btn-default active" id="submit" type="cancel" placeholder="Cancel" style="color:black;border:solid black;border-radius:7px"/>
                    </div>
                    </div>

                </g:uploadForm>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>


    </div>
</div>
