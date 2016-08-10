package com.rporeba.assembler;

import com.rporeba.dto.PersonDto;
import com.rporeba.model.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rporeba on 04.08.2016.
 */
public class PersonDtoAssembler {

    public static PersonDto toDto(Person person) {

        PersonDto personDto = new PersonDto();
        person = new Person();

        personDto.setIdP(person.getIdP());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());

        return personDto;
    }

    public static List<PersonDto> personDtoList(List<Person> personList) {

        return personList.stream().map(PersonDtoAssembler::toDto).collect(Collectors.toList());
    }

    public static Person toEntity(PersonDto personDto) {

        Person person = new Person();
        personDto = new PersonDto();

        person.setIdP(personDto.getIdP());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());

        return person;
    }
}
