package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("postSvc")
public class PostSvc {
//Autowire an instance of X mean
//    1. Add a private property of type X within the class Y
//    2. Create/update the consturctor of the class Y where you added the property, to receive one more argument of type X

    private PostRepository postsDao;

    @Autowired
    public PostSvc(PostRepository postsDao) {

        this.postsDao = postsDao;
    }

    public Iterable<Post> findAll() {

        return postsDao.findAll();
    }

    public Post findOne(long id) {

        return postsDao.findOne(id);
    }

    public Post save(Post post) {
        postsDao.save(post);

        return post;
    }

     public void deletePost (long id){
         Post post = this.findOne(id);
         postsDao.delete(post);
    }

    }





