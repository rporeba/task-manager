<#include "macro/taskList.ftl"/>
<#include "modal.ftl"/>
<#import "layout.ftl" as myLayout>
<@myLayout.masterPage>

<script type="text/javascript">
    $(document).ready(function () {

        getAllTasks();
        deleteTask();
        getTask();
    });
</script>

<div class="jumbotron">

    <h2>Task Manager</h2>
    <div class="table-responsive">
        <table class="table" id="taskTable">
            <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Description</th>
                <th>Details</th>
                <th>Created</th>
            </tr>
            </thead>
            <tbody id="tbody">
            </tbody>
        </table>
    </div>

    <div class="nav">
        <button id="newTask" class="btn btn-success custom-width" data-toggle="modal" data-target="#taskModal">New
            Task
        </button>
        <button id="deleteTask" class="btn btn-danger" type="submit" disabled>Delete</button>
        <button id="editTask" class="btn btn-success custom-width" data-toggle="modal" data-target="#taskModal" disabled>Edit</button>
    </div>

</div>

</@myLayout.masterPage>