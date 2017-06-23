package gaoqi;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by mazhi on 2016/12/7.
 * 自定义map升级版，提高查询效率
 */
public class myHashMap {
    MyLinkedList[] arr = new MyLinkedList[999];
    int size;

    public void put(Object key, Object value) {
        myEntry e= new myEntry(key,value);
        int a = key.hashCode()%arr.length;
        if(arr[a]==null){
            MyLinkedList list=new MyLinkedList();
            list.add(e);
            arr[a] = list;
        }else{
            MyLinkedList list=arr[a];
            for(int i=0;i<list.size();i++){
                myEntry e2=(myEntry)list.get(i);
                if(e2.key.equals(key)){
                    e2.value = value;
                    return ;
                }
            }
            arr[a].add(e);
        }
    }

    public Object get(Object key){
        int a = key.hashCode()%arr.length;
        if(arr[a]!=null){
            MyLinkedList list = arr[a];
            for(int i=0;i<list.size();i++){
                myEntry e= (myEntry)list.get(i);
                if(e.key.equals(key)){
                    return e.value;
                }
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        myHashMap map = new myHashMap();
        map.put("me",new Wife("123"));
        map.put("you",new Wife("456"));
        map.put("you",new Wife("789"));
        Wife w=(Wife) map.get("you");
        System.out.println(w.name);
    }
}
