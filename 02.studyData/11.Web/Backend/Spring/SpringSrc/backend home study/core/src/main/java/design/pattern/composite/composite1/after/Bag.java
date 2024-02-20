package design.pattern.composite.composite1.after;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {
    private List<Component> components = new ArrayList<>(); //leaf타입으로 하면 안됨
    public void add(Component component) {components.add(component);}
    public List<Component> getComponents(){return components;}

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}

