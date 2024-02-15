package Revision.BackTrack.DP;

import java.util.Arrays;

public class CoinChange_II {
    public static void main(String[] args) {
       CoinChange_II c = new CoinChange_II();
      int res = c.change(5,new int[]{1,2,5});
    }

    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(memo[i],-1);
        }
     return change_recur(coins.length-1,amount,coins,memo);
    }

    private int change_recur(int index,int amount, int[] coins, int[][] memo){

        if(index ==0){
            if(amount % coins[index] ==0) return 1;
            return 0;
        }
        if(amount ==0) return 1;

        if(memo[index][amount]!=-1) return memo[index][amount];


      int take =0;
      if(coins[index] <= amount) take =change_recur(index,amount-coins[index],coins,memo);
        int nottake = change_recur(index-1,amount,coins,memo);
      return memo[index][amount] = take + nottake;
    }
}
