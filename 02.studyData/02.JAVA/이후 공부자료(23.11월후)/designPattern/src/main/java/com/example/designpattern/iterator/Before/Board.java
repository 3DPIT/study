package com.example.designpattern.iterator.Before;

import java.util.ArrayList;

public class Board {

    List<Post> posts = new ArrayList<>();

    public List<posts> getPosts(){
        return posts;
    }

    public void addPost(String content){
        this.posts.add(new Post(content));
    }
}

