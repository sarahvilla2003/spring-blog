package com.codeup.models;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class Post {
//    @GetMapping ("")
//    private String title(){
//        return title
//    }
//}
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.javafx.beans.IDProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length =100)
    @NotBlank(message = "Posts must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")

    private String title;

    @Column(nullable = false, columnDefinition = "text")
    @NotBlank(message = "Posts must have a body")
    private String body;

    @ManyToOne
    @JsonManagedReference
    private User owner;

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner=owner;
    }

    public Post(){

    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
