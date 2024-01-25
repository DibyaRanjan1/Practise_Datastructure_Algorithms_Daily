package LeetCode_Top_150.DivideConqure;

import LeetCode_Top_150.LinkedListPrograms.ListNode;

public class SortList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {

        if(head==null || head.next ==null) return head;

       ListNode mid =  findMid(head);

       ListNode left = sortList(head);
      ListNode right = sortList(mid);

       return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode();
        ListNode dummyTail = dummyHead;

        while (left!=null && right!=null){
            if(left.val < right.val){
                dummyTail.next = left;
                dummyTail = dummyTail.next;
                left = left.next;
            }else {
                dummyTail.next = right;
                dummyTail = dummyTail.next;
                right = right.next;
            }
        }

        if(left!=null) dummyTail.next = left;
        else dummyTail.next = right;

        return dummyHead.next;
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        return temp;
    }
}
