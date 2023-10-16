package proxy._2;

public class Main {
    public static void main(String[] args) {
        Subject real = new RealSubject();
        Subject proxy1= new Proxy(real);
        Subject proxy2= new Proxy(real);

        real.action1();
        real.action2();

        proxy1.action1();
        proxy1.action2();

        proxy2.action1();
        proxy2.action2();
    }
}
