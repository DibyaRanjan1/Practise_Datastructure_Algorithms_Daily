package SlidingWindow.Medium;

public class CountSubArray {
    public static void main(String[] args) {
       CountSubArray countSubArray = new CountSubArray();
       countSubArray.countSubarrays(new int[]{1,3,2,3,3},2);
    }

    public long countSubarrays(int[] nums, int k) {

        int maxNumber=0;
        for(int i=0;i< nums.length;i++){
            maxNumber = Math.max(maxNumber,nums[i]);
        }


     int leftIndex=0;
     int rightindex=0;

     int maxNumberCount =0;
     long result=0;

     for(;rightindex < nums.length;rightindex++){

         if(nums[rightindex]==maxNumber){
             maxNumberCount++;
         }

         while (maxNumberCount == k){
             if(nums[leftIndex]== maxNumber){
                 --maxNumberCount;
             }
             leftIndex++;
         }
         result += leftIndex;
     }
    return result;
    }
}
