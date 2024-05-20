package SlidingWindow.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstraintSubSequence {
    public static void main(String[] args) {
       int[] nums = new int[]{10,-2,-10,-5,20};
       int k = 2;

       ConstraintSubSequence c = new ConstraintSubSequence();
       c.constrainedSubsetSum(nums,k);
    }

        public int constrainedSubsetSum(int[] nums, int k) {

        int result =Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[nums.length];

        for(int i=0;i<nums.length;i++){

            if(!deque.isEmpty() && i-deque.peekFirst() > k){
                deque.pollFirst();
            }

            dp[i] = (!deque.isEmpty()? dp[deque.peekFirst()]:0) + nums[i];
            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]){
                deque.pollLast();
            }

            if(dp[i]>0) {
                deque.offerLast(i);
            }
        }

        for(int num:dp){
            result = Math.max(result,num);
        }

        return result;

        }

}
