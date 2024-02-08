package Revision.BackTrack.DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

        ClimbingStairs c = new ClimbingStairs();
        c.climbStairs(5);
    }



    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
    int result = recusion_dp(n,dp);

    return result;
    }

    private int recusion_dp(int n,int[] dp){
        if(n==0) return 1;
        if(n <0) return 0;

        if(dp[n]!=-1) return dp[n];

       return dp[n] = recusion_dp(n-1,dp) + recusion_dp(n-2,dp);

    }

    private int tabulation(int n){

        int prev2=0;
        int prev = 1;
        for(int i=1;i<=n;i++){
            int current = prev+prev2;
            prev2 = prev;
            prev = current;
        }
        return prev;

    }
}
