package SlidingWindow.hard;

public class CountSubArrayFixedBound {
    public static void main(String[] args) {

    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
     int minindex =-1;
     int maxIndex =-1;
     int outRange = -1;

     long res =0;

     for(int i=0;i< nums.length;i++){

         if(nums[i] < minK || nums[i] > maxK){
             outRange = i;
         }
         if(nums[i]==minK){
             minindex =i;
         }

         if(nums[i]==maxK){
             maxIndex =i;
         }
         res += Math.max(0, Math.min(maxIndex,minindex)-outRange);


     }

     return res;


    }
}
