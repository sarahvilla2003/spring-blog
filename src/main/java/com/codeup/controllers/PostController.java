package com.codeup.controllers;

import com.codeup.Repositories.PostRepository;
import com.codeup.models.Ad;
import com.codeup.models.Post;
import com.codeup.Repositories.UsersRepository;
import com.codeup.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.codeup.svcs.PostSvc;

import javax.validation.Valid;

@Controller
public class PostController {

    private final PostSvc postSvc;
    private final UsersRepository usersDao;
    private final PostRepository postDao;

    public PostController(PostSvc postSvc, UsersRepository usersDao, PostRepository postDao) {

        this.postSvc = postSvc;
        this.usersDao= usersDao;
        this.postDao= postDao;
    }


    @GetMapping("/posts.json")
    public @ResponseBody Iterable<Post>viewAllPosts(){
        return postDao.findAll();
    }

    @GetMapping("/posts")
    public String viewall(Model model) {
//        User userLoggedin(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()

        Iterable<Post> posts = postSvc.findAll();
        model.addAttribute("posts", posts);
//        model.addAttribute("userLoggedin", userLoggedin);
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("posts/create")
    public String showPostForm(Model model) {

        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String savePost(
            @Valid Post post,
            Errors validation,
            Model model
    )

    {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postSvc.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }

//Edit Functionality//

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();

    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post,
                             @RequestParam long id,
                             Model model) {

        System.out.println(post.getId());
        postSvc.deletePost(id);
        model.addAttribute("message", "Your post was deleted correctly");
        return "redirect:/posts";
    }

}
