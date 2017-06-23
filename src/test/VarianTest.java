package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * Created by mazhi on 2017/3/11.
 */
public class VarianTest {
    public static int staticVar = 0;
    public int instanceVar = 0;
    private final char[] value;

    public VarianTest() {
        value = new char[4];
        value[0] = 1;
        staticVar++;
        instanceVar++;
        System.out.println("staticVar=" + staticVar + ",instanceVar=" +
                instanceVar);
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "edf";
        System.out.println(a.concat(b));
        Integer i = new Integer(10);
        i = 5;
    }

    public char[] toCharArray() {
        return value;
    }
}
