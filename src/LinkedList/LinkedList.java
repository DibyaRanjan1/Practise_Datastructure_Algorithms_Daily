package LinkedList;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LinkedList {


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(9);


        Node head1 = new Node(11);
        head1.next = new Node(12);
        head1.next.next = head.next.next.next;



     // Node newLinkedList =   RemoveDuplicate(head);

       // removeLoopOptimize(head);

       // removeDuplicateUnsortedOptimize(head);

       // DeleteNode(head.next.next);

       // addOne(head);

        intersectPoint(head,head1);
    }

    public static boolean detectLoop(Node head){
        // Add code here
        Node fast = head;
        Node slow = head;


        while(slow !=null && fast !=null && fast.next !=null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) { return true;}
        }
        return false;
    }

    public static Node ReverseLinkedList(Node head){

        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

public static   Node RemoveDuplicate(Node head){


    Node current = head;


        while(current !=null && current.next !=null){

            if(current.data == current.next.data){

                current.next = current.next.next;
            }
            else {
                current = current.next;
            }

        }

        return current;
}
    public static void RemoveLoop(Node head){
       Node slow = head;
       Node fast = head;
       Node prev = null;

        HashMap<Node, Boolean> h1 = new HashMap<Node, Boolean>();

       while(fast !=null && fast.next !=null){

           if(!h1.containsKey(slow)){
               h1.put(slow, true);
           }
           else {
               prev.next = null;
               return;
           }
            prev = slow;
           slow = slow.next;
           fast = fast.next.next;

       }
    }

    public static void removeLoopOptimize(Node head){

        //using two pointers and moving one pointer(slow) by one node and
        //another pointer(fast) by two nodes in each iteration.
        Node fast = head.next;
        Node slow = head;

        while( fast!=slow )
        {
            //if the node pointed by first pointer(fast) or the node
            //next to it is null, then loop is not present so we return 0.
            if( fast==null || fast.next==null )
                return;

            fast = fast.next.next;
            slow = slow.next;
        }
        //both pointers now point to the same node in the loop.

        int size = 1;
        fast = fast.next;
        //we start iterating the loop with first pointer and continue till
        //both pointers point to same node again.
        while( fast!=slow )
        {
            fast = fast.next;
            //incrementing the counter which stores length of loop..
            size+=1;
        }

        //updating the pointers again to starting node.
        slow = head;
        fast = head;

        //moving pointer (fast) by (size-1) nodes.
        for(int i=0; i<size-1; i++)
            fast = fast.next;

        //now we keep iterating with both pointers till fast reaches a node such
        //that the next node is pointed by slow. At this situation slow is at
        //the node where loop starts and first at last node so we simply
        //update the link part of first.
        while( fast.next != slow )
        {
            fast = fast.next;
            slow = slow.next;
        }
        //storing null in link part of the last node.
        fast.next = null;
    }

    public static boolean isPalindromeNaive(Node head){
        Stack<Integer> s1 = new Stack<Integer>();


        Node current = head;

        while (current !=null){

            if(s1.contains(current.data)){
                s1.pop();
            }
            else{
                s1.push(current.data);
            }
            current = current.next;
        }

        if(s1.isEmpty() || s1.size() ==1) return true;
        return false;
    }
    public static boolean isPalindrome(Node head) {

        Node slow = head;
        Node fast = head;

        Stack<Integer> s1 = new Stack<Integer>();

        while(slow!=null){
            s1.push(slow.data);
            slow = slow.next;
        }

        while (head!=null){

           int data =   s1.pop();
           if(head.data != data){
               return false;
           }
        }

        return true;

    }

    public static Node removeDuplicatesUnsorted(Node head)
    {

        Node current = head;

        HashSet<Integer> h1 = new HashSet<Integer>();
        h1.add(head.data);

        while(current !=null && current.next !=null && current.next.next !=null){

            if(!h1.contains(current.next.data)){
                h1.add(current.next.data);
                current = current.next;
            }else {
                current.next = current.next.next;
            }
        }
        return head;
    }

    public static Node removeDuplicateUnsortedOptimize(Node head){
        Node current = head;
        Node prev = null;
        HashSet<Integer> h1 = new HashSet<Integer>();

        while (current !=null){

            if(h1.contains(current.data)){
                prev.next = current.next;
                current = null;


            } else {
                h1.add(current.data);

                prev = current;
            }

            current = prev.next;

        }
        return head;
    }

    public static void DeleteNode(Node del){

        Node prev = null;
        Node next = null;
        Node current = del;

        while(current !=null && current.next !=null){
            prev = current;
            next = current.next;
            current.data = next.data;
            next.data = prev.data;
            current = current.next;

        }
        prev.next = null;


    }

    // Not working with all edge cases
    public static Node addOne(Node head){
        Node current = head;
        long digitCount = 0;
        long newDigCount = 0;
        long number = 0;

        while (current!=null){

            current = current.next;
            digitCount ++;
        }
        current = head;
        newDigCount = digitCount-1;
        while(current!=null){
            number =number + (long) (current.data * (Math.pow(10,digitCount-1)));
            -- digitCount;
            current = current.next;
        }
        number = number +1;
        Node newHead = null;
        while (number >0){
            int reminder = (int)number%10;
            Node n = new Node(reminder);
            n.next = newHead;
            newHead = n;

            number = number/10;

        }

        return newHead;
    }

    public static int intersectPoint(Node head1, Node head2){
        Node current1 = head1;
        Node current2 = head2;
        int currentCount1 = 0;
        int currentCount2 = 0;
        Node current = null;

        while(current1!=null){
            currentCount1 ++;
            current1 = current1.next;
        }

        while(current2!=null){
            currentCount2 ++;
            current2 = current2.next;
        }
        current1 = head1;
        current2 = head2;

        if(currentCount1 < currentCount2){
            Node temp = current2;
            current2 = current1;
            current1 = temp;

        }

        int resultNodeCount = 0;
        int commonCount = Math.abs(currentCount1 - currentCount2);
        while (current1!=null && current2!=null){

            if( commonCount <= resultNodeCount){
                if(current1 == current2){
                    return current1.data;
                }
                current2 = current2.next;
            }
            resultNodeCount++;
            current1 = current1.next;
        }
        return -1;
    }

}


