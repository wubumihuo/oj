package weizhong;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int x[] = new int[n];
            long m[] = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                m[i] = in.nextLong();
            }
            int odd_even = 0;
            for(int i=0;i<n;i++){
                if(m[i]%2==0) odd_even+=0;
                else {
                    if(x[i]%2==0) odd_even+=0;
                    else odd_even+=1;
                }
            }
            if(odd_even%2 ==0) System.out.println("second");
            else System.out.println("first");
        }
    }
}
