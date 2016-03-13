<div id="myModal4" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="save">

                    <div class="form-group">
                        <label class="control-label col-xs-4" for="topicName">Name:</label>

                        <div class="col-xs-8">
                            <g:textField name="topicName" class="form-control" id="topicName" placeholder="Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-2 "></div><label class="col-xs-2" for="visibility">Visiblity:</label>

                        <div class="col-xs-8">
                            <g:select name="visibility" id="visibility" from="${enums.L_Visibility.values()}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-4"></div>

                        <div class="col-xs-4">
                            <g:actionSubmit class="form-control btn btn-default active" value="save" id="submit"
                                            formaction="/topic/save type="button" name="submit">
                            </g:actionSubmit>
                            %{--<input type="Login" class="form-control btn btn-default active" id="submit" placeholder="Save" style="color:black;border:solid black;border-radius:7px">--}%
                        </div>

                        <div class="col-xs-4">
                            <input type="button" class="form-control btn btn-default active" id="cancel" name="cancel"
                                   value="cancel" placeholder="Cancel"
                                   style="color:black;border:solid black;border-radius:7px">
                        </div>
                    </div>

                </g:form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</div>




