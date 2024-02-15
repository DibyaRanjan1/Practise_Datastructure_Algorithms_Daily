package Revision.BackTrack.DP;

import java.util.Arrays;

public class UnboundedKnapscak {
    public static void main(String[] args) {

      int result =  UnboundedKnapscak.unboundedKnapsack(3,10,new int[]{5,11,3},new int[]{2,4,6});
      //int result1 = unboundedKnapsack_tab(3,10,new int[]{5,11,3},new int[]{2,4,6});
    }

    public static int unboundedKnapsack_tab(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n+1][w+1];

     for(int i=0;i<=w;i++){
         dp[0][i] = ((int)(w/ weight[0] )) * profit[0];
     }


     for(int i=1;i<n;i++){
         for(int j=1;j<=w;j++){
             int take = 0;
             if(weight[i]<= w){
                 take = profit[i] + dp[i][w-weight[i]];

             }
             int notTake = dp[i-1][j];
             dp[i][j] = Math.max(take,notTake);
         }
     }
     return dp[n-1][w];

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] memo = new int[n][w+1];

        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
      return unboundedKnapsack_recur(n-1,w,profit,weight,memo);
    }

    private static int unboundedKnapsack_recur(int index,int weight,int[] profit, int[] weights, int[][] memo){

        if(index ==0){
           return ((int)(weight/ weights[0] )) * profit[0];
        }

        if(memo[index][weight]!=-1) return memo[index][weight];
      int take = -1;



      if(  weights[index] <= weight){
          take =  profit[index]+unboundedKnapsack_recur(index,weight-weights[index],profit,weights,memo);
      }

     int notTake =   unboundedKnapsack_recur(index-1,weight,profit,weights,memo);

      return memo[index][weight] = Math.max(take,notTake);
    }
}
