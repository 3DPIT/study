package com.example.design.proxy2.before;

public class Client {
    public static void main(String[] args) {

        //앞뒤로 넣을 수 있지만 시간 측정 그렇게 안함
        GameService gameService = new GameService();
        gameService.startGame();
    }
}
