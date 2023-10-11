package design.pattern.factorymethod.factorymethod3;

public class Sword implements Item{
    @Override
    public void use() {
        System.out.println("칼을 사용함");
    }
}
