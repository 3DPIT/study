package composite._2;

import java.util.Iterator;
import java.util.LinkedList;

public class Folder  extends  Unit{

    private LinkedList<Unit> unitList = new LinkedList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        int size=0;
        Iterator<Unit> it = unitList.iterator();

        while(it.hasNext()) {
            Unit unit = it.next();
            size += unit.getSize();
        }

        return size;
    }

    public boolean add(Unit unit){
        unitList.add(unit);

        return true;
    }

    private void list(String indent, Unit unit){
        if(unit instanceof File){
            System.out.println(indent+unit);
        }else{
            Folder dir = (Folder) unit;
            Iterator<Unit> it = dir.unitList.iterator();
            System.out.println(indent+"+ "+unit);
            while(it.hasNext()){
                list(indent + "     ", it.next());
            }
        }
    }

    public void list(){
        list("", this);
    }
}