package com.repositories;

import com.models.Role;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cihanblt on 10/20/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUserName(String username);

    public List<User> findByRoles(Role role);
}
