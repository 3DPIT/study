package proxy._3;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy(new DefaultGame());
        gameService.gameStart();
    }
}
