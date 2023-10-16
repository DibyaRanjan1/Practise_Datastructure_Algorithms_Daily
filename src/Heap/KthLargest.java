package Heap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {

    }

    PriorityQueue<Integer> pq = null;
    int KthLargest = 0;

    public KthLargest(int k, int[] nums) {
        this.KthLargest = k;


      pq = new PriorityQueue<>();
      for(int i=0;i< nums.length;i++){
          pq.add(nums[i]);
      }
       int len = nums.length - k;
      while (len>0){
      pq.poll();
      --len;
      }

    }
    public int add(int val) {
       pq.add(val);

       int len = pq.size()-this.KthLargest;
       while (len>0){

           pq.poll();
       }
      return pq.peek();
    }

    }
