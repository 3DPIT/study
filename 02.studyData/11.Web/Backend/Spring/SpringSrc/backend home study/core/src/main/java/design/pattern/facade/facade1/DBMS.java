package design.pattern.facade.facade1;

import java.util.HashMap;

public class DBMS {
    private HashMap<String, Row> db = new HashMap<String, Row>();

    public DBMS(){
        db.put("kmp",new Row("Kmp","1992-08-17","kmp@email.com"));
        db.put("kmp1",new Row("Kmp","1992-08-17","kmp@email.com"));
        db.put("kmp2",new Row("Kmp","1992-08-17","kmp@email.com"));
    }

    public Row  query(String name){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return db.get(name.toLowerCase());
    }
}
