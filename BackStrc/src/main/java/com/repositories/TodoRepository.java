package com.repositories;

import com.models.Todo;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cihan on 4.12.2016.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

    public List<Todo> findByUser(User user);

}
