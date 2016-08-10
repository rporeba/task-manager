package com.rporeba.service;

import com.rporeba.model.CurrentUser;
import com.rporeba.model.Role;
import com.rporeba.service.CurrentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rporeba on 29.07.2016.
 */
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {

        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);

        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }
}
