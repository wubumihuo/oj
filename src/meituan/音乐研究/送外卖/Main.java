package meituan.音乐研究.送外卖;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++) a[i]=in.nextInt();
        for(int i=0;i<n;i++) b[i]=in.nextInt();
    }
}
