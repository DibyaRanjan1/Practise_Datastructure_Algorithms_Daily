package DynamicProgramming.Stocks;

public class buysellstocks_Iv {
    public static void main(String[] args) {
        buysellstocks_Iv b = new buysellstocks_Iv();
      int result = b.maxProfit(2,new int[]{3,2,6,5,0,3});
    }

    public int maxProfit(int k, int[] prices) {
  return maxprofit_dp(0,k,0,prices);
    }

    private int maxprofit_dp(int index,int k,int trans,int[] prices){

        if(index == prices.length || 2*k == trans) return 0;

        if(trans%2 == 0){
           return Math.max( -prices[index] +maxprofit_dp(index+1,k,trans+1,prices), maxprofit_dp(index+1,k,trans,prices));
        }
        return Math.max(prices[index]+ maxprofit_dp(index+1,k,trans+1,prices),maxprofit_dp(index+1,k,trans,prices));
    }

    public int maxProfit_tabluation(int k, int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        for(int index=n-1;index>=0;--index){
            for(int trans=(2*k)-1;trans>=0;--trans){
                if(trans%2 == 0){
                 dp[index][trans] = Math.max( -prices[index] +dp[index+1][trans+1],dp[index+1][trans]);
                }else {
                    dp[index][trans] = Math.max( prices[index] +dp[index+1][trans+1],dp[index+1][trans]);
                }
            }
        }
        return dp[0][0];
    }

    public int maxProfit_spaceoptimize(int k, int[] prices) {

        int n = prices.length;
        //int[][] dp = new int[n+1][2*k+1];

        int[] prev = new int[2*k+1];
        int[] curr = new int[2*k+1];

        for(int index=n-1;index>=0;--index){
            for(int trans=(2*k)-1;trans>=0;--trans){
                if(trans%2 == 0){
                   curr[trans] = Math.max( -prices[index] +prev[trans+1],prev[trans]);
                }else {
                    curr[trans] = Math.max( prices[index] +prev[trans+1],prev[trans]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }


}
