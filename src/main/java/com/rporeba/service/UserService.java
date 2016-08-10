package com.rporeba.service;

import com.rporeba.dto.UserDto;
import com.rporeba.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by rporeba on 29.07.2016.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User createUser(UserDto userDto);

}
