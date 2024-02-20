package design.pattern.proxy.proxy3.before;

import design.pattern.proxy.proxy3.after_extends.GameServiceProxy;

public class Client{
    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }
}
