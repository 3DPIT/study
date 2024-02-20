package design.pattern.proxy.proxy3.after_interface;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.gameStart();
    }
}
