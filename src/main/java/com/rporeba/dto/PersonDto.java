package com.rporeba.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by rporeba on 04.08.2016.
 */

@Getter
@Setter
public class PersonDto implements Serializable{

    private static final long serialVersionUID = -5849641733579969506L;

    private Long idP;

    private String firstName;

    private String lastName;


}
