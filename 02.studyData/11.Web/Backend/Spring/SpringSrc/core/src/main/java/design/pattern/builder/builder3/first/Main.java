package design.pattern.builder.builder3.first;

public class Main {
    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        factory.setBlueprint(new LgGramBluePrint());
        factory.make();
        Computer computer = factory.getComputer();
        System.out.println(computer.toString());
    }
}
