package com.services.impl;

import com.models.Role;
import com.models.User;
import com.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by cihanblt on 10/13/2016.
 */
@Service
@Transactional
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        org.springframework.security.core.userdetails.User userDetail = null;
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            userDetail =
                    new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user));
        }
        return userDetail;
    }

    private Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        LOGGER.debug("user authorities are " + grantedAuthorities.toString());
        return grantedAuthorities;
    }
}
