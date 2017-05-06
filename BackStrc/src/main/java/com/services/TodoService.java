package com.services;

import com.models.Todo;
import com.models.User;

import java.util.List;

/**
 * Created by cihan on 4.12.2016.
 */
public interface TodoService {

    public boolean saveJob(Todo todo);

    public List<Todo> getJobList(User user);

    public List<Todo> getAllTaskThatDone();

    public List<User> getUsers();

    public boolean updateJob(Todo todo);

    public Todo getTodoObject(long todoId);
}
