package Revision.BackTrack.DP;

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
    FrogJump f = new FrogJump();
    int[] memo = new int[3];
        Arrays.fill(memo,-1);
   //int result = f.frogJump(2,new int[]{10,50,10},memo);
   // int result1 = f.frogJump_tabulation(2, new int[]{10,50,10});
   int result2 = f.frogJump_SpaceOptimize(2,new int[]{10,50,10});
    }

    public  int frogJump(int n, int heights[], int[] memo) {

       if(n <=0) return 0;

       if(memo[n]!=-1) return memo[n];
     int shortJump = Math.abs(heights[n] - heights[n-1]) + frogJump(n-1,heights,memo);

        int longJump =Integer.MAX_VALUE;
     if(n>1){
          longJump = Math.abs(heights[n] - heights[n-2]) + frogJump(n-2,heights,memo);
     }
     return memo[n] = Math.min(shortJump,longJump);

    }

    public int frogJump_tabulation(int n, int[] heights){

        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int shortJump = Math.abs(heights[i]-heights[i-1]) + dp[i-1];
            int longJump = Integer.MAX_VALUE;
            if(i>1){
                longJump = Math.abs(heights[i]-heights[i-2]) + dp[i-2];
            }
            dp[i] = Math.min(shortJump,longJump);
        }
        return dp[n];
    }

    public int frogJump_SpaceOptimize(int n, int[] heights){

        int result=0;
        int prev1 = 0;
        int prev2 = 0;

        for(int i=1;i<=n;i++){
           int left = Math.abs(heights[i]-heights[i-1]) + prev1;
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = Math.abs(heights[i]-heights[i-2]) + prev2;
            }
            result =  Math.min(left,right);
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }

    public int frogjump_kjump(int n, int k, int []heights,int[] memo){
        if(n <=0) return 0;

        if(memo[n]!=-1) return memo[n];

        int longJump =Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){

            if(n-i>=0){
                longJump =Math.min(longJump,Math.abs(heights[n] - heights[n-i]) + frogJump(n-i,heights,memo));
            }
        }

        return memo[n] = longJump;
    }
}
