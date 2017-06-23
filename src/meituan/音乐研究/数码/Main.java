package meituan.音乐研究.数码;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result[] = new int[9];
        for(int i=l;i<=r;i++){
            getResult(result,i);
        }
        for(int i=0;i<9;i++){
            System.out.println(result[i]);
        }
    }
    public static void getResult(int []result,int n){
     //   int max=(int)Math.floor(Math.sqrt(n));
        for(int i=1;i<=n;i++){
            if(n%i==0) {
                writeResult(result,i);
            }
        }
//        if(n>1)
//        writeResult(result,n);
    }
    public static void writeResult(int []result ,int x){
        while(x>=10){
            x/=10;
        }
        result[x-1]++;
    }
}
