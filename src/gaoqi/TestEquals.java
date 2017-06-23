package gaoqi;

import leetcode.NodePerform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mazhi on 2016/12/7.
 */
public class TestEquals {
    public static  void main(String [] args){
        List list = new ArrayList<>();
        String s1 =new String("aaa");
        String s2= new String("aaa");
        list.add(s1);
        list.add(s2);
        System.out.println(list.size());

        //equals 两个值一样的对象就是equal true
        Map map = new HashMap<>();
        map.put(s1,"AAA");
        map.put(s2,"bbb");
        System.out.println(map.size());
    }
}
