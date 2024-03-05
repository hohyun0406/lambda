package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Box<T>{
    private Map<String, T> box;

    public Box() {
        this.box = new HashMap<>();
    }

    public void put (List<String> keys, Inventory<T> values){
        box = new HashMap<>();
        for(int i = 0;i<keys.size();i++){
            box.put(keys.get(i), values.get(i));
        }
        box.forEach((k,v)-> System.out.println(String.format("%s : %s", k, v)));
    }
    //리스트에 키와 인벤토리의 밸류. 밸류값을람다로출력

    public T put (String k, T t){
        return box.put(k, t);
    }

    public T get (String k){
        return box.get(k);
    }

    public int size(){
        return box.size();
    }

    public void clear(){
        box.clear();
    }

}
