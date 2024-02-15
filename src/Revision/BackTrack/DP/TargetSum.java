package Revision.BackTrack.DP;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
      TargetSum t = new TargetSum();
    int result =   t.findTargetSumWays(new int[]{1,1,1,1,1},3);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][target+1];

        for(int i=0;i< nums.length;i++){
            Arrays.fill(memo[i],-1);
        }

    return  findTargetSumWays_recur(nums.length-1, nums,target, memo);

    }

    private int findTargetSumWays_recur(int index,int[] nums, int target, int[][] memo){

        if(index <0) return 0;
        if(index ==0){
            if(target == nums[0] || target ==0) return 1;
        }
        else{
            if(memo[index][target]!=-1) return memo[index][target];


            int sub = findTargetSumWays_recur(index-1,nums,target-nums[index],memo);

            int add =  findTargetSumWays_recur(index-1,nums,target+nums[index],memo);

            return memo[index][target] = sub + add;
        }

   return 1;

    }
}
