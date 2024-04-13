package com.example.designpattern.iterator.Before;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴 게임1");
        board.addPost("디자인 패턴 게임2");
        board.addPost("디자인 패턴 게임3");

        //TODO 들어간 순서 대로 순회 하기
        List<Post> posts = board.getPosts();
        for(int i=0; i<posts.size();i++){
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }

        //TODO 가장 최신 글 먼저 순회 하기
        Collections.sort(posts,(p1,p2)-> p2.getCreatedDateTime().comareTo(p1.getGreateDateTime()));
        for(int i=0; i<posts.size(); i++){
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }
    }
}
