package gongsi.codem;

import java.util.Scanner;

/**
 * Created by 60433 on 2017/6/25.
 */
//合并字符串
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int len[]=new int[4];
            String a = in.next();
            String b=in.next();
            String c=a+b;
            for(int j=0;j<c.length();j++){
                if(c.charAt(j)=='A') len[0]++;
                else if(c.charAt(j)=='C') len[1]++;
                else if(c.charAt(j)=='G') len[2]++;
                else if(c.charAt(j)=='T') len[3]++;
            }
            System.out.println(helper(a,b,len));
        }

    }
    public static int helper(String a,String b,int arr[]){
        int max=0;
        int width=a.length()+1,height=b.length()+1;
        int dp[][]=new int[width][height];
        int A[][]=new int[width][height];
        int C[][]=new int[width][height];
        int G[][]=new int[width][height];
        int T[][]=new int[width][height];
        dp[0][0]=0;
        A[0][0]=0;
        C[0][0]=0;
        G[0][0]=0;
        T[0][0]=0;
        for(int i=1;i<width;i++){
            char ch=a.charAt(i-1);
            A[i][0]=A[i-1][0];
            C[i][0]=C[i-1][0];
            G[i][0]=G[i-1][0];
            T[i][0]=T[i-1][0];
            if(ch=='A') {
                if(arr[0]-2*A[i-1][0]>1) A[i][0]=A[i-1][0]-1;
            }
            else if(ch=='C') {
                if(arr[1]-2*C[i-1][0]>1) C[i][0]=C[i-1][0]+1;
            }
            else if(ch=='G') {
                if(arr[2]-2*G[i-1][0]>1) G[i][0]=G[i-1][0]+1;
            }
            else  {
                if(arr[3]-2*T[i-1][0]>1) T[i][0]=T[i-1][0]+1;
            }
            dp[i][0]=A[i][0]+C[i][0]+G[i][0]+T[i][0];
            max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<width;i++) {
            for (int j = 1; j < height; j++) {
                char ch = a.charAt(j-1);
                A[i][j] = A[i][j - 1];
                C[i][j] = C[i][j - 1];
                G[i][j] = G[i][j - 1];
                T[i][j] = T[i][j - 1];
                if (ch == 'A') {
                    if (arr[0] - 2 * A[i][j - 1] > 1) A[i][j] = A[i][j - 1] + 1;
                } else if (ch == 'C') {
                    if (arr[1] - 2 * C[i][j - 1] > 1) C[i][j] = C[i][j - 1] + 1;
                } else if (ch == 'G') {
                    if (arr[2] - 2 * G[i][j - 1] > 1) G[i][j] = G[i][j - 1] + 1;
                } else {
                    if (arr[3] - 2 * T[i][j - 1] > 1) T[i][j] = T[i][j - 1] + 1;
                }
                dp[i][j] = A[i][j] + C[i][j] + G[i][j] + T[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
