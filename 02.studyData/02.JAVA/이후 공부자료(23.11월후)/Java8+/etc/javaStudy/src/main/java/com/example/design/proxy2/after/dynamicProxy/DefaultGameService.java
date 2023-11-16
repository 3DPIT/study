package com.example.design.proxy2.after.dynamicProxy;

public class DefaultGameService implements GameService {
    @Override
    public void startGame() {
        System.out.println("start game");
    }
}
