package gaoqi;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by mazhi on 2016/12/6.
 */
public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public int size(){
        return size;
    }

    public void add(Object obj){
        Node n = new Node();
        if(first==null){
            n.setPrev(null);
            n.setObj(obj);
            n.setNext(null);
            first = n;
            last=n;
        }else{
            n.setPrev(last);
            n.setObj(obj);
            n.setNext(null);
            last.setNext(n);
            last = n ;
        }
        size++;
    }

    public void add(int index,Object obj){
        Node node_new = new Node();
        node_new.obj=obj;
        Node temp = node(index);
        if(temp!=null){
            temp.prev.next = node_new;
            node_new.prev=temp.prev;
            node_new.next=temp;
            temp.prev=node_new;
            size++;
        }
    }

    public Object get(int index){
        rangeCheck(index);
       Node temp = node(index);
        if(temp!=null)
        return temp.getObj();
        else return null;
    }
    public void remove(int index){
        Node temp=node(index);
        if(temp!=null){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    public Node node(int index){
        Node temp =null;
        if(first!=null){
            temp=first;
            for(int i =0;i<index;i++){
                temp= temp.next;
            }
        }
        return temp;
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
    public  static  void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        LinkedList linkedlist=new LinkedList();
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));
        list.add(1,"hhh");
        System.out.println(list.get(1));
    }
}

