package com.example.design.proxy2.after.basicInterface2.basicInterface;

public class DefaultGameService implements GameService {
    @Override
    public void startGame() {
        System.out.println("start game");
    }
}
