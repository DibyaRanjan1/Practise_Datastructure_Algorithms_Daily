package DynamicProgramming.Stocks;

import java.util.Arrays;

public class buysellstock_III {
    public static void main(String[] args) {

        buysellstock_III b = new buysellstock_III();
//       int result = b.maxProfit(new int[]{3,3,5,0,0,3,1,4});
        int result = b.maxProfit_tabulation(new int[]{3,3,5,0,0,3,1,4});
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return maxprofit_dp(1,0,prices,dp,2);
    }

    private int maxprofit_dp(int buy,int index, int[] prices,int[][][] dp, int cap){

        if(index == prices.length) return 0;
        if(cap == 0) return 0;

        if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
         int profit = 0;
        if(buy==1){
            profit =  Math.max(-prices[index] + maxprofit_dp(0,index+1,prices,dp,cap),
                    maxprofit_dp(1,index+1,prices,dp,cap));
        }else {
            profit =  Math.max(prices[index] + maxprofit_dp(1,index+1,prices,dp,cap-1),
                    maxprofit_dp(0,index+1,prices,dp,cap));
        }

        return dp[index][buy][cap]= profit;
    }

    public int maxProfit_tabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];


        int profit = 0;
        for(int index=n-1;index>=0;--index){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){

                    if(buy==1){
                        dp[index][buy][cap] =  Math.max(-prices[index] + dp[index+1][0][cap],
                                dp[index+1][buy][cap]);
                    }else {
                        dp[index][buy][cap] =  Math.max(prices[index] + dp[index+1][1][cap-1],
                                dp[index+1][0][cap]);
                    }

                }
            }
        }
        return dp[0][1][2];
    }
}
