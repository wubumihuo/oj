package meituan.音乐研究;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int []arr1=new int[n];

        for(int i=0;i<n;i++){
            arr1[i]=in.nextInt();
        }
        int m =in.nextInt();
        int []arr2=new int[m];
        for(int i=0;i<m;i++){
            arr2[i]=in.nextInt();
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;n-1+i<m;i++){
            int result=getDirrerence(arr1, Arrays.copyOfRange(arr2,i,i+n));
            if(min>result) min=result;
        }
        System.out.println(min);

    }
    public static int getDirrerence(int [] arr1,int []arr2){
        int len=arr1.length;
        int result=0;
        for(int i=0;i<len;i++){
            result+=(arr1[i]-arr2[i])*(arr1[i]-arr2[i]);
        }
        return result;
    }
}
