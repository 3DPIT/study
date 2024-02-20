package design.pattern.strategy.strategy1;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight(new Normal());
        game.blueLight();
        game.redLight();

        BlueLightRedLight1 game1 = new BlueLightRedLight1();
        game1.blueLight(new Normal());
        game1.redLight(new Faster());

        BlueLightRedLight game3 = new BlueLightRedLight(new Speed() {
            @Override
            public void blueLight() {
                System.out.println("무광꽃이");
            }

            @Override
            public void redLight() {
                System.out.println("폈다.");
            }
        });
        game3.blueLight();
        game3.redLight();
    }
}
