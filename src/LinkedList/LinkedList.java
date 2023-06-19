package LinkedList;

public class LinkedList {


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

      Node newLinkedList =   ReverseLinkedList(head);


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


}
