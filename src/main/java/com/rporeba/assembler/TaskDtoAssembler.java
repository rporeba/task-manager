package com.rporeba.assembler;

import com.rporeba.dto.TaskDto;
import com.rporeba.model.Task;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rporeba on 2016-07-23.
 */
public class TaskDtoAssembler {

    public static TaskDto toDTO(Task task) {

        TaskDto taskDto = new TaskDto();

        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setCreated(task.getCreated());
        taskDto.setDetails(task.getDetails());
        taskDto.setPersonDto(PersonDtoAssembler.toDto(task.getPerson()));

        return taskDto;

    }

    public static List<TaskDto> listDto(List<Task> taskList) {

        return taskList.stream().map(TaskDtoAssembler::toDTO).collect(Collectors.toList());

    }

    public static Task toEntity(TaskDto taskDto) {

        Task task = new Task();

        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setCreated(taskDto.getCreated());
        task.setDetails(taskDto.getDetails());
        task.setPerson(PersonDtoAssembler.toEntity(taskDto.getPersonDto()));

        return task;

    }
}


