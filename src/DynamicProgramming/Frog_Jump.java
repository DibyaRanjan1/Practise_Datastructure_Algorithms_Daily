package DynamicProgramming;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
//     int result =frogJump(3,new int[]{10 ,20 ,30, 10});

        int result =findFrogJump(new int[]{10 ,20 ,30, 10});


    }

    public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n-1,heights,dp);



    }

    private static int f(int n,int heights[],int dp[]){
        if(n==0) return 0;

        if(dp[n]!=-1){
            return dp[n];
        }
        int leftResult = f(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
        int rightResult=Integer.MAX_VALUE;
        if(n>1){
            rightResult = f(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        }
        return dp[n] = Math.min(leftResult,rightResult);
    }

    //using tabular
    private static int findFrogJump(int height[])
    {
        int[] dp = new int[height.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        int leftResult =Integer.MAX_VALUE;
        int rightResult=Integer.MAX_VALUE;

        for(int i=1;i<height.length;i++){
            leftResult = dp[i-1]+ Math.abs(height[i]- height[i-1]);

            if(i>1){
                rightResult = dp[i-2] + Math.abs(height[i]-height[i-2]);
            }

            dp[i] = Math.min(leftResult,rightResult);
        }
        return dp[height.length-1];
    }

    private static int findFrogJumpSpaceOptimized(int height[])
    {

        int result=0;

        int prev2=0;
        int prev = 0;

        for(int i=1;i<height.length;i++){
            result = prev + Math.abs(height[i]-height[i-1]);


            prev2 = prev;
            prev = result;
        }
        return prev;
    }
}
