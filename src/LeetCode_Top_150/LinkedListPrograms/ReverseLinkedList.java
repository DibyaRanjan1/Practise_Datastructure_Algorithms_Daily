package LeetCode_Top_150.LinkedListPrograms;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList r = new ReverseLinkedList();
        r.reverseList_Recursive(head);
    }

    public ListNode reverseList(ListNode head) {

        if(head ==null) return null;

         ListNode curr = head;
         ListNode next = null;
         ListNode prev = null;

         while (curr!=null){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
    }

    public ListNode reverseList_Recursive(ListNode head){

        if(head ==null || head.next ==null){
            return head;
        }
        ListNode currNode = reverseList_Recursive(head.next);
        head.next.next = head;
        head.next =null;
        return currNode;
    }
}
