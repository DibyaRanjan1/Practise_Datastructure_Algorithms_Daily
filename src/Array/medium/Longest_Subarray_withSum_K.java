package Array.medium;

import java.util.HashMap;

public class Longest_Subarray_withSum_K {
    public static void main(String[] args) {

        Longest_Subarray_withSum_K l = new Longest_Subarray_withSum_K();
        //int[] array = new int[]{1,2,3,1,1,1,1,3,3};
        //l.findSubArrayWithSum(array,3);

        int[] input = new int[]{1,2,3,1,1,1,1,3,3};
        l.findSubArrayWithSumTwoPointer(input,6);
    }

    public int findSubArrayWithSum(int[] nums,int k){
        int maxLen=0;
        int sum=0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            sum = sum+nums[i];

            if(sum == k){
                maxLen  = Math.max(maxLen,i+1);
            }
            int rem = sum-k;


            if(map.containsKey(rem)){
                int tempdata = map.get(rem);
                maxLen = Math.max(maxLen,i-tempdata);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return maxLen;
    }

    public int findSubArrayWithSumTwoPointer(int[] nums, int k){
        int start=0;
        int end=0;

        int length = nums.length;
        int sum=nums[0];

        int maxCount=0;

        while (end< length){

            while (start <= end && sum>k){
                sum = sum-nums[start];
                ++start;
            }

            if(sum==k){
                maxCount = Math.max(maxCount,end-start+1);
            }

            ++end;
            if(end<length) sum = sum+nums[end];
        }
        return maxCount;
    }
}
