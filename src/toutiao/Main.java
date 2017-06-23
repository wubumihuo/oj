package toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        HashSet set =new HashSet();
        for(int i =0;i<m;i++){
            set.add(in.nextInt());
        }
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            if(set.contains(x)){
                System.out.print(x+" ");
            }
        }
    }
}
