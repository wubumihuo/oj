package meituan.音乐研究.锦标赛;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int arr[] = new int[n];
        int larger_count =0;
        arr[0]=in.nextInt();
        for(int i=1;i<n;i++){
            arr[i]=in.nextInt();
            if(arr[i]>arr[0]) larger_count++;
        }
        int all = n;
        int result=-1;
        int small_count=n-larger_count;
        while(small_count>0){
            result++;
            small_count=small_count>>1;
        }
//        while(all-larger_count>=1&&all>0){
//            result++;
//            all=all>>1;
//            larger_count=(larger_count&1)+larger_count>>1;
//        }
        System.out.println(result);
    }
}
