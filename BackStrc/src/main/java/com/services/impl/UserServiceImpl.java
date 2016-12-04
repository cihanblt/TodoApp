package com.services.impl;

import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cihan on 4.12.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;

    
}
