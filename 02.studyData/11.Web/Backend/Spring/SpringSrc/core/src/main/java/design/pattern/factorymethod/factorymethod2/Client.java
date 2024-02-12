package design.pattern.factorymethod.factorymethod2;

import design.pattern.factorymethod.factorymethod2.ShipFactory;

public class Client {
    public static void main(String[] args) {

        Client client = new Client();

        client.print(new WhiteshipFactory(), "whiteship","3dpit@email.com");
        client.print(new BlackshipFactory(), "blackship","BLACK@email.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name,email));
    }
}
