package com.example.design.proxy2.after.basicInterface2.basicInterface;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }
}
