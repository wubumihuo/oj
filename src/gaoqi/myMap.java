package gaoqi;

/**
 * Created by mazhi on 2016/12/7.
 * 存放键值对，自己写的HashMap
 */
public class myMap {
    myEntry[] arr = new myEntry[990];
    int size;

    public void put(Object key, Object value) {
        myEntry e = new myEntry(key, value);
        arr[size++] = e;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key))
                return arr[i].value;
        }
        return null;
    }

    public boolean containsKey(Object key){
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        myMap map = new myMap();
        map.put("me",new Wife("123"));
        map.put("you",new Wife("456"));
        Wife w=(Wife) map.get("you");
        System.out.println(w.name);
    }
}

class myEntry {
    Object key;
    Object value;

    public myEntry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
}
