package com.seumazhi.mazhi;

import java.util.List;

/**
 * 非泛型类中定义泛型方法
 * 定义“在返回类型前面
 * Created by mazhi on 2016/12/8.
 */
public class Method {
    public static <T> void test(T t){
        System.out.println(t);
    }

    public static <T extends List> void test (T t){
        System.out.println(t);
        t.add("aaa");
    }
}
