package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mazhi on 2017/3/24.
 */
public class ListPerform {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        int size=stack.size();
        for(int i=0;i<size;i++){
            list.add(stack.pop());
        }
        return  list;
    }
    /*输入两个链表，找出它们的第一个公共结点。*/
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        int len1=1,len2=1;
        ListNode node1 = pHead1,node2=pHead2;
        while(node1.next!=null) {
            node1=node1.next;
            ++len1;
        }
        while(node2.next!=null){
            node2=node2.next;
            ++len2;
        }
        if(node1!=node2) return null;
        ListNode longlist = pHead1;
        ListNode shortlist=pHead2;
        int lendif=len1-len2;
        if(len2>len1){
            longlist=pHead2;
            shortlist=pHead1;
            lendif=len2-len1;
        }
        for(int i=0;i<lendif;i++){
            longlist=longlist.next;
        }
        while(longlist!=null&&shortlist!=null){
            if(longlist==shortlist) break;
            longlist=longlist.next;
            shortlist=shortlist.next;
        }
        return longlist;
    }
    /*输入一个复杂链表（每个节点中有节点值，以及两个指针，
    一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。（注意，输出结果中请
    不要返回参数中的节点引用，否则判题程序会直接返回空）*/
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //复制next
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next=pCur.next;
            pCur.next=node;
            pCur=node.next;
        }
        //复制random
        pCur=pHead;
        while(pCur!=null){
            if(pCur.random!=null){
                pCur.next.random=pCur.random.next;
            }
            pCur=pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur=pHead;
        while (pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next=cur.next.next;
            cur=cur.next;
            pCur=pCur.next;
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next =null;
    ListNode(int val){
        this.val = val;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}