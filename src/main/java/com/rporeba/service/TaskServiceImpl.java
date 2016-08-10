package com.rporeba.service;

import com.rporeba.assembler.TaskDtoAssembler;
import com.rporeba.dto.TaskDto;
import com.rporeba.model.Task;
import com.rporeba.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rporeba on 22.07.2016.
 */

@Service
@Transactional
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Override
    //@Cacheable(value = "tasks", key = "#id")
    public TaskDto findTaskById(Long id) {

        Task task = taskRepository.findOne(id);
        TaskDto taskDto = TaskDtoAssembler.toDTO(task);
        return taskDto;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "tasks"/*, key = "#result.id"*/)
    public void saveTask(TaskDto taskDto) {

        Task task = TaskDtoAssembler.toEntity(taskDto);

        if (task.getId() == null) {
            taskRepository.save(task);

        } else {
            taskRepository.saveAndFlush(task);
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict(value = "tasks", key = "#id")
    public void deleteTaskById(Long id) {

        taskRepository.delete(id);

    }

    @Override
    public List<TaskDto> findAllTasks() {

        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> taskDtos = TaskDtoAssembler.listDto(tasks);
        return taskDtos;

    }

    @Override
    @CacheEvict(value = "tasks", allEntries = true)
    public void evictCache() {

    }
}
