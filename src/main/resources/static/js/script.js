/**
 * Created by rporeba on 25.07.2016.
 */


var selectedTaskId = null;

$(document).on("change", ".selectedTask", function () {

    selectedTaskId = $(this).val();

    $("#editTask").prop("disabled", false);
    $("#deleteTask").prop("disabled", false);

});


function getTask() {

    $("#editTask").click(function () {

        var id = $('#id').val();
        var description = $('#description').val();
        var details = $('#details').val();
        var created = $('#created').val();

        $.ajax({

            type: "GET",
            url: "/task/" + selectedTaskId,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: true,

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function (data) {

                id = JSON.stringify(data.id);
                created = JSON.stringify(data.created);

                $(".modal-body #id").val(id);
                $(".modal-body #description").val(data.description);
                $(".modal-body #details").val(data.details);
                $(".modal-body #created").val(data.created);

            },

            error: function () {
                alert('Error while response from server...');
            }
        });
    })
}


function getAllTasks() {

    $.ajax({
        type: "GET",
        url: "/task/",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',

        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },

        success: function (data) {
            $.each(data, function (i, tasksDto) {

                $("#tbody").append(
                    "<tr data-id='" + tasksDto.id + "'>" +
                        "<td>" + "<input class='selectedTask' type='radio' value='" + tasksDto.id + "'/>" + "</td>" +
                        "<td>" + tasksDto.id + "</td>" +
                        "<td>" + tasksDto.description + "</td>" +
                        "<td>" + tasksDto.details + "</td>" +
                        "<td>" + tasksDto.created + "</td>" +
                    "</tr>"
                );

                $('#taskModal').on('hidden.bs.modal', function () {
                    $(this).find('form')[0].reset();
                });

            });
        },

        error: function () {
            alert('Error while response from server...');
        }

    });

}


function deleteTask() {

    $("#deleteTask").click(function () {

        $.ajax({

            type: "DELETE",
            url: '/task/' + selectedTaskId,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function (data) {

                $("tr[data-id='" + selectedTaskId + "']").remove();
                $("#deleteTask").prop("disabled", true);
                $("#editTask").prop("disabled", true);

            },
            error: function () {
                alert('Error while response from server...');
            }
        });
    })

}


function datePicker() {

    $(function () {
        $("#created").datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: "dd/mm/yy",
        });
    });
}


function createTask() {

    $('#form').submit(function (event) {

        var json = new Object();

        json.id = $('#id').val();
        json.description = $('#description').val();
        json.details = $('#details').val();
        json.created = $('#created').val();

        $.ajax({
            type: "POST",
            url: $("#form").attr("action"),
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(json),
            async: true,

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function (response) {

                $("#taskTable").find("td").remove();
                $("#deleteTask").prop("disabled", true);
                $("#editTask").prop("disabled", true);

                $('#taskModal').on('hidden.bs.modal', function () {
                    $(this).find('form')[0].reset();
                });

                // $(function () {
                //     $('#taskModal').modal('toggle');
                // });

                getAllTasks();

            },

            error: function () {
                alert('Error while request from...');
            }

        });

        event.preventDefault();

    });

}


function validation() {

    $("#form").bootstrapValidator({

        fields: {
            id: {
                validators: {
                    integer: {
                        min: 1,
                        message: 'The value is not an integer',

                    }
                }
            },
            description: {
                validators: {
                    notEmpty: {
                        message: 'The description is required and cannot be empty'
                    },
                    stringLength: {
                        min: 5,
                        message: 'The content of description must be more than 5 characters long',
                    }
                }
            },
            details: {
                validators: {
                    notEmpty: {
                        message: 'The details is required and cannot be empty'
                    },
                    stringLength: {
                        min: 5,
                        message: 'The content of details must be more than 5 characters long',
                    }
                }
            },
            created: {
                excluded: false,
                validators: {
                    notEmpty: {
                        message: 'The date is required'
                    },
                    date: {
                        format: 'DD/MM/YYYY',
                        message: 'The date is not a valid'
                    }
                }
            }
        }
    });

}