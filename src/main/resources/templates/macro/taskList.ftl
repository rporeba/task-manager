<#import "/spring.ftl" as spring />
<#macro taskDtoList tasks>

<h2>Task Manager</h2>
<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Description</th>
        <#--<th>Creation date</th>-->
        </tr>
        </thead>
        <tbody id="taskDtoList">
            <#list tasks as task>
            <tr>
                <td><input class="selectedTask" type="radio" value="${task.id}" name="id"/></td>
                <td>${task.description}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>

</#macro>

