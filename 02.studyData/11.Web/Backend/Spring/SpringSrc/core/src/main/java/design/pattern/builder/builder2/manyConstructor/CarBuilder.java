package design.pattern.builder.builder2.manyConstructor;

public class CarBuilder {
    private String engine;
    private boolean airbag;
    private String color;
    private boolean cameraSensor;
    private boolean AEB;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setAirbag(boolean airbag) {
        this.airbag = airbag;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setCameraSensor(boolean cameraSensor) {
        this.cameraSensor = cameraSensor;
        return this;
    }

    public CarBuilder setAEB(boolean AEB) {
        this.AEB = AEB;
        return this;
    }

    public Car build(){
        return new Car(engine,airbag,color,cameraSensor,AEB);
    }
}
