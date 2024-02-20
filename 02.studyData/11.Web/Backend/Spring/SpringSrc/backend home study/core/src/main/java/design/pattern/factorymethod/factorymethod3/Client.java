package design.pattern.factorymethod.factorymethod3;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ItemFactory();

        Item item1 = factory.create("sword");
        if(item1 != null) item1.use();

        Item item2 = factory.create("sword");
        if(item2 != null) item2.use();

        Item item3 = factory.create("sword");
        if(item3 != null) item3.use();

        Item item4 = factory.create("sword");
        if(item4 != null) item4.use();

        Item item5 = factory.create("sword");
        if(item5 != null) item5.use();


    }
}
