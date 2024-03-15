package Revision.BackTrack.DP.BuySellStock;

import java.util.Arrays;

public class BuySellStock {
    public static void main(String[] args) {
      BuySellStock b = new BuySellStock();

    }

    public int maxProfit(int[] prices) {
      int mini = prices[0];
      int profit = 0;

      for (int i=1;i<prices.length;i++){

          int  currentprofit = prices[i] - mini;
           profit = Math.max(currentprofit,profit);
           mini = Math.min(mini,prices[i]);
      }
      return profit;

    }

    public int maxProfit_II(int[] prices,int fee) {
        int n = prices.length;
        int m =2;
        int[][] memo = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return maxProfit_II_Memo(0,1,prices, memo,fee);
    }

    private int maxProfit_II_Memo(int index, int buy,int[] prices,int[][] memo,int fee){

        if(index == prices.length) return 0;

        if(memo[index][buy]!=-1) return memo[index][buy];
        int profit = 0;
        if(buy==1){

            profit = Math.max(-prices[index]+maxProfit_II_Memo(index+1,0,prices,memo,fee),
                    maxProfit_II_Memo(index+1,1,prices,memo,fee));
        }else {
            profit = Math.max(prices[index]-fee+ maxProfit_II_Memo(index+1,1,prices,memo,fee), maxProfit_II_Memo(index+1,0,prices,memo,fee));
        }
        return memo[index][buy] = profit;
    }

}
