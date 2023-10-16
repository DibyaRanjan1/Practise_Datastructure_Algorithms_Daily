package DynamicProgramming;

import java.util.Arrays;

public class Zero_One_Knapsack {

  static   int[][] dp = new int[1001][1001];


    public static void main(String[] args) {
      knapSack(4, new int[]{4,5,1},new int[]{1,2,3},3);
    }

    static int knapSack(int W, int wt[], int val[], int n){
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSackUtil(W,wt,val,n);

    }

    static int knapSackUtil(int W, int wt[], int val[], int n)
    {
        if(W==0 || n==0) return 0;

        if(dp[n][W] !=-1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){
            return dp[n][W] =  Math.max( val[n-1]+ knapSack(W-wt[n-1],wt,val,n-1),
                             knapSack(W,wt,val,n-1)
                    );
        } else if (wt[n-1] > W){
            return dp[n][W] = knapSack(W,wt,val,n-1);
        }
        return 0;
    }
}
