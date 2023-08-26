package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Fibonci {
    public static void main(String[] args) {
       int number = 5;
       int[] dp = new int[number+1];
        Arrays.fill(dp,-1);

       Fibonci f = new Fibonci();
      int result = f.fibonci(5,dp);
    }

    public int fibonci(int number,int[] dp){
        if(number<=1) return number;

        if(dp[number]!=-1){
         return dp[number] ;
        }
        return   dp[number] = fibonci(number-1,dp)+ fibonci(number-2,dp);
    }

    public int fibonci(int number){
        int prev2=0; int prev = 1;
        int cur=0;

        for(int i=2;i<=number;i++){
            cur = prev+prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;

    }
}
