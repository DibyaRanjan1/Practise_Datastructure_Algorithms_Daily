package LinkedList;

public class NthFromLast {
    public static void main(String[] args) {
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);

       getNthFromLast(head,3);
    }

    // Naive approach
    static int  getNthFromLast(Node head, int n)
    {
        Node temp = head;
        Node currentTemp = head;
        int count = 0;
        int resultCount = 0;
        // Your code here
           while(temp.next!=null){
              temp = temp.next;
              ++count;
           }
           if(n > count) return -1;

        while(currentTemp.next!=null && resultCount !=count ){
            currentTemp = currentTemp.next;
            ++resultCount;
        }
        return currentTemp.data;
    }

    static int  getNthFromLastOptimize(Node head,int n){

        Node currentNode = head;
        Node nthNode = head;
        int number = n;

        while(number >0){
            if(currentNode == null) return -1;
            currentNode = currentNode.next;
            --number;
        }

        while(currentNode !=null){
            nthNode = nthNode.next;
            currentNode = currentNode.next;
        }

        return nthNode.data;
    }
}
