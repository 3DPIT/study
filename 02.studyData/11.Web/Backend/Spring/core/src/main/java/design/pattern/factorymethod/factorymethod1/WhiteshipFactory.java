package design.pattern.factorymethod.factorymethod1;

public class WhiteshipFactory implements ShipFactory{
    @Override
    public Ship createShip() {

        return new Whiteship();
    }
}
