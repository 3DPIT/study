package design.pattern.facade.facade1;

import java.util.HashMap;

public class Cache {
     private HashMap<String, Row> cache = new HashMap<String, Row>();

     public void put(Row row){
         cache.put(row.getNanme(), row);
     }

     public Row get(String name){
         return cache.get(name);
     }
}
