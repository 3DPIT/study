package design.pattern.builder.builder3.first;

public class ComputerFactory {
    private BluePrint print;

    public void setBlueprint(BluePrint print) {
        this.print = print;
    }

    public void make(){
        print.setRam();
        print.setCpu();
        print.setStorage();
    }

    public Computer getComputer(){
        return print.getComputer();
    }

}
