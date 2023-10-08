package design.pattern.builder.builder2.orderAndStep;

public class Director {
    private  Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public String build(){
        StringBuilder sb = new StringBuilder();

        sb.append(builder.head());
        sb.append(builder.body());
        sb.append(builder.foot());

        return sb.toString();
    }

}
