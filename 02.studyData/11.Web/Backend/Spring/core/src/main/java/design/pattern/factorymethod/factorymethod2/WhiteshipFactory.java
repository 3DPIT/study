package design.pattern.factorymethod.factorymethod2;

public class WhiteshipFactory extends DefaultShipFactory {
    @Override
    public Ship createShip() {

        return new Whiteship();
    }
}
