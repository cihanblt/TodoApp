package com.services.impl;

import com.repositories.TodoRepository;
import com.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cihan on 4.12.2016.
 */
@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;


}
