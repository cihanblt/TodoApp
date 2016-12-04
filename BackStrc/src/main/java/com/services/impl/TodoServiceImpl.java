package com.services.impl;

import com.models.Todo;
import com.models.User;
import com.repositories.TodoRepository;
import com.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cihan on 4.12.2016.
 */
@Service
public class TodoServiceImpl implements TodoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public boolean saveJob(Todo todo) {
        try {
            todoRepository.save(todo);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Todo> getJobList(User user) {
        return todoRepository.findByUser(user);
    }
}
