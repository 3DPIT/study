package design.pattern.proxy.proxy2;

public interface Subject {

    //리스소가 적게 드는 일
    void action1();

    //리소스가 많이 드는 일, 네트워트 메모리
    void action2();

}
