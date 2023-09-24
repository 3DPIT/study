package design.pattern.proxy.proxy3.after_extends;

import design.pattern.proxy.proxy3.before.GameService;

public class GameServiceProxy extends GameService {
    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        super.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
