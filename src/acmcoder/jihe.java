package acmcoder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by mazhi on 2017/4/6.
 */
public class jihe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0;i<n;i++){
                set.add(in.nextInt());
            }
            for(int i=0;i<m;i++){
                set.add(in.nextInt());
            }
            for(int a : set) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
