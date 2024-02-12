package design.pattern.command.command1;

public class MainEntry {
    public static void main(String[] args) {
        CommandGroup cmdGroup = new CommandGroup();

        Command clearCmd = new ClearCommand();
        cmdGroup.add(clearCmd);

        Command redColorCmd = new ColorCommand(ColorCommand.Color.RED);
        cmdGroup.add(redColorCmd);

        Command moveCmd = new MoveCommand(10,1);
        cmdGroup.add(moveCmd);

        Command printCmd = new PrintCommand("디자인패턴 마스터");
        cmdGroup.add(printCmd);

        Command moveCmd2 = new MoveCommand(15,50);
        cmdGroup.add(moveCmd2);

        Command greenColorCmd = new ColorCommand(ColorCommand.Color.GREEN);
        cmdGroup.add(greenColorCmd);

        cmdGroup.add(printCmd);

        cmdGroup.run();
    }
}
