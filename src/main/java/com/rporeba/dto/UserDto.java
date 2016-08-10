package com.rporeba.dto;

import com.rporeba.model.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by rporeba on 29.07.2016.
 */

@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 7340595475759583911L;

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

}
