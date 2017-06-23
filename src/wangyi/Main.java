package wangyi;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int taxiNum=in.nextInt();
        int taxi_x[] =new int[taxiNum];
        int taxi_y[]=new int[taxiNum];
        for(int i=0;i<taxiNum;i++)
            taxi_x[i]=in.nextInt();
        for(int i=0;i<taxiNum;i++)
            taxi_y[i]=in.nextInt();
        int arr_x=in.nextInt();
        int arr_y=in.nextInt();
        int walkTime=in.nextInt();
        int taxiTime= in.nextInt();
        int mincost = walkTime * (Math.abs(arr_x) +Math.abs(arr_y));
        for(int i=0;i<taxiNum;i++){
            int walktotal = walkTime*(Math.abs(taxi_x[i]) +Math.abs(taxi_y[i]));
            int taxitotal = taxiTime*(Math.abs(taxi_x[i]-arr_x) +Math.abs(taxi_y[i]-arr_y));
            int total = walktotal+taxitotal;
            if(total<mincost) mincost=total;
        }
        System.out.println(mincost);

    }
}
