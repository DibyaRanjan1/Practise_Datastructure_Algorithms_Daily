package LinkedList;

import LeetCode_Top_150.LinkedListPrograms.ListNode;

import java.util.*;

public class MergeKSortedList {
    public static void main(String[] args) {
       MergeKSortedList m = new MergeKSortedList();
       ListNode[] lst = new ListNode[3];

       ListNode fist = new ListNode(1);
       fist.next = new ListNode(4);
       fist.next.next = new ListNode(5);

       lst[0] = fist;

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        lst[1] = second;

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);


        lst[2] = third;


       //m.mergeKLists_approach2(lst);
     ListNode res =   m.mergeKLists_with_priorityQueue(lst);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> tempList = new ArrayList<>();

        for (ListNode node:lists){

          ListNode curr = node;
          while (curr!=null){
              tempList.add(curr.val);
              curr = curr.next;
          }
        }

        Collections.sort(tempList);

        ListNode head = new ListNode(0);

        ListNode newCur = head;

        for(Integer val:tempList){
            ListNode newnode = new ListNode(val);
            newCur.next = newnode;
            newCur = newCur.next;
        }
        newCur.next = null;

        return head.next;
    }

    public ListNode mergeKLists_approach2(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length ==1) return lists[0];

        ListNode head = new ListNode(0);
        ListNode h = head;

         h = mergeTwo(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){

           h =  mergeTwo(h,lists[i]);

        }
        return h;
    }

    private ListNode mergeTwo(ListNode node1,ListNode node2){

        ListNode tempHead = new ListNode(0);
        ListNode curr = tempHead;

        while (node1!=null && node2!=null){
            if(node1.val < node2.val){
                curr.next = node1;
                node1 = node1.next;
            }else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        while (node1!=null){
            curr.next = node1;
            node1 = node1.next;
            curr = curr.next;
        }

        while (node2!=null){
            curr.next = node2;
            node2 = node2.next;
            curr = curr.next;
        }
        return tempHead.next;
    }

    public ListNode mergeKLists_with_priorityQueue(ListNode[] lists) {

        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<>(comp);

        for(ListNode node:lists){

            if(node!=null){
                pq.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (!pq.isEmpty()){

           ListNode curr =   pq.poll();
           h.next = curr;
           h = h.next;

           if(curr.next!=null){
               pq.add(curr.next);
           }
        }
        return head.next;
    }


}
