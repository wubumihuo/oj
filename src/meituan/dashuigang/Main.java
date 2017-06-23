package meituan.dashuigang;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int t=in.nextInt();
        int c=in.nextInt();
        int arrt[]=new int[n];
        int arrc[]=new int[n];
        boolean small_flag=false;
        boolean larger_flag=false;
        boolean equal_flag=false;
        for(int i=0;i<n;i++){
            arrt[i]=in.nextInt();
            if(arrt[i]<t) small_flag=true;
            else if(arrt[i]>t) larger_flag=true;
            else equal_flag=true;
            arrc[i]=in.nextInt();
        }
        if((small_flag&&larger_flag)||(equal_flag&&(small_flag||larger_flag))) System.out.println("Impossible");
        else{
            if(equal_flag){
                System.out.println("Possible");
                System.out.println(new DecimalFormat("#.0000").format(c));
            }
            if(larger_flag){
                boolean flag=true;
                int min=Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                    if(arrt[i]<min) min=arrt[i];
                }
                double sum=c;
                for(int i=0;i<n;i++){
                    if(arrt[i]==min) continue;
                    sum=sum-(double)(arrt[i]*arrc[i]-arrc[i]*min)/(double)(min-t);
                    if(sum<0) {
                        flag=false;
                        System.out.println("Impossible");
                        break;
                    }
                }
                if(flag){
                    System.out.println("Possible");
                    System.out.println(new DecimalFormat("#.0000").format(min));
                }
            }
            else{
                boolean flag=true;
                int max=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    if(arrt[i]>max) max=arrt[i];
                }
                double sum=c;
                for(int i=0;i<n;i++){
                    if(arrt[i]==max) continue;
                    sum=sum-(double)(arrt[i]*arrc[i]-arrc[i]*max)/(double)(max-t);
                    if(sum<0) {
                        flag=false;
                        System.out.println("Impossible");
                        break;
                    }
                }
                if(flag){
                    System.out.println("Possible");
                    System.out.println(new DecimalFormat("#.0000").format(max));
                }
            }
        }

    }
}
