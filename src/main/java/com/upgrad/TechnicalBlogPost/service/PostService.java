package com.upgrad.TechnicalBlogPost.service;

import com.upgrad.TechnicalBlogPost.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    private static ArrayList<Post> POSTS = new ArrayList<>();
    static {
        Post post1 = new Post();
        post1.setTitle("Full Stack Developer");
        post1.setBody("FOP");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Full Stack Developer");
        post2.setBody("Backend");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Full Stack Developer");
        post3.setBody("Frontend");
        post3.setDate(new Date());

        POSTS.add(post1);
        POSTS.add(post2);
        POSTS.add(post3);
    }
    public ArrayList<Post> getAllPosts(){
        return POSTS;
    }
    public void createPost(Post newPost){
        POSTS.add(newPost);
    }
}
