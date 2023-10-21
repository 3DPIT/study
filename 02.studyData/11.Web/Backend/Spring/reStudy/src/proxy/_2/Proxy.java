package proxy._2;

public class Proxy implements Subject{
    private Subject real;

    public Proxy(Subject real) {
        this.real = real;
    }

    @Override
    public void action1() {
        System.out.println("간단한 업무 프록시");
    }

    @Override
    public void action2() {
        this.real.action2();
    }
}
