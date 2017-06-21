package com.codeup.svcs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.codeup.models.Post;

@Service
public class PostSvc {

    List<Post> posts = new ArrayList<>();

    public PostSvc(){
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post findone(long id){
        return posts.get((int)id - 1);
    }

    public Post save (Post post){
        post.setId((long) posts.size() + 1);
        posts.add(post);
        return post;
    }

    private void createPosts(){
        save(new Post("radio", ""));

    }
}
