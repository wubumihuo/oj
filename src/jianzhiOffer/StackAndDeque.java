package jianzhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mazhi on 2017/3/27.
 */
public class StackAndDeque {
    //    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
// 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num.length < size || size < 1) return list;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) q.add(i);
            else if (begin > q.peekFirst()) q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0) list.add(num[q.peekFirst()]);
        }
        return list;
    }

    //    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        int a = stack2.pop();
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return a;
    }

    //输入两个整数序列，第一个序列表示栈的压入顺序，
    // 请判断第二个序列是否为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
    // 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
    // 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    // （注意：这两个序列的长度是相等的）
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while(j<popA.length) {
            if (stack.empty()||popA[j] != stack.peek()) {
                if (i < pushA.length) {
                    stack.push(pushA[i]);
                    i++;
                }
                else return false;
            } else {
                stack.pop();
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int b[]={4,3,5,1,2};
        System.out.println(IsPopOrder(a,b));
    }
}
