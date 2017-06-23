package com.seumazhi.mazhi;

/**
 * Created by mazhi on 2016/12/8.
 * 自定义泛型类使用，在声明时指定具体类型
 */
public class ceshi {
    public static void main(String [] args){
        Student<Integer> stu= new Student<Integer>();
        stu.setJavese(80);
    }
}
