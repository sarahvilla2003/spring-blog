package com.codeup.Repositories;

import com.codeup.models.Ad;
import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Long>{
    public List<Post>findAll();
}
