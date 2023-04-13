package Queue;

public class MyQueue {
    int capacity, size, front, rear;
    int[] array;
     public MyQueue(int capacity){
         this.capacity = capacity;
         array = new int[capacity];
         size = 0;
         this.front = 0;
         this.rear = 0;
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
             return -1;
        return 0;
     }

     public int getRear(){
         if(isEmpty()){
             return -1;
         }
         return size-1;
     }

     public void enQueue(int item){
       if (isFull()){
           return;
       }
       array[size] = item;

        ++size;
     }

     public void deQueue(){
         if(isEmpty()){
             return;
         }
         for(int i=0;i< array.length-1;i++){
             array[i] = array[i+1];
         }
         --this.size;
     }
}
