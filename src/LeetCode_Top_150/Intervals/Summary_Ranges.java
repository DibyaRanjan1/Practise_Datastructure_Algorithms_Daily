package LeetCode_Top_150.Intervals;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
    public static void main(String[] args) {

    }

    // My solution

    public List<String> summaryRanges(int[] nums) {
       List<String> result = new ArrayList<>();
       if(nums.length==0) return result;
       int count = 0;

       for(int i=0;i< nums.length-1;i++){
           if(nums[i]+1 == nums[i+1]){
               ++count;
           }else {
               if(count==0){
                   String s =  ""+nums[i]+"";
                   result.add(s);
               }else {
                   String s =  ""+nums[i-count]+"->"+nums[i]+"";
                   result.add(s);
               }
               count=0;
           }
       }
       if(count==0){
           String s =  ""+nums[nums.length-1]+"";
           result.add(s);
       }else {
           String s =  ""+nums[nums.length-1-count]+"->"+nums[nums.length-1]+"";
           result.add(s);
       }
       return result;
    }

    public List<String> summaryRanges_clean(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(int i=0;i< nums.length;i++){
            int start = nums[i];

            while (i+1 < nums.length && nums[i]+1 == nums[i+1]){
                i++;
            }

            if(start!=nums[i]){
                result.add(start+"->"+nums[i]);
            }else {
                result.add(String.valueOf(nums[i]));
            }
        }
        return result;
    }
}
