package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetWithSumK {
    public static void main(String[] args) {
      int res =  findWays(new int[]{1,4,4,5},5);
    }

    public static int findWays(int[] num, int tar) {
        int n = num.length;
       //return dp_count(n-1,num,tar);

        int[][] dp = new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return dp_memo(n-1,num,tar,dp);
    }

    private static int dp_count(int index,int[] num, int tar){

        if(tar ==0) return 1;
        if(index ==0){
            if(num[index] == tar) return 1;
            return 0;
        }

        int nottake_Count = dp_count(index-1,num,tar);
        int takecount = 0;
        if(num[index] <= tar){
            takecount = dp_count(index-1,num,tar-num[index]);
        }

        return takecount + nottake_Count;
    }

    private static int dp_memo(int index,int[] num, int tar,int[][] memo){
        if(tar ==0) return 1;
        if(index ==0){
            if(num[index] == tar) return 1;
            return 0;
        }

        if(memo[index][tar] !=-1) return memo[index][tar];

        int nottake_Count = dp_count(index-1,num,tar);
        int takecount = 0;
        if(num[index] <= tar){
            takecount = dp_count(index-1,num,tar-num[index]);
        }

       return memo[index][tar] =  takecount + nottake_Count;

    }

    private static int dp_tab(int[] num, int tar){

        int n = num.length;

        int[][] dp = new int[n][tar+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
          if(num[0]<=tar){
              dp[0][num[0]] = 1;
          }

          for(int i=1;i<n;i++){
              for(int target=0;target<=tar;target++){

                  int nottakeCount = dp[i-1][tar];
                  int takecount = 0;
                  if(num[i] <= tar){
                      takecount = dp[i-1][tar-num[i]];
                  }

                  dp[i][target]  = takecount+nottakeCount;
              }
          }

          return dp[n-1][tar];
    }


}
