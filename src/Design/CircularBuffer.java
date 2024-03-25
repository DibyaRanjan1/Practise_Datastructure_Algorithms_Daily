package Design;

public class CircularBuffer {

    private Node head;
    private Node tail;
    private int size;
    private int capacity;


    private class Node{
        int data;
        public Node next;
        public Node(int data){
            this.data = data;
            this.next =null;
        }
    }
    public CircularBuffer(int capacity){
    this.capacity = capacity;
    this.size = size;
    this.head =null;
    this.tail =null;

    }

    public void addData(int data){
       Node newnode = new Node(data);
        if(size==0){
           head = newnode;
           tail =newnode;
           newnode.next =newnode;
        } else if (size<capacity) {
            tail.next =newnode;
            tail =newnode;
            newnode.next =head;
        }else {
            tail.next =newnode;
            tail =newnode;
            head =head.next;
        }
        size = Math.min(size+1,capacity);
    }

    public void displayBuffer(){

    }
}
