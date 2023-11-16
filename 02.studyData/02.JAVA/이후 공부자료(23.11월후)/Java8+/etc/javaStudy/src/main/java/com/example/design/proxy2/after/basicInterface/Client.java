package com.example.design.proxy2.after.basicInterface;

import com.example.design.proxy2.after.basicInterface.GameService;
import com.example.design.proxy2.after.basicInterface.GameServiceProxy;

public class Client { //이런 주입도 DI로 할 수 있으면 좀더 유연해질 듯?
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
