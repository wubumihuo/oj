package WAP;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/5/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        if(helpsolve(m,arr,0,0)) System.out.println("Yes");
        else System.out.println("No");

    }
    public static boolean helpsolve(int m, int arr[],int index,long sum) {
        if(index==arr.length) return sum>0&&sum%(long)m==0;
        if(sum>0&&sum%(long)m==0) return true;
        if(helpsolve(m,arr,index+1,sum+arr[index])) return true;
        else if(helpsolve(m,arr,index+1,sum)) return true;
        else return false;
    }


}

