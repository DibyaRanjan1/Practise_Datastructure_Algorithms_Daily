package LeetCode_Top_150.LinkedListPrograms;

public class MergeTwoSortedList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null &&list2==null) return null;
        if(list1 ==null) return list2;
        if(list2==null) return list1;


        ListNode tempList1 = list1;
        ListNode tempList2 = list2;

        ListNode head = new ListNode(-101);
        ListNode dummy = head;



        while (tempList1!=null || tempList2 !=null){
            if(tempList1.val <= tempList2.val){
              dummy.next = tempList1;
              tempList1 = tempList1.next;
              dummy = dummy.next;
            }else {
                dummy.next = tempList2;
                tempList2 = tempList2.next;
                dummy = dummy.next;
            }
        }

        if (tempList1==null){
            dummy.next = tempList2;
        }

        if (tempList2!=null){
            dummy.next = tempList1;
        }
        return head.next;

    }
}
