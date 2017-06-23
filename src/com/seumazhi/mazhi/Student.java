package com.seumazhi.mazhi;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by mazhi on 2016/12/8.
 * 自定义泛型类
 * <>写单个字母</>
 * T type
 * K V Key Value
 * E Element
 * 不能使用在静态属性上
 */
public class Student<T> {
    private T javese;
    public Student(){

    };
    public Student(T javese){
        this.javese = javese;
    }

    public T getJavese() {
        return javese;
    }

    public void setJavese(T javese) {
        this.javese = javese;
    }
}
