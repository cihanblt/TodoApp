package com.services;

import com.backstrc.BackStrcApplication;
import com.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by cihan on 4.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BackStrcApplication.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

//    @Before
//    public void setUp(){
//
//    }

    @Test
    public void testFindUser(){
        User user = userService.getUserByUsername("ccc");

        Assert.assertNotNull("failure : expected not null", user);
        Assert.assertEquals("failure : not expected user id",29,user.getId());
    }

    @Test
    @Transactional
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("ahmet");
        user.setLastName("kama");
        user.setUserName("ahmetkama");
        user.setPassword(new ShaPasswordEncoder(256).encodePassword("1234",null));
        user.setEmail("a@gmail.com");

        boolean ok = userService.saveUser(user);
        Assert.assertEquals("failure : user didn't save",true,ok);

    }
//
//    @After
//    public void tearDown(){
//
//    }
}
