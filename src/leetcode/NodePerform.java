package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mazhi on 2016/7/6.
 */
public class NodePerform {
    public static class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    //Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //Remove all elements from a linked list of integers that have value val.
    // Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    // Return: 1 --> 2 --> 3 --> 4 --> 5
    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);  //定义一个前节点
        helper.next = head;
        ListNode p = helper;
        while (p.next != null) {
            if (p.next.val == val) {
                ListNode next = p.next;
                p.next = next.next;
            } else {
                p = p.next;
            }
        }
        return helper.next;
    }

    //Reverse a singly linked list.
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode new_head = new ListNode(0);
//        ListNode curr = new_head;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            int val1 = 0;
//            if (l1 != null) {
//                val1 = l1.val;
//                l1 = l1.next;
//            }
//            int val2 = 0;
//            if (l2 != null) {
//                val2 = l2.val;
//                l2 = l2.next;
//            }
//            int temp = val1 + val2 + carry;
//            curr.val = temp % 10;
//            carry = temp / 10;
//            curr = curr.next;
//        }
//        if (carry > 0) {
//            curr.val = 1;
//        }
//        return new_head;
//    }

    /*No:24
    * Swap Nodes in Pairs
    *
    * Given 1->2->3->4, you should return the list as 2->1->4->3.
*/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reHead = head.next;
        ListNode temp;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (prev.next != null) {
            head = prev.next;
            if (head.next == null) break;
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            prev.next = temp;
            prev = head;
        }
        return reHead;
    }

    /*No:25 Reverse Nodes in k-Group
    *Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5
     *  */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode reHead = new ListNode(0);
        if (!isExist(head, k, reHead)) return head;
        //上个周期序列最后一个
        ListNode prev = new ListNode(0);
        //给即将开始的一个周期序列 最后一个
        ListNode last = new ListNode(0);
        //下一个位置的node
        ListNode nextPosi = new ListNode(0);
        //下一个要改的位置
        ListNode nextChan = new ListNode(0);
        prev.next = head;
        while (isExist(prev.next, k, last)) {
            head = prev.next;
            prev.next = last;
            nextChan = head;
            nextPosi = last.next;
            for (int i = 0; i < k; i++) {
                head = head.next;
                nextChan.next = nextPosi;
                nextPosi = nextChan;
                nextChan = head;
            }
        }
        return reHead;

    }

    public static boolean isExist(ListNode head, int k, ListNode temp) {
        temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return false;
            else if (i < k - 1) temp = temp.next;
        }
        return true;
    }

    /*No:19. Remove Nth Node From End of List
    *Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
    * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    /*No:83Remove Duplicates from Sorted List
    * Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
    * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }

    /*No:21. Merge Two Sorted Lists
    Merge two sorted linked lists and return it as a new list.
     The new list should be made by splicing together the nodes of the first two lists.
    * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //我的代码
//        if(l1==null) return l2;
//        if(l2==null) return l1;
//        ListNode temp;
//        //当前l1比较的位置
//        ListNode curr_posi;
//        if(l2.val<l1.val){
//            temp = l2;
//            l2=l1;
//            l1=temp;
//        }
//        curr_posi = l1;
//        while(l2!=null){
//            while( curr_posi.next!=null && curr_posi.next.val < l2.val ) curr_posi = curr_posi.next;
//           temp =l2.next;
//            l2.next = curr_posi.next;
//            curr_posi.next= l2;
//            l2=temp;
//        }
//        return l1;
        //递归
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*No：445. Add Two Numbers II
    *Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    * Output: 7 -> 8 -> 0 -> 7
    * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1!= null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val==0?list.next :list;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(7);
        list1.next =new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next =new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        addTwoNumbers(list1,list2);
    }
}
