package design.pattern.factorymethod.factorymethod1;

public class BlackshipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new Blackship();
    }
}
