package leetcode;

import leetcode.NodePerform.ListNode;

/**
 * Created by mazhi on 2016/12/26.
 */
public class Plindrome {
    /*No:409
    * Input:"abccccdd"
    * return 7 ;"dccaccd", whose length is 7.
    * */
    public int longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        char[] charArray = new char[60];
        for (int i = 0; i < len; i++) {
            charArray[s.charAt(i) - 'A']++;
        }
        int single_flag = 0;
        for (int i = 0; i < 60; i++) {
            maxLen += charArray[i] / 2 * 2;
            if (charArray[i] % 2 > 0) single_flag = 1;
        }
        return maxLen + single_flag;
    }

    /*
    * Palindrome Number
    * */
    public boolean isPalindrome(int x) {
        return false;
    }
    /*No:234
    * Given a singly linked list, determine if it is a palindrome.
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;


    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next ;
            head.next = prev;
            prev =head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
//        NodePerform node = new NodePerform();
//        NodePerform.ListNode Head = node.new ListNode(-1);
//        Head.next = node.new ListNode(-1);
        //Head.next.next = node.new ListNode(2);
    //    System.out.println(isPalindrome(Head));
    }

}
