package SlidingWindow.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

     Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

     for(int i=0;i<k;i++){
         while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
             deque.pollLast();
         }
         deque.addLast(i);
     }
     res.add(nums[deque.peekFirst()]);

     for(int i=k;i<nums.length;i++){
         if(i-k==deque.peekFirst()){
             deque.pollFirst();
         }

         while (!deque.isEmpty() && nums[i] >= nums[deque.pollLast()]){
             deque.pollLast();
         }
         deque.addLast(i);
         res.add(nums[deque.peekFirst()]);

     }
     return res.stream().mapToInt(i->i).toArray();

    }
}
