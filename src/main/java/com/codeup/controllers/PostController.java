package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import com.codeup.svcs.PostSvc;

@Controller
public class PostController {

    private final PostSvc postSvc;

    public PostController(PostSvc postSvc){
        this.postSvc = postSvc;
    }

    @GetMapping ("/post")
    public String viewall (Model model){
        Iterable<Post> posts = postSvc.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping ("post/{id}")
    public String viewIndividualPost (@PathVariable long id, Model model){
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);

        return "posts/show";
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
