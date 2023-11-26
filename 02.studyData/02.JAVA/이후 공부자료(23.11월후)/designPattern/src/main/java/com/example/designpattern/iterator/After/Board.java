package com.example.designpattern.iterator.After;

import java.util.ArrayList;

public class Board {

    List<Post> posts = new ArrayList<>();

    public List<posts> getPosts(){
        return posts;
    }

    public void addPost(String content){
        this.posts.add(new Post(content));
    }

    public Iterator<Post> getRecentPostIterator(this);
}

