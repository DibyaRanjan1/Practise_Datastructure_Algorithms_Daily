package LeetCode_Top_150.LinkedListPrograms;

public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(head.next ==null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow!=fast){
            if(fast ==null || fast.next ==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
