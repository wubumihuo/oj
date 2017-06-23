package gaoqi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2016/12/6.
 * 自己实现一个ArrayList/
 * */
public class MyArrayList  {
    private Object[] elementData;

    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public MyArrayList() {
        this.size=10;
    }

    public MyArrayList(int initialCapacity){
       elementData = new Object[initialCapacity];
    }
    public void add(Object obj){
        ensureCap();
        elementData[size++]=obj;
    }

    public void ensureCap(){
        if(size == elementData.length){
            Object[] newArray = new Object[size*2+1];
            System.arraycopy(elementData, 0,newArray,0,elementData.length);
            elementData = newArray;
        }
    }

    public Object  get(int index){
       rangeCheck(index);
        return elementData[index];
    }

    public void rangeCheck(int index){
        if(index<0|| index>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(int index){
        rangeCheck(index);
        int numMoved = size - index -1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;
    }

    public void add(int index, Object obj){
        rangeCheck(index);
        ensureCap();
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=obj;
        size++;
    }

    public void remove(Object object){
        for(int i =0;i<size;i++){
            if(elementData[i].equals(object)){
                remove(i);
            }
        }
    }

    public void set(int index,Object obj){
        rangeCheck(index);
        elementData[index]=obj;
    }

    public static void main(String[] args){
        MyArrayList list = new MyArrayList(3);
        list.add("123");
        list.add("456");
        list.add("456");
        list.add("222");
        System.out.print(list.size());
    }
}
