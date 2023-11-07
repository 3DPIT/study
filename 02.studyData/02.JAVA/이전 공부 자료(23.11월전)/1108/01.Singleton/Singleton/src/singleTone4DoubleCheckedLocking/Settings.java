package singleTone4DoubleCheckedLocking;
public class Settings{

    private static volatile Settings instance;

    private Settings(){}

    public static  synchronized Settings getInstance(){
        if(instance ==null){
            synchronized (Settings.class){
                if(instance == null){
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}