package com.services;

import com.models.User;

/**
 * Created by cihan on 4.12.2016.
 */
public interface UserService {

    public boolean saveUser(User user);

    public User getUserByUsername(String username);

    public User getUserOnAuthentication();
}
