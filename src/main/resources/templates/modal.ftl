<#import "layout.ftl" as myLayout>
<#import "/spring.ftl" as spring />
<#include "macro/macros.ftl"/>


<@myLayout.masterPage>



<script type="text/javascript">

    $(document).ready(function() {

        createTask();
        datePicker();
        //validation();
    });

</script>



<div class="modal fade" id="taskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Create new task</h4>
                <div id="taskFormResponse" class="green"></div>
            </div>

            <div class="modal-body">

                <form id="form" role="form" class="form-horizontal" method="post" action="/task/">

                    <div class="form-group">
                        <div class="col-sm-9">
                            <input type="hidden" class="form-control" id="id" name="id" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">Description</label>
                       <div class="col-sm-9">
                            <input type="text" class="form-control" id="description" name="description" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="details" class="col-sm-2 control-label">Details</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="details" name="details" value="" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="created" class="col-sm-2 control-label">Creation date</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="created" name="created" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-9 col-md-offset-3">
                            <div id="messages"></div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</@myLayout.masterPage>