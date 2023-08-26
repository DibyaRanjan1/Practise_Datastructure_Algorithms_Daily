package Array.medium;

import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[]{-1,-1};
        for(int i=0;i<nums.length;i++){
           if(map.containsKey(target-nums[i])){
               result[0] = map.get(target-nums[i]);
               result[1] = i;
           }else {
               map.put(nums[i],i);
           }
        }

        return result;
    }

    public boolean isSumPresent(int[] nums, int target){
        int start=0;
        int end=nums.length-1;

        while (start<end){
            int sum = nums[start]+nums[end];
            if(sum==target){
                return true;
            } else if (sum<target) {
                ++start;
            }else {
                --end;
            }
        }
        return false;
    }
}
