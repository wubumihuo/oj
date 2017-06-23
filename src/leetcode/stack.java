package leetcode;

import java.util.*;

/**
 * Created by mazhi on 2016/10/12.
 */
public class stack {
    //Valid Parentheses
//    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    /*NO:224. Basic Calculator
    * Implement a basic calculator to evaluate a simple expression string.
    * The expression string may contain open ( and closing parentheses ),
    * the plus + or minus sign -, non-negative integers and empty spaces .
    * */
    public int calculate(String s) {
        //step 1,去除空格
        s.replace(" ", "");
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum*sign;
            } else if (s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i)=='-') sign=-1;
            else if(s.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                result=result*stack.pop()+stack.pop();
            }
        }
        return result;
    }

    /*NO;227. Basic Calculator II
    * Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators
and empty spaces . The integer division should truncate toward zero.
    * */


    public static void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (s.equals("-")) stack.push(-(stack.pop() - stack.pop()));
            else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }

    /*No:42 Trapping Rain Water
    * */
    public int trap(int[] height) {
        return 0;
    }


    public static void main(String[] args) {
//      String str="dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        System.out.println(lengthLongestPath(str));
        String[] arr = {"4", "13", "5", "/", "+"};
        evalRPN(arr);

    }
}
