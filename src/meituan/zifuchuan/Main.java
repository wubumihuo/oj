package meituan.zifuchuan;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T= in.nextInt();
        String str = in.nextLine();
        for(int i=0;i<T;i++){
            String A=in.nextLine();
            String B=in.nextLine();
            int alen=longestPalindrome(new String(A+B)).length();
            int blen=longestPalindrome(new String(B+A)).length();
            System.out.println(alen>blen?alen:blen);
        }
    }
    public static String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
            if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
