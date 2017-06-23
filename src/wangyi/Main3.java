package wangyi;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/25.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=in.nextInt();
        int k_num=in.nextInt();
        int [] arr=new int[count];
        for(int i=0;i<count;i++){
            arr[i]=in.nextInt();
        }
        for(int i=0;i<k_num;i++){
            getChange(arr);
        }
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print(arr[arr.length-1]);
    }
    public static void getChange(int arr[]){
        int length=arr.length;
        int temp=arr[0];
        for(int i=0;i<length-1;i++){
            arr[i]+=arr[i+1];
            if(arr[i]>=100) arr[i]=arr[i]%100;
        }
        arr[length-1]+=temp;
        if(arr[length-1]>=100) arr[length-1]=arr[length-1]%100;
    }
}
