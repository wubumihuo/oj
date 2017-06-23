package wangyi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str= in.next();
        char arr[] = str.toCharArray();
        int G_num=0,B_num=0;
        int G_indextotal=0,B_indextotal=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='G') {
                G_num++;
                G_indextotal+=i;
            }
            else{
                B_num++;
                B_indextotal+=i;
            }
        }
        int arr_indextotal=0;
        int B_recount=0,G_recount=0;
        arr_indextotal=(B_num-1)*B_num/2;
        B_recount = Math.abs(B_indextotal-arr_indextotal);
        arr_indextotal=(G_num-1)*G_num/2;
        G_recount = Math.abs(G_indextotal-arr_indextotal);
        System.out.println(Math.min(B_recount,G_recount));
    }
}
