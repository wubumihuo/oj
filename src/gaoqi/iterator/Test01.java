package gaoqi.iterator;

import java.util.*;

/**
 * Created by mazhi on 2016/12/8.
 */
public class Test01 {
    public static void main(String [] args){

        Set set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        String a="sss";
        Integer i=2;
        Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
                iterator.remove();
            }
    }
}
