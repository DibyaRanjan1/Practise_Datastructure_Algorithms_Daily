package LeetCode_Top_150.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> largerMinHeap = new PriorityQueue<>();

    public static void main(String[] args) {

    }


    public MedianFinder() {

    }

    public void addNum(int num) {

         smallMaxHeap.add(num);
         largerMinHeap.add(smallMaxHeap.poll());

         if(smallMaxHeap.size() < largerMinHeap.size()){
             smallMaxHeap.offer(largerMinHeap.poll());
         }

    }

    public double findMedian() {
       return smallMaxHeap.size() > largerMinHeap.size()?smallMaxHeap.peek(): ((double) smallMaxHeap.peek() + largerMinHeap.peek()) * 0.5;
    }
}
