package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    private List<Post> posts;

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    /Constructors
    public User(User user){
id=user.id;
email=user.email;
username=user.username;
password=user.password;
    }

    public User() {
    }

    public long getId(){
        return id;}
    public void setId(long id){
        this.id=id;}


    public String getUsername(){
        return username;}
    public void setUsername(String username){
        this.username=username;}

    public String getEmail(){
        return email;}
    public void setEmail(String email){
        this.email=email;}


    public String getPassword(){
        return password;}
    public void setPassword(String password){
        this.password=password;}

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
