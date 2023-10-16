package LeetCode_Top_150.LinkedListPrograms;

public class ReverseLinkedList_II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList_II r = new ReverseLinkedList_II();
        r.reverseBetween(head,2,4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==null || left==right) return head;

        ListNode dummy = new ListNode(-501);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i=1;i<left;i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode currPrev = null;

        for(int i=left;i<=right;i++){
            ListNode next = curr.next;
            curr.next = currPrev;
            currPrev = curr;
            curr = next;
        }

        prev.next.next = curr;
        prev.next = currPrev;

        return dummy.next;
    }
}
