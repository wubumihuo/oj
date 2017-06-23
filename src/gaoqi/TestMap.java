package gaoqi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazhi on 2016/12/7.
 */
public class TestMap {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put("me",new Wife("abc"));
        map.put("you",new Wife("def"));

        map.clear();

        Wife w=(Wife) map.get("me");
        System.out.println(w.name);
    }
}
class Wife{
    String name;
    public Wife(String name){
        this.name=name;
    }
}
