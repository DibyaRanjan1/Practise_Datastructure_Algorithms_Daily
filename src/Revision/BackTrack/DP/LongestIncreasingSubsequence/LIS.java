package Revision.BackTrack.DP.LongestIncreasingSubsequence;

import java.util.Arrays;

public class LIS {


    public static void main(String[] args) {
        LIS l = new LIS();
       int res =  l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length+1];

        for(int i=0;i< nums.length;i++){
            Arrays.fill(memo[0],-1);
        }

    return lengthOfLIS_recur(0,-1,nums,memo);
    }

    public int lengthOfLIS_tabulation(int[] nums) {
       int n = nums.length;
       int[][] dp = new int[n+1][n+1];

       for(int index = n-1;index>=0;index--){
           for(int prevIndex = index-1;prevIndex >=-1;prevIndex--){
               int notTake = dp[index+1][prevIndex+1];
               int take = 0;
               if(prevIndex==-1 || nums[index] > nums[prevIndex]){
                   take = 1 + dp[index+1][index+1];
               }
               dp[index][prevIndex+1] = Math.max(take,notTake);
           }
       }

       return dp[0][0];

    }

    public int lengthOfLIS_optimal(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxi =1;
      for(int index=0;index<n;index++){
          for(int prevIndex=0;prevIndex < index;prevIndex++){
              if(nums[prevIndex]<nums[index]){
                  dp[index] = Math.max(dp[index],(1 + dp[prevIndex]));
              }
          }
          maxi = Math.max(maxi,dp[index]);
      }
   return maxi;

    }

    public int lengthOfLIS_optimal_print(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];

        int maxi =1;
        for(int index=0;index<n;index++){
            hash[index] =index;

            for(int prevIndex=0;prevIndex < index;prevIndex++){
                if(nums[prevIndex]<nums[index] && (1 + dp[prevIndex] > dp[index])){
                    dp[index] = 1 + nums[prevIndex];
                    hash[index] = prevIndex;
                }
            }
            maxi = Math.max(maxi,dp[index]);
        }
        return maxi;

    }

    public int lengthOfLIS_recur(int index, int prevIndex, int[] nums, int[][] memo) {

        if(index == nums.length){
            return 0;
        }

        if(memo[index][prevIndex]!=-1) return memo[index][prevIndex];
        int take = 0;
        if(prevIndex==-1 || nums[index]> nums[prevIndex]){
            take = 1 + lengthOfLIS_recur(index+1,index,nums,memo);
        }
        int notTake = lengthOfLIS_recur(index+1,prevIndex,nums,memo);

        return memo[index][prevIndex+1] = Math.max(take,notTake);
    }

}
