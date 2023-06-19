package LinkedList;

public class LinkedList {


    public static void main(String[] args) {

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


}
