package LeetCode_Top_150.Hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
LongestConsecutiveSequence l = new LongestConsecutiveSequence();
l.longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    // brute force
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);
        int result=1;
        int count=1;
        for(int i=0;i< nums.length-1;i++){
            if(nums[i] == nums[i+1]) continue;
            if(nums[i+1] == nums[i]+1){
                ++count;
                result = Math.max(result,count);
            }else {
                count =1;
            }
        }
        return result;
    }

    // Optimal
    public int longestConsecutiveOptimal(int[] nums) {
        if(nums.length==0) return 0;


        int result=1;
        int count=1;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i< nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i< nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            count=1;
            int nextValue = nums[i]+1;
            while ( set.contains(nextValue)){
                ++count;
                result = Math.max(result,count);
             nextValue = nextValue+1;
            }

        }
        return result;
    }
}
