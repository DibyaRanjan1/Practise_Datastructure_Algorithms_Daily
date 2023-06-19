package LinkedList;

public class FindMiddle {

    public static void main(String[] args) {

    }

    int getMiddle(Node head)
    {
        // Your code here.
        Node temp = head;
        int count = 0;
        int middleCount = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        while(middleCount != (count/2)){
            temp = temp.next;
            middleCount++;
        }
        return temp.data;
    }
    int getMiddleOptimize(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
