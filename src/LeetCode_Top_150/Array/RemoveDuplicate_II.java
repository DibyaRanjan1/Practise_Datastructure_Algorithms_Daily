package LeetCode_Top_150.Array;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate_II {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

      int slow = 1;
      int fast = 1;

      int count = 1;

      for(;fast< nums.length;fast++){
         if(nums[fast] == nums[fast-1]){
             ++count;
         }else {
             count  =1;
         }

         if(count<=2){
             nums[slow++] = nums[fast];
         }
      }
      return slow;
    }
}
