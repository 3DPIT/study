package proxy._1;

public class Main {
    public static void main(String[] args) {
        //Display display = new ScreenDisplay();
        Display display = new BufferDisplay(9);
        display.print("1");
        display.print("2");
        display.print("3");
        display.print("4");
        display.print("5");
        display.print("6");
        display.print("7");
        display.print("8");
        display.print("9");
    }
}
