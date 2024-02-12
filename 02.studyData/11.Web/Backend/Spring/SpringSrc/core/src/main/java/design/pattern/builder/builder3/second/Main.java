package design.pattern.builder.builder3.second;
public class Main {
    public static void main(String[] args) {
        Computer computer = ComputerBuilder
                .start()
                .setCpu("M1")
                .setRam("32g")
                .build();

        System.out.println(computer.toString());
    }
}
