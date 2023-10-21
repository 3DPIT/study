package composite._2;

public abstract class Unit {

    private String name;

    public Unit(String name){
        this.name= name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' + getSize()+'\''+
                '}';
    }

    public abstract int getSize();
}
