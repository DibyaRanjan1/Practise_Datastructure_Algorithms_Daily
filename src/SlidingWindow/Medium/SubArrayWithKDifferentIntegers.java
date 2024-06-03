package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegers {
    public static void main(String[] args) {
     SubArrayWithKDifferentIntegers subArrayWithKDifferentIntegers = new SubArrayWithKDifferentIntegers();
     subArrayWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1,2,1,2,3},2);
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
      return helper(nums,k) - helper(nums,k-1);
    }

    public int helper(int[] nums, int k) {
        int n= nums.length;
        Map<Integer,Integer> intMap = new HashMap<>();
        int result=0;
        int leftIndex=0;

        for(int rightIndex=0;rightIndex<n;rightIndex++){

            intMap.put(nums[rightIndex],intMap.getOrDefault(nums[rightIndex],0)+1);

            while (intMap.size() > k){
                intMap.put(nums[leftIndex],intMap.get(nums[leftIndex])-1);
                if(intMap.get(nums[leftIndex])==0){
                    intMap.remove(nums[leftIndex]);
                }
                ++leftIndex;
            }

            result += (rightIndex-leftIndex+1);
        }
        return result;
    }
}
