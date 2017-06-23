package jianzhiOffer;

/**
 * Created by mazhi on 2017/3/29.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
    public static int Fibonacci(int n) {
        if(n<1) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        int a1=1,a2=1;
        int a3=0;
        for(int i=3;i<=n;i++){
            a3=a1+a2;

            a1=a2;
            a2=a3;
        }
        return a3;
    }
}
