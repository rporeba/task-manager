package com.rporeba.service;

import com.rporeba.model.CurrentUser;

/**
 * Created by rporeba on 29.07.2016.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
