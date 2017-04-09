package com.controllers;

import com.backstrc.BackStrcApplication;
import com.models.Priority;
import com.models.Status;
import com.models.Todo;
import com.models.User;
import com.services.TodoService;
import com.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;

/**
 * Created by cihan on 4.12.2016.
 */


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = BackStrcApplication.class)
//@WebAppConfiguration
public class HomeControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TodoService todoService;
//
//    @MockBean
//    private UserService userService;

//    @Test
//    public void createTodoJob() throws Exception {

//        User user = userService.getUserByUsername("ccc");
//
//        Assert.assertNotNull("failure : user doesn't exist",user);
//
//        Todo todo = new Todo();
//        todo.setUser(user);
//        todo.setDescription("test description");
//        todo.setStatus(Status.DONE);
//        todo.setPriority(Priority.LOW);
//        todo.setDueDate(new Date());
//
//
//        this.mockMvc.perform(post("/add_job",todo)).andExpect(status().isOk());
//    }



}
