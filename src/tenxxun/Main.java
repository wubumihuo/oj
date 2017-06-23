package tenxxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        int count=0;
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        List<Integer> sushulist = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSushu(i)) sushulist.add(i);
        }
        for(int i=0;i<sushulist.size();i++){
            if(isSushu(n-sushulist.get(i)))
            {
                count++;
            }
        }
        if(isSushu(n/2)&&(n%2==0)) count++;
        System.out.println(count/2);
    }
    public static boolean isSushu(int n){
        if(n<=1) return false;
        for(int i=2;i<n;i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
