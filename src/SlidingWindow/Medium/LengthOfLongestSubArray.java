package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubArray {
    public static void main(String[] args) {
       LengthOfLongestSubArray lengthOfLongestSubArray = new LengthOfLongestSubArray();
       lengthOfLongestSubArray.maxSubarrayLength(new int[]{1,1,1,3},2);
    }

    public int maxSubarrayLength(int[] nums, int k) {

        int n =nums.length;
        int result=1;

        int leftIndex=0;
        int rightIndex=0;

        for(;rightIndex<n;++rightIndex){
            Map<Integer,Integer> tempMap = new HashMap<>();
            int i =leftIndex;
            int count=0;
            while (i < n && (tempMap.isEmpty() || tempMap.getOrDefault(nums[i],0) <=k) ){
                if(tempMap.getOrDefault(nums[i],0)+1 >k){
                    break;
                }
                tempMap.put(nums[i], tempMap.getOrDefault(nums[i],0)+1);
               result = Math.max(result,++count);

               ++i;
            }
            ++leftIndex;

        }
        return result;
    }
}
