package DynamicProgramming.Stocks;

import java.util.Arrays;

public class buysellstock_v {
    public static void main(String[] args) {

    }

    public int maxProfit( int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxprofit_dp(1,0,prices,dp, false);
    }

    private int maxprofit_dp(int buy,int index, int[] prices,int[][] dp, boolean cooldown){

        if(index == prices.length) return 0;

        if(dp[index][buy]!=-1) return dp[index][buy];
        int profit=0;

        if(buy==1){
            if(cooldown){
                profit =  Math.max(-prices[index] + maxprofit_dp(0,index+2,prices,dp,false),
                        maxprofit_dp(1,index+1,prices,dp,false));
            }else {
                profit =  Math.max(-prices[index] + maxprofit_dp(0,index+1,prices,dp,false),
                        maxprofit_dp(1,index+1,prices,dp,false));
            }

        }else {
            profit =  Math.max(prices[index] + maxprofit_dp(1,index,prices,dp,true),
                    maxprofit_dp(0,index+1,prices,dp,false));
        }

        return dp[index][buy]= profit;
    }

}
