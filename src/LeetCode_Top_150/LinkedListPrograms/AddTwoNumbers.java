package LeetCode_Top_150.LinkedListPrograms;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        int carry=0;

        while (l1!=null && l2!=null){
            int digit1 =l1.val;
            int digit2 = l2.val;

             int sum = digit1+digit2+carry;
            if(sum>=10 ){
                sum =  (sum%10);
                carry = 1;
            }else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            dummy.next = node;
            dummy = dummy.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null){
            int sum =l1.val+carry;
            if(sum>=10 ){
                sum =  (sum%10);
                carry = 1;
            }else {
                carry = 0;
            }
            dummy.next = new ListNode(sum);;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int sum =l2.val+carry;
            if(sum>=10 ){
                sum =  (sum%10);
                carry = 1;
            }else {
                carry = 0;
            }
            dummy.next = new ListNode(sum);;
            dummy = dummy.next;
            l2 = l2.next;
        }

        if(carry ==1){
            dummy.next = new ListNode(1);
        }

        return head.next;
    }

    public ListNode addTwoNumbers_clean(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int carry = 0;

        while (l1!=null || l2!=null || carry!=0){

            int num1=0;
            int num2 = 0;

            if(l1!=null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = (num1+num2+carry)%10;
            carry = (num1+num2+carry)/10;

            dummy.next = new ListNode(sum);
            dummy = dummy.next;
        }
        return head.next;
    }
}
