package design.pattern.proxy.proxy3.after_interface;

public class DefaultGameService implements GameService{
    @Override
    public void gameStart() {
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
    }
}
