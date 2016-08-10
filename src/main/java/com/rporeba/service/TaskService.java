package com.rporeba.service;

import com.rporeba.dto.TaskDto;

import java.util.List;

/**
 * Created by rporeba on 22.07.2016.
 */
public interface TaskService {

    TaskDto findTaskById(Long id);

    void saveTask(TaskDto taskDto);

    //void updateTask(TaskDto taskDto);

    void deleteTaskById(Long id);

    List<TaskDto> findAllTasks();

    void evictCache();
}
