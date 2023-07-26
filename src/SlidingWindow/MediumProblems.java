package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MediumProblems {
    public static void main(String[] args) {

        int[] arr = new int[]{48,
                41 ,12, 13, 33, 31, 39, 38, 38, 11, 13, 24, 38, 24, 11, 24, 1, 8, 1, 11, 8, 2, 34, 9, 4, 32, 23, 17, 23, 24, 40, 29, 34, 9, 45, 22, 25, 9, 18, 27, 4, 12, 26, 47, 23, 8, 21, 16, 37};
       int result = totalFruits(6,arr);
    }

    public static int longestOnes(int n, int[] nums, int k) {
        // code here

        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        int arrayLength = nums.length;
        int flip = 0;


        for(endIndex=0;endIndex< arrayLength;endIndex++){

            if(nums[endIndex]==0){
                ++flip;
            }
            while (flip > k){
                if(nums[startIndex] ==0){
                    --flip;
                }
                ++startIndex;
            }

            result = Math.max(result,endIndex-startIndex+1);
        }
        return result;
    }


    public static int totalFruits(int N, int[] fruits) {
     int startIndex = 0;
     int endIndex = 0;

     int arrayLength = fruits.length;
     int result = 0;

     HashMap<Integer,Integer> hm = new HashMap<>();
     for(;endIndex< arrayLength;endIndex++){

        int value = hm.getOrDefault(fruits[endIndex],0);

         hm.put(fruits[endIndex],value+1);

         while( hm.size() > 2){

           int val =  hm.get(fruits[startIndex]);
           if(val ==1) {
               hm.remove(fruits[startIndex]);
           }else {
               hm.put(fruits[startIndex],--val);
           }
             ++startIndex;
         }

         result = Math.max(result, endIndex-startIndex+1);
     }
return result;
    }
}
