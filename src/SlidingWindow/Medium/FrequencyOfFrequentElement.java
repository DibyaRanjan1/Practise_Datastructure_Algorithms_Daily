package SlidingWindow.Medium;

import java.util.Arrays;

public class FrequencyOfFrequentElement {
    public static void main(String[] args) {

    }

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        long curr=0;

        int left=0;
        int ans =1;


        for(int right=0;right<nums.length;right++){
            int target = nums[right];
            curr += nums[right];

            while ((right-left+1)* target - curr > k){
                curr -= nums[left];
                ++left;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;

    }
}
