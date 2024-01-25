package LeetCode_Top_150.Array;

public class MaxSumCircularArray {
    public static void main(String[] args) {

    }

    public int maxSubarraySumCircular(int[] nums) {

        int globalMax = nums[0];
        int globalMin = nums[0];

        int currentMax = 0;
        int currentMin = 0;

        int total=0;

        for(int i=0;i< nums.length;i++){
            currentMax = Math.max(nums[i],currentMax+nums[i]);
            currentMin = Math.min(nums[i],currentMin+nums[i]);

            globalMax = Math.max(globalMax,currentMax);
            globalMin = Math.min(globalMin,currentMin);
            total += nums[i];
        }
        if(globalMax <0) return globalMax;
        return Math.max(globalMax,total-globalMin);
    }
}
