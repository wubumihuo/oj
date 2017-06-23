package leetcode;

import java.util.Scanner;

/**
 * Created by mazhi on 2016/9/29.
 */
public class Wireless_Routers {
    public void solution() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sa=new int[n];//满意度数组
        for(int k=0;k<n;k++)
        {
            sa[k]=sc.nextInt();
        }
        boolean[][] re = new boolean[n][n];
        for(int k=0;k<n;k++){
            for(int l=0;l<n;l++){
                re[k][l]=false;
            }
        }
        for(int k=0;k<n-1;k++){
            int i=sc.nextInt()-1;
            int j=sc.nextInt()-1;
            re[i][j] = true;
            re[j][i] =true;
        }


    }
}
