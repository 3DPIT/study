package design.pattern.command.command2;

public class GameEndCommand implements Command{
    private Game game;

    public GameEndCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.end();
    }
}
