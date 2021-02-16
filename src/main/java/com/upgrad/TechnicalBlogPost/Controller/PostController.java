package com.upgrad.TechnicalBlogPost.Controller;

import com.upgrad.TechnicalBlogPost.model.Post;
import com.upgrad.TechnicalBlogPost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {
    //localhost:8090/posts :GET
@Autowired
    PostService postService;
    @RequestMapping("/posts")
    public String getUserPost(Model model){
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts";
    }
    //TODO: GET : POST/NEW POST , POST : POST/CREATE
    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/create";
    }
    @RequestMapping(value="/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost){
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }
}
