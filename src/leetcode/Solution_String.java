package leetcode;

import java.util.Stack;

/**
 * Created by mazhi on 2016/11/28.
 */
public class Solution_String {
    public static void main(String[] args) {
        String str= "(()(((()";
        System.out.println(longestValidParentheses(str));

    }

    /*No:32. Longest Valid Parentheses
    * ")()())"  the longest valid parentheses substring is "()()"  has length = 4.
    * */
    public static int longestValidParentheses(String s) {
//        if(s.length()<2) return 0;
//        int i=0,reMax=0;
//        int lastSubLength =0 ,nowSubLength=0;
//        int isValidLeft= 0;
//        int left=0;
//        while(i<s.length()){
//            if(s.charAt(i)=='(') isValidLeft++;
//            else if(isValidLeft>0) {
//                isValidLeft--;
//                nowSubLength+=2;
//                if(isValidLeft==0){
//                    lastSubLength+=nowSubLength;
//                    nowSubLength=0;
//                    reMax=Math.max(reMax,lastSubLength);
//                }
//               else reMax=Math.max(reMax,nowSubLength);
//            }
//            else {
//                left=0;
//            }
//            i++;
//        }
//        return reMax;
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}

