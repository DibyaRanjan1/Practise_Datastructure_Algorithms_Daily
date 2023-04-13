package Heap;

public class MinHeap {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);
        minHeap.arr[0] = 10;
        minHeap.arr[1] = 20;
        minHeap.arr[2] = 15;
        minHeap.arr[3] = 40;
        minHeap.arr[4] = 50;
        minHeap.arr[5] = 100;
        minHeap.arr[6] = 25;
        minHeap.arr[7] = 45;

        minHeap.size = 8;

        minHeap.Insert(12);

        for (int i = 0; i< minHeap.arr.length-1 ; i++){
            System.out.println(minHeap.arr[i]);
        }


    }
    public int[] arr;
    int size;
    int capacity;
    MinHeap(int capacity){
       arr = new int[capacity];
this.size = size;
this.capacity = capacity;
    }

    public int Left(int i){
        return (2*i+1);
    }

    public int Right(int i){
        return (2*i+2);
    }

    public int Parent(int i){
        return Math.abs((i-1)/2);
    }

    public void Insert(int x){
        if(size == capacity){
            return;
        }
        this.size ++ ;
        arr[size-1] = x;
for(int i=size-1; i !=0 && ( arr[Parent(i)] > arr[i] );){
    int parentIndex = Parent(i);
int temp = arr[parentIndex];
    arr[parentIndex] = arr[i];
    arr[i] = temp;
    i = parentIndex;
}

    }
}
