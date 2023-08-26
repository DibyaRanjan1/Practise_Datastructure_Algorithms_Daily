package Array.medium;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
          SubArraySum s = new SubArraySum();
          s.subarraySum(new int[]{1,2,3,-3,1,1,1,4,2,-3},3);
    }

    public int subarraySum(int[] nums, int k) {
      int preSum=0;
      int count=0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++){

            preSum = preSum+ nums[i];

            int remainSum = preSum-k;

           count =count+ map.getOrDefault(remainSum,0);

            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
       return preSum;
    }
}
