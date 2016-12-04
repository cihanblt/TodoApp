package com.services;

import com.backstrc.BackStrcApplication;
import com.models.Priority;
import com.models.Status;
import com.models.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.models.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by cihan on 4.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BackStrcApplication.class)
@SpringBootTest
public class TodoServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;


    @Test
    @Transactional
    public void testSaveJob(){
        User user = userService.getUserByUsername("ccc");

        Assert.assertNotNull("failure : user doesn't exist",user);

        Todo todo = new Todo();
        todo.setUser(user);
        todo.setDescription("test description");
        todo.setStatus(Status.DONE);
        todo.setPriority(Priority.LOW);
        todo.setDueDate(new Date());

        boolean isOk = todoService.saveJob(todo);
        Assert.assertEquals("failure : job doesn't save",true,isOk);

    }

    @Test
    public void testListJob(){
        User user = userService.getUserByUsername("ccc");

        Assert.assertNotNull("failure : user doesn't exist",user);

        List<Todo> todos = todoService.getJobList(user);

        Assert.assertEquals("failure : list.size not eq",2,todos.size());
    }
}
