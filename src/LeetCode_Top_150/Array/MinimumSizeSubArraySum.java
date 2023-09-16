package LeetCode_Top_150.Array;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
     MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
     m.minSubArrayLen(13,new int[]{1,2,3,4,5});
    }

//    public int minSubArrayLen(int target, int[] nums) {
//      int firstPointer=1;
//      int secondPointer = 0;
//      int sum=nums[0];
//      int result = 0;
//
//      for(;firstPointer< nums.length;firstPointer++){
//          if(sum==target){
//              result = Math.max(result,firstPointer-secondPointer);
//          }
//
//          sum = sum + nums[]
//      }
//    }

    public int minSubArrayLen(int target, int[] nums) {

     int result = Integer.MAX_VALUE;
     int secondPointer = 0;
     int sum = 0;

     for(int i=0;i< nums.length;i++){
         sum = sum + nums[i];

         while (sum >=target){
             result = Math.min(result,i-secondPointer+1);
             sum = sum - nums[secondPointer++];
         }
     }
     if(result == Integer.MAX_VALUE) return 0;
     return result;

    }


}
