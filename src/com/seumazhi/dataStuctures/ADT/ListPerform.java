package com.seumazhi.dataStuctures.ADT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2016/12/22.
 */
public class ListPerform {


    public static void main(String [] args){
        List arraylist = new ArrayList<Integer>();
        arraylist.add(6);
        arraylist.add(5);
        arraylist.add(1);
        arraylist.add(4);
        arraylist.add(2);
    }
    public static void removeEvenVer(List <Integer> list){
        for(Integer x:list)
            if(x%2==0) list.remove(x);
    }
}
