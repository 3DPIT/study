package design.pattern.builder.builder2.manyConstructor;

import java.util.Random;

public class MainEntry {
    public static void main(String[] args) {
        Car car1 = new Car("V7",true, "Black",true, false);

        Car car2 = new CarBuilder() //Method Chaining
                .setAEB(false)
                .setAirbag(false)
                .setCameraSensor(true)
                .setColor("White")
                .setEngine("V9")
                .build();

        CarBuilder builder = new CarBuilder() //Method Chaining
                .setAEB(false)
                //.setAirbag(false)
                .setCameraSensor(true)
                .setColor("White")
                .setEngine("V9");
                //.build();

        Random random = new Random();
        Car car3 = builder
                .setAirbag(random.nextInt(2)==0)  //50%확률 에어백 장착
                .build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
