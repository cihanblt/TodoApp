package com.services.impl;

import com.models.Role;
import com.models.Status;
import com.models.Todo;
import com.models.User;
import com.repositories.RoleRepository;
import com.repositories.TodoRepository;
import com.repositories.UserRepository;
import com.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by cihan on 4.12.2016.
 */
@Service
public class TodoServiceImpl implements TodoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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
    public boolean updateJob(Todo todo) {
        try {
            todoRepository.saveAndFlush(todo);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Todo> getJobList(User user) {
        return todoRepository.findByAssignedToUser(user);
    }

    @Override
    public List<User> getUsers() {
//            Role role = roleRepository.findOne(Long.valueOf(61));
            return userRepository.findAll();
    }

    @Override
    public List<Todo> getAllTaskThatDone() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoObject(long todoId) {
        return todoRepository.getOne(Long.valueOf(todoId));
    }
}
