package com.repositories;

import com.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cihan on 4.12.2016.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}
