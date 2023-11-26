package com.example.designpattern.iterator.After;

import com.example.designpattern.iterator.Before.Board;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴 게임1");
        board.addPost("디자인 패턴 게임2");
        board.addPost("디자인 패턴 게임3");

        //TODO 들어간 순서 대로 순회 하기
        Iterator<Post> iterator = board.getPosts().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }

        //TODO 가장 최신 글 먼저 순회 하기
        // 어떤 자료구조를 썼는지 몰라도됨 
        Iterator<Post> recentPostIterator = board.getRecentPostIterator();
        while(recentPostIterator.hasNext()){
             System.out.println(recentPostIterator.next().getTitle());   
        }
    }
}
