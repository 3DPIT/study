package design.pattern.proxy.proxy1;

public class ScreenDisplay implements Display{
    @Override
    public void print(String content) {
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(content);
    }
}
