package Revision.BackTrack.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
      //int result =  h.rob(new int[]{2,7,9,3,1});
      //int result1 = h.rob_oprimize1(new int[]{2,7,9,3,1});
       // int result = h.dp_tabulation(new int[]{2,7,9,3,1});
        int result1 = h.dp_spaceOPtimizatopn(new int[]{2,7,9,3,1});
    }

    public int rob(int[] nums) {
        int index = nums.length-1;
        return dp_recussion(index,nums);
    }

    private int dp_recussion(int index, int[] nums){
        if(index <0) return 0;

            int rob =  dp_recussion(index-2,nums) + nums[index];
            int notRob =  dp_recussion(index-1,nums);
            return Math.max(rob,notRob);
    }

    public int rob_oprimize1(int[] nums) {
        int index = nums.length-1;
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        return dp_memoization(index,nums,memo);
    }

    private int dp_memoization(int index, int[] nums, int[] memo){
        if(index <0) return 0;

        if(memo[index]!=-1) return memo[index];
        int rob =  dp_memoization(index-2,nums,memo) + nums[index];
        int notRob =  dp_memoization(index-1,nums,memo);
        return memo[index] = Math.max(rob,notRob);
    }

    private int dp_tabulation(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[0] = nums[0];


        for(int i=1;i<n;i++){
            int rob = nums[i];
            if(i >1){
                rob += dp[i-2];
            }
            int notRob = dp[i-1];
            dp[i] = Math.max(rob,notRob);
        }

        return dp[n-1];
    }

    private int dp_spaceOPtimizatopn(int[] nums){
        int n = nums.length;
        int prev2=0;
        int prev =  nums[0];
        int current = 0;
        for(int i=1;i<n;i++){

        int rob = nums[i];
        if(i>1){
            rob+= prev2;
        }
        int notRob = prev;

            current = Math.max(rob,notRob);
            prev2 = prev;
            prev = current;
        }

        return prev;

    }

}
