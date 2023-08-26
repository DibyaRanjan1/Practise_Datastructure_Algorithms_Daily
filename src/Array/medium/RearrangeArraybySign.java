package Array.medium;

import java.util.ArrayList;

public class RearrangeArraybySign {
    public static void main(String[] args) {

    }

    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int positiveIndex=0;
        int negativeIndex=1;

        for (int i=0;i< nums.length;i++){
            if(nums[i]>0){
                if(positiveIndex < nums.length) result[positiveIndex] = nums[i];
                positiveIndex = positiveIndex+2;
            }
            if(nums[i]<0){
                if(negativeIndex < nums.length) result[negativeIndex] =nums[i];
                negativeIndex = negativeIndex+2;
            }
        }


      return result;
    }
}
