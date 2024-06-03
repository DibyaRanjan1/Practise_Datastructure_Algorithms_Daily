package SlidingWindow.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuesSubArray {
    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums, int limit) {

        int leftIndex=0;
        int result=1;

        Deque<Integer> maxDequeue = new ArrayDeque<>();
        Deque<Integer> minDequeue = new ArrayDeque<>();

        for(int rightIndex=0;rightIndex< nums.length;rightIndex++){


            while (!maxDequeue.isEmpty() && maxDequeue.peekLast() < nums[rightIndex]){
                maxDequeue.pollLast();
            }
            maxDequeue.addLast(nums[rightIndex]);

            while (!minDequeue.isEmpty() && minDequeue.peekLast() > nums[rightIndex]){
                minDequeue.pollLast();
            }
            minDequeue.addLast(nums[rightIndex]);

            while (Math.abs(maxDequeue.peekFirst() - minDequeue.peekFirst()) > limit){
                if(nums[leftIndex]==maxDequeue.peekFirst()) maxDequeue.pollFirst();
                if(nums[leftIndex]== minDequeue.peekFirst()) minDequeue.pollFirst();
                ++leftIndex;
            }

            result = Math.max(result, rightIndex-leftIndex+1);
        }

return result;

    }
}
