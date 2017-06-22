package com.codeup.Repositories;

import com.codeup.models.Ad;
import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>{
}
