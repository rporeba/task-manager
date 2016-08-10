package com.rporeba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rporeba on 2016-07-23.
 */
@Getter
@Setter
public class TaskDto implements Serializable {


    private static final long serialVersionUID = 6193628833809642857L;

    private Long id;

    private String description;

    private String details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date created;

    private PersonDto personDto = new PersonDto();

    public TaskDto(){personDto = new PersonDto();};


}
