package LeetCode_Top_150.LinkedListPrograms;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNode r = new RemoveNthNode();
        r.removeNthFromEnd(head,2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode firstNode = dummyNode;
        ListNode secondNode = dummyNode;

        for(int i=0;i<=n;i++){
            firstNode = firstNode.next;
        }

        if(firstNode==null) return head.next;

        while (firstNode!=null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        return dummyNode.next;
    }
}
