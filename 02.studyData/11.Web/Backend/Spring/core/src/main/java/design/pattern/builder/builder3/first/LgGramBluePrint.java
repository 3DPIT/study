package design.pattern.builder.builder3.first;

public class LgGramBluePrint extends BluePrint{
    private Computer computer;
    public LgGramBluePrint() {
        computer = new Computer("default","default","default");
    }

    @Override
    public void setCpu() {
        computer.setCpu("M1");
    }

    @Override
    public void setRam() {
        computer.setRam("32g");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1T ssd");
    }

    @Override
    Computer getComputer() {
        return computer;
    }
}
