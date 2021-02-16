package com.upgrad.TechnicalBlogPost.Controller;

import com.upgrad.TechnicalBlogPost.model.Post;
import com.upgrad.TechnicalBlogPost.model.user;
import com.upgrad.TechnicalBlogPost.service.PostService;
import com.upgrad.TechnicalBlogPost.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    //URL : users/login
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postservice;
    @RequestMapping("users/login") //localhost:8090/users/login :GET
    public String login(Model model){
        model.addAttribute("user",new user());
        return "users/login";
    }
    @RequestMapping(value = "users/login", method = RequestMethod.POST)   //localhost:8090/users/login  : POST
    public String loginUser(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if(userService.login(user)){
       return "redirect:/posts";    //localhost:8090/posts :GET
        } else {
            return "users/login";  //localhost:8090/users/login   : GET
        }
    }
    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }
    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        System.out.println(user.getFullName());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        // TODO: service code to register the user so you can login that creds
        return "redirect:/users/login";
    }
    //TODO : logout reference
    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(){
        return "index";
    }
}

