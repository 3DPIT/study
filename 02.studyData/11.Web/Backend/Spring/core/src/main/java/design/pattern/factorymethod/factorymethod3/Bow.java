package design.pattern.factorymethod.factorymethod3;

public class Bow implements Item{
    @Override
    public void use() {
        System.out.println("화살을 사용함");
    }
}
