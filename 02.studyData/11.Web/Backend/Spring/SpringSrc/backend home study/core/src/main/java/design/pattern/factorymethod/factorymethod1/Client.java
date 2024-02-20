package design.pattern.factorymethod.factorymethod1;

public class Client {
    public static void main(String[] args) {
        Ship whiteship = new WhiteshipFactory().orderShip("whiteship","3dpit@email.com");
        System.out.println(whiteship);

        Ship blackship = new BlackshipFactory().orderShip("blackship","BLACK@email.com");
        System.out.println(blackship);
    }
}
