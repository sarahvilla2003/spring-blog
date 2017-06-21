package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

//    private final com.codeup.svcs.PostSvc postSvc;
//
//    public PostController(com.codeup.svcs.PostSvc postSvc){
//        this.postSvc = postSvc;
//    }

    @GetMapping ("/post")
    public String viewall (Model model){
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("Hello there!", ""));
        posts.add(new Post("Anyone there?", ""));
        model.addAttribute("posts", posts);

        return "post/index";
    }

    @GetMapping ("post/{id}")
    public String viewIndividualPost (@PathVariable long id, Model model){
        Post post = new Post("test post", "my first blog post");

        return "post/show";
    }

    @GetMapping("post/create")

    public String showPostForm (){
        return "view the form for creating a post";
    }

    @PostMapping ("/posts/create")
    @ResponseBody
    public String savepost (){
        return "create a new post";
    }

}
