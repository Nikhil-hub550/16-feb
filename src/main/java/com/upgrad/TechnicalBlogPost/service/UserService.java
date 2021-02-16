package com.upgrad.TechnicalBlogPost.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(User user){
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin123")){
            return true;
        }
        else
        {
            return false;
        }
    }
}
