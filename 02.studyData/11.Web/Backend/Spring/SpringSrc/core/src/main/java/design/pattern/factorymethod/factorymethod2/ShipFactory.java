package design.pattern.factorymethod.factorymethod2;

public interface ShipFactory {
    default Ship orderShip(String name, String email){
        validate(name,email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email,ship);
        return ship;
    }
    Ship createShip();
     void validate(String name, String email);
     void prepareFor(String name);

    void sendEmailTo(String email, Ship ship);
}
