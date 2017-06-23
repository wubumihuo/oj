package toutiao.ques2;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        long a = in.nextLong();
        HashSet set = new HashSet();
        while(a!=0){
            set.add(a);
             a =in.nextLong();
        }
        System.out.println(set.size());
    }
}
