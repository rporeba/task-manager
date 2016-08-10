package com.rporeba.repository;

import com.rporeba.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rporeba on 04.08.2016.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
