package Queue;

public class MyQueueUsingCircularArray {
    int capacity, size, front;
    int[] array;

    public MyQueueUsingCircularArray(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        size = 0;
        this.front = -1;

    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size ==capacity;
    }

    public int getFront(){
        if(isEmpty())
        {
            front = -1;
            return -1;
        }

        return front;
    }

    public int getRear(){
        if(isEmpty()){
            return -1;
        }
      return   (front + size-1)%capacity;

    }

    public void enQueue(int item){
        if (isFull()){
            return;
        }

        int rear = getRear();
        rear = (rear+1)%capacity;
        array[rear] = item;

        ++size;
    }

    public void deQueue(){
        if(isEmpty()){
            return;
        }
        front = getFront();
        front = (front+1)%capacity;
        --this.size;
    }
}
