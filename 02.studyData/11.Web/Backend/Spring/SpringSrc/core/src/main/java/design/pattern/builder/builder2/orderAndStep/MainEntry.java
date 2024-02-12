package design.pattern.builder.builder2.orderAndStep;

public class MainEntry {
    public static void main(String[] args) {
        Data data = new Data("KMP", 23);

        Builder builder = new PlainTextBuilder(data);
        Director director = new Director(builder);
        String result = director.build();
        System.out.println(result);

        builder = new JSONBuilder(data);
        director = new Director(builder);
        result = director.build();
        System.out.println(result);

        builder = new XMLBuilder(data);
        director = new Director(builder);
        result = director.build();
        System.out.println(result);
    }
}
