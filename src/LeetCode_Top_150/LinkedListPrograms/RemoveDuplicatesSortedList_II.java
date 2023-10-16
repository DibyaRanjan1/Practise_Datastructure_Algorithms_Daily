package LeetCode_Top_150.LinkedListPrograms;

public class RemoveDuplicatesSortedList_II {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        RemoveDuplicatesSortedList_II r = new RemoveDuplicatesSortedList_II();
        r.deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-101);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while (curr!=null){
           if(curr.next!=null && curr.val == curr.next.val){
               while (curr.next!=null && curr.val == curr.next.val){
                   curr = curr.next;
               }
               prev.next = curr.next;
           }else {
               prev = prev.next;
           }
           curr = curr.next;
        }
        return dummy.next;
    }
}
