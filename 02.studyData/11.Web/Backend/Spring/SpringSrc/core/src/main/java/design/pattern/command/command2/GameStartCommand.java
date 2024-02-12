package design.pattern.command.command2;

public class GameStartCommand implements Command{
    private Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
