package design.pattern.command.command1;

public class ClearCommand implements Command {
    @Override
    public void run() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
