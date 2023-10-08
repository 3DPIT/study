package design.pattern.builder.builder3.first;

public abstract class BluePrint {
    abstract public void setCpu();
    abstract public  void setRam();
    abstract  public void setStorage();

    abstract Computer getComputer();
}
