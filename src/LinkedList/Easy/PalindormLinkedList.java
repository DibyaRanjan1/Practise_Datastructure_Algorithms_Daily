package LinkedList.Easy;

import LeetCode_Top_150.LinkedListPrograms.ListNode;

import java.util.Stack;

public class PalindormLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindormLinkedList p = new PalindormLinkedList();
        p.isPalindrome_optimal(head);
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode dummy = head;

        while (dummy!=null){
            stack.push(dummy.val);
            dummy = dummy.next;
        }

        while (head!=null){
           if(head.val != stack.pop()){
               return false;
           }
           head = head.next;
        }

        return true;
    }

    public boolean isPalindrome_optimal(ListNode head) {

        if(head==null) return true;

      ListNode endOfFirstHalf = GetEndOfFirstHalf(head);
      ListNode secondHalfStart = ReverseSecondHalf(endOfFirstHalf.next);

      boolean isPalindrome = true;

      ListNode p1 = head;
      ListNode p2 = secondHalfStart;


      while (isPalindrome && p2!=null ){
         if(p1.val!=p2.val) isPalindrome =false;
         p1 = p1.next;
         p2 = p2.next;
      }

     endOfFirstHalf.next = ReverseSecondHalf(secondHalfStart);
      return isPalindrome;

    }

    private ListNode GetEndOfFirstHalf(ListNode node){
        ListNode first = node;
        ListNode slow = node;

        while (first.next!=null && first.next.next!=null){
            first = first.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode ReverseSecondHalf(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
