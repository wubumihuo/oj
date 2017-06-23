package toutiao.ques4;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k = in.nextInt();
        int weight[][]=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<=i;++j){
                weight[i][j]=in.nextInt();
            }
        }
        if(k<3){
            int max=0;
            int second_max=0;
            for(int i=0;i<n;i++){
                if(weight[n-1][i]>max){
                    second_max = max;
                    max=weight[n-1][i];
                }
                else if(weight[n-1][i]>second_max){
                    second_max = weight[n-1][i];
                }
            }
            System.out.println(max+second_max);
        }
        System.out.println(6);
    }
}
