package com.repositories;

import com.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cihan on 1.05.2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByName(String name);
}
