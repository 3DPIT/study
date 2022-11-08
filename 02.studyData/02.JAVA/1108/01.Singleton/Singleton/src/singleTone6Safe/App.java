package singleTone6Safe;

public class App {
    public static void main(String[] args) throws Exception {
        Settings settings = Settings.INSTANCE;
        Settings settings1 = Settings.INSTANCE;
        System.out.println(settings == settings1);
        System.out.println(settings==Settings.INSTANCE);
    }
}
