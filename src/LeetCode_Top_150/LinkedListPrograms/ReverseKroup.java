package LeetCode_Top_150.LinkedListPrograms;

public class ReverseKroup {
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ReverseKroup r = new ReverseKroup();
     ListNode res = r.reverseKGroup(head,3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i=0;

        while (current!=null){
            i++;
            if(i%k==0){
                 begin = reverse(begin,current.next);
                 current = begin.next;
            }else {
                current = current.next;
            }
        }
        return dummy.next;

    }

    private ListNode reverse(ListNode begin, ListNode end){
        ListNode current = begin.next;
        ListNode next, first;
        ListNode prev=begin;
        first = current;

        while (current!=end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        begin.next = prev;
        first.next = current;
        return first;
    }
}
