package proxy._3;

public class GameServiceProxy implements GameService{
   private GameService gameService;

    public GameServiceProxy(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void gameStart() {
        long before = System.currentTimeMillis();
        gameService.gameStart();
        System.out.println(System.currentTimeMillis());
    }
}
