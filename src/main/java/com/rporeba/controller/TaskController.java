package com.rporeba.controller;

import com.rporeba.dto.TaskDto;
import com.rporeba.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by rporeba on 22.07.2016.
 */

@RestController
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/task/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDto>> getAllTasks() {

        log.info("> before findAllTasks");
        List<TaskDto> tasksDto = taskService.findAllTasks();
        log.info("< after findAllTasks");

        if (tasksDto.isEmpty()) {
            return new ResponseEntity<List<TaskDto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TaskDto>>(tasksDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {

        log.info("> before getTask id:{}", id);
        TaskDto taskDto = taskService.findTaskById(id);
        if (taskDto == null) {
            return new ResponseEntity<TaskDto>(HttpStatus.NOT_FOUND);
        }
        log.info("< after getTask id:{}", id);

        return new ResponseEntity<TaskDto>(taskDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/task/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto, UriComponentsBuilder builder) {

        log.info("> before createTask");

        taskService.saveTask(taskDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/task/{id}").buildAndExpand(taskDto.getId()).toUri());
        log.info("< after createTask");

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaskDto> deleteTask(@PathVariable("id") Long id) {

        log.info("> before deleteTask id:{}", id);
        TaskDto taskDto = taskService.findTaskById(id);
        if (taskDto == null) {

            return new ResponseEntity<TaskDto>(HttpStatus.NOT_FOUND);
        }
        taskService.deleteTaskById(id);
        log.info("< after deleteTask id:{}", id);

        return new ResponseEntity<TaskDto>(HttpStatus.NO_CONTENT);
    }

}
