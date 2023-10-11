package design.pattern.factorymethod.factorymethod3;

public class Shield implements Item{
    @Override
    public void use() {
        System.out.println("방패를 사용함");
    }
}
