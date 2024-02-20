package design.pattern.command.command2;

import design.pattern.command.command2.Command;

public class Button{
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void press(){
        command.execute();
    }

    public static void main(String[] args) {
/*        Button button = new Button(new LightOnCommand(new Light()));
        button.press();*/

        Button button = new Button(new GameStartCommand(new Game()));
        button.press();
    }
}
