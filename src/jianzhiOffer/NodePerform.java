package jianzhiOffer;

/**
 * Created by mazhi on 2017/3/30.
 */
public class NodePerform {
    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null) return null;
        if(k<1) return null;
        return head;
    }
    //在一个排序的链表中，存在重复的结点，
    // 请删除该链表中重复的结点，重复的结点不保留，
    // 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode last =first;
        while(p!=null && p.next !=null){
            if(p.val ==p.next.val){
                int val = p.val;
                while(p!=null &&p.val ==val) p=p.next;
                last.next =p;
            }else {
                last = p;
                p=p.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
       ListNode newnode = deleteDuplication(node);
    }


}
