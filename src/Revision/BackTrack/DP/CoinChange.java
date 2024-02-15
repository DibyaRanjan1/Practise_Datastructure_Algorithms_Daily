package Revision.BackTrack.DP;

public class CoinChange {
    public static void main(String[] args) {
      CoinChange c = new CoinChange();
    int result =  c.coinChange(new int[]{1,2,5},11);
    }

    public int coinChange(int[] coins, int amount) {
     return coinChange_Recur(coins.length-1,coins,amount);
    }

    private int coinChange_Recur(int index, int[] coins, int amount){

        if(amount ==0){
            return 1;
        }

        if(index ==0){
            if(amount % coins[index]==0){
                return amount/coins[index];
            }
            return (int)1e9;
        }

        int take = Integer.MAX_VALUE;

        if(coins[index] <= amount)
         take =1+  coinChange_Recur(index,coins,amount-coins[index]);
        int notTake = coinChange_Recur(index-1,coins,amount);

      return Math.min(take,notTake);

    }
}
