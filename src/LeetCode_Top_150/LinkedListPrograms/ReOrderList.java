package LeetCode_Top_150.LinkedListPrograms;

import java.util.HashMap;

public class ReOrderList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReOrderList r = new ReOrderList();
        r.reorderList(head);
    }

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;

        ListNode next = null;
        ListNode prev = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second.next!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            first = firstNext;

            second.next = first;
            second = secondNext;
        }
    }
}
