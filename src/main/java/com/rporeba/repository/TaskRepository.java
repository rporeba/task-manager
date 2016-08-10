package com.rporeba.repository;

import com.rporeba.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rporeba on 22.07.2016.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
