package com.controllers;

import com.models.Status;
import com.models.Todo;
import com.models.User;
import com.services.TodoService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by cihanblt
 */
@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/")
    public String goToIndex(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("todo",new Todo());
        List<Todo> todos = todoService.getJobList(userService.getUserOnAuthentication());
        model.addAttribute("todoList",todos);
//        System.out.println(5/0);
        return "index";
    }

    @RequestMapping(path = "/add_job",method = RequestMethod.POST)
    public String addJob(@ModelAttribute(value = "todo") Todo todo, Model model, RedirectAttributes redirectAttributes) {
        todo.setUser(userService.getUserOnAuthentication());
        if(todoService.saveJob(todo)){

            redirectAttributes.addFlashAttribute("successJob",true);
        }else{
            redirectAttributes.addFlashAttribute("successJob",false);
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/assign-task")
    public String goToAssignTaskPage(Model model) {
        model.addAttribute("todo",new Todo());
        List<Todo> todos = todoService.getJobList(userService.getUserOnAuthentication());
        List<User> users = todoService.getUsers();
        model.addAttribute("todoList",todos);
        model.addAttribute("users",users);
//        System.out.println(5/0);
        return "assign-task";
    }

    @RequestMapping(path = "/get-all-task")
    public String getAllTaskForAdmin(Model model) {
        model.addAttribute("todo",new Todo());
        List<Todo> todos = todoService.getAllTaskThatDone();
        model.addAttribute("todoList",todos);
//        System.out.println(5/0);
        return "all-task";
    }
    @RequestMapping(path = "/reports")
    public String getReport(Model model) {
        model.addAttribute("todo",new Todo());
        List<Todo> todos = todoService.getAllTaskThatDone();
        model.addAttribute("todoList",todos);
//        System.out.println(5/0);
        return "reports";
    }

    @RequestMapping(path = "/get-report-bydate",method = RequestMethod.POST)
    public String getReportByDate(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("todo",new Todo());
        List<Todo> todos = todoService.getAllTaskThatDone();
        model.addAttribute("todoList",todos);

            redirectAttributes.addFlashAttribute("successJob",true);
        return "redirect:/reports";
    }
    @RequestMapping(path = "/update-job",method = RequestMethod.POST)
    public String updateJob(@RequestParam(value = "todoId") long todoId,@RequestParam(value = "statusName") String status) {
        Todo todo = todoService.getTodoObject(todoId);
        todo.setStatus(Status.valueOf(status));
        if(todoService.saveJob(todo)){

//            redirectAttributes.addFlashAttribute("successJob",true);
        }else{
//            redirectAttributes.addFlashAttribute("successJob",false);
        }
        return "redirect:/";
    }
//
}
