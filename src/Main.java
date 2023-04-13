import Queue.MyQueue;
import Queue.MyQueueUsingCircularArray;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        MyQueue myQueue = new MyQueue(5);
//
//        myQueue.enQueue(1);
//        myQueue.enQueue(2);
//        myQueue.enQueue(3);
//        myQueue.enQueue(4);
//        myQueue.enQueue(5);
//
//        myQueue.deQueue();
//
//        System.out.println("Queue size is :"+ myQueue.getSize());
//        System.out.write(1);

        MyQueueUsingCircularArray myQueueUsingCircularArray = new MyQueueUsingCircularArray(5);

        myQueueUsingCircularArray.enQueue(1);
        myQueueUsingCircularArray.enQueue(2);


       myQueueUsingCircularArray.deQueue();

       myQueueUsingCircularArray.enQueue(3);
       myQueueUsingCircularArray.enQueue(4);
        myQueueUsingCircularArray.enQueue(5);

        System.out.println("Queue size is :"+ myQueueUsingCircularArray.getSize());
        System.out.write(1);
    }
}