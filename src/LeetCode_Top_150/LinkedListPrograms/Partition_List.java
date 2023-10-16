package LeetCode_Top_150.LinkedListPrograms;

public class Partition_List {
    public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);

    Partition_List p = new Partition_List();
    p.partition(head,3);
    }

    public ListNode partition(ListNode head, int x) {
      ListNode leftHead = new ListNode(-101);
      ListNode rightHead = new ListNode(-102);


       ListNode leftDummy = leftHead;
       ListNode rightDummy = rightHead;

      ListNode curr = head;
      while (curr!=null){
          if(curr.val < x){
              leftDummy.next = new ListNode(curr.val);
              leftDummy = leftDummy.next;
          }else {
              rightDummy.next = new ListNode(curr.val);
              rightDummy = rightDummy.next;
          }

          curr = curr.next;
      }

     leftDummy.next = rightHead.next;


      return leftHead.next;
    }

    public ListNode partition_another(ListNode head, int x) {
        ListNode leftHead = new ListNode(-101);
        ListNode rightHead = new ListNode(-102);


        ListNode leftDummy = leftHead;
        ListNode rightDummy = rightHead;

        ListNode curr = head;
        while (curr!=null){
            if(curr.val < x){
                leftDummy.next = curr;
                leftDummy = leftDummy.next;
            }else {
                rightDummy.next = curr;
                rightDummy = rightDummy.next;
            }

            curr = curr.next;
        }

        rightDummy.next = null;
        leftDummy.next = rightHead.next;


        return leftHead.next;
    }
}
