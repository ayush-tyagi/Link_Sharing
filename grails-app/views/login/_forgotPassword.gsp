<div id="forgotPassword" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
            </div>

            <div class="modal-body">

                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="pull-left control-label col-xs-4" for="email">Email:</label>

                        <div class="col-xs-8">
                            <input type="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-xs-6">
                            <a href="#" style="text-decoration:underline;text-align:center"></a>
                        </label>

                        <div class="col-xs-4">
                            <g:submitButton type="submit" name="submit" formaction=""
                                            class="form-control btn btn-default active" id="submit"
                                            placeholder="Share"
                                            style="color:black;border:solid black;border-radius:7px"/>
                        </div>

                        <div class="col-xs-4">
                            <g:submitButton name="cancel" type="Login"
                                            class="form-control btn btn-default active" id="cancel"
                                            placeholder="Cancel"
                                            style="color:black;border:solid black;border-radius:7px"/>
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