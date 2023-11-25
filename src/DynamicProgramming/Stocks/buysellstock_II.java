package DynamicProgramming.Stocks;

import java.util.Arrays;

public class buysellstock_II {
    int profit = -1;
    int buyprofit = -1;

    int sellprofit = -1;
    public static void main(String[] args) {
        buysellstock_II b = new buysellstock_II();
//      int res = b.maxProfit(new int[]{7,1,5,3,6,4});

        int res = b.maxProfit_tabulation(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
      return maxprofit_dp(1,0,prices,dp);
    }

    private int maxprofit_dp(int buy,int index, int[] prices,int[][] dp){

        if(index == prices.length) return 0;

        if(dp[index][buy]!=-1) return dp[index][buy];

             if(buy==1){
                profit =  Math.max(-prices[index] + maxprofit_dp(0,index+1,prices,dp),
                                         maxprofit_dp(1,index+1,prices,dp));
             }else {
                  profit =  Math.max(prices[index] + maxprofit_dp(1,index+1,prices,dp),
                         maxprofit_dp(0,index+1,prices,dp));
             }

        return dp[index][buy]= profit;
    }

    public int maxProfit_tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        int[] ahead = new int[2];
        int[] current = new int[2];
        ahead[0] = ahead[1] = 0;

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        dp[n][1] = 0;
        dp[n][0] = 0;

        int profit = 0;

        for(int index=n-1;index>=0;--index){

            for(int j=0;j<=1;j++){

                if(j==0){
                    profit =  Math.max(-prices[index] + ahead[1],
                            ahead[0]);
                }else {
                    profit =  Math.max(prices[index] + ahead[0] , ahead[1]);
                }
                current[j] = profit;
            }
            ahead = current;

        }
        return ahead[0];
    }


}
