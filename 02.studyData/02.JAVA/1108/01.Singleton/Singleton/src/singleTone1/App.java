package singleTone1;

public class App {
    public static void main(String[] args) throws Exception {
        Settings settings = Settings.getInstance();
        Settings settings1 = Settings.getInstance();
        System.out.println(settings == settings1);
        System.out.println(settings==Settings.getInstance());
    }
}
