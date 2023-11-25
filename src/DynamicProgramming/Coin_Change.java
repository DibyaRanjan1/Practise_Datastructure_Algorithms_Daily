package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coin_Change {

    private int[] coins;

    private int mincount = Integer.MAX_VALUE;

    private int[] memo;
    public static void main(String[] args) {

        Coin_Change c = new Coin_Change();
        c.coinChange_my(new int[]{1,2,5}, 11);
        //c.coinChange(new int[]{1,2,5}, 11);
    }

    public int coinChange_my(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new int[amount+1];
        Arrays.fill(this.memo,-1);

       int result = dp(amount);
       if(result == Integer.MAX_VALUE) return -1;
       return result;
    }

    private int dp(int sum){

        if(sum ==0){
            return 0;
        }
        if(sum <0){
            return Integer.MAX_VALUE;
        }

        if(this.memo[sum] !=-1) return this.memo[sum];
        int min = Integer.MAX_VALUE;

       for(int num:coins){

       int res =  dp(sum-num) ;
        if(res >=0 && res < min){
            min = 1+res;
        }

       }
       this.memo[sum] = (min == Integer.MAX_VALUE)?-1:min;
       return this.memo[sum];
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> map=new HashMap<>();
        return coinChange(coins,amount,map);
    }
    private int coinChange(int[] coins, int amount, Map<Integer,Integer> mem ){
        if(amount<0) return -1;
        if(amount==0) return 0;
        Integer c=mem.get(amount);
        if(c!=null) return c;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange(coins, amount-coins[i],mem);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        mem.put(amount,cc);
        return cc;
    }


    private int dp_again(int index,int[] coins, int amount){

        if(index ==0){
            if(amount%coins[index] ==0) return amount/coins[index];
            return Integer.MAX_VALUE;
        }

        int nottake = dp_again(index-1,coins,amount);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[index]){
            take = 1+ dp_again(index,coins,amount-coins[index]) ;
        }
        return Math.min(take,nottake);

    }
}
