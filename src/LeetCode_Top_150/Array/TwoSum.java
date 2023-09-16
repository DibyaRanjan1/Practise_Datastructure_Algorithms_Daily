package LeetCode_Top_150.Array;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){

          if(map.containsKey(target-nums[i])){
              int firstIndex = map.get(target-nums[i]);
              return new int[] {firstIndex,i};
          }

          map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }
}
