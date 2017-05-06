package com.services.impl;

import com.models.Role;
import com.models.User;
import com.repositories.RoleRepository;
import com.repositories.UserRepository;
import com.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cihan on 4.12.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public boolean saveUser(User user) {
        try {
            List<Role> roles = new ArrayList<>();
            Role role1 = roleRepository.findOne(Long.valueOf(61));
            roles.add(role1);
            user.setRoles(roles);
            User u = userRepository.saveAndFlush(user);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User getUserByUsername(String username){
        return (User)userRepository.findByUserName(username);
     }

    @Override
    public User getUserOnAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = getUserByUsername(authentication.getName());
        return user;
    }
}
