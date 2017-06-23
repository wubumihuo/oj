package toutiao;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class 或与加 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextInt();
        int k = in.nextInt();
        long tmp = 1;
        int size = getBitCount(k);
        long[] single = new long[size];
        for (int i = 0; i < size; i++) {
            while ((x & tmp) > 0) {
                tmp=tmp << 1;
            }
            single[i] = tmp;
            tmp=tmp << 1;
        }
        long result=0;//结果
        while(k>0){
            result+=single[size-1];
            k=k-(int)Math.pow(2,size-1);
            size=getBitCount(k);
        }
        System.out.println(result);
    }

    public static int getBitCount(int k) {
        int i = 1;
        while (Math.pow(2, i) - 1 < k) {
            i++;
        }
        return i;
    }
}
