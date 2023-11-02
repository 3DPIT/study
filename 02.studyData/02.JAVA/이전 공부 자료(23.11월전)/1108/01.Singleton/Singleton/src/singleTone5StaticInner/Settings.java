package singleTone5StaticInner;
public class Settings{

    private Settings(){}

    private static class SettingsHolder{
        private static final Settings INSTANCE = new Settings();
    }


    public static  synchronized Settings getInstance(){
        return SettingsHolder.INSTANCE;
    }
}