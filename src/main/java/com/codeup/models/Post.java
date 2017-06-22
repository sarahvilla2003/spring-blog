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
import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.*;


@Entity
@Table(name="ad_db")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length =100)
    private String title;

    @Column(nullable = false)
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
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
}
