package gongsi.meituan;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by 60433 on 2017/6/23.
 */
public class Main {
    public static void main(String[] args) {
        int a[]={10,22,5,75,65,80};
        System.out.println(countArea(a,6));
    }
    //有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
    //给定数组A及它的大小n，请返回最大差值。
    public static int getDis(int[] A, int n) {
        // write code here
        int max_dis = 0;
        int min = A[0];
        for(int i=1;i<n;i++){
            if(A[i]-min>max_dis) max_dis=A[i]-min;
            if(A[i]<min) min=A[i];
        }
        return max_dis;
    }

    public static int countArea(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[n + 1];
        h = Arrays.copyOf(A, n + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
