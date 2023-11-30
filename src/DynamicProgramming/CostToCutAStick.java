package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CostToCutAStick {
    public static void main(String[] args) {
        CostToCutAStick c  =new CostToCutAStick();
        c.minCost(7,new int[]{1,3,4,5});
    }

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(0,0);
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<=n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return dp_mincost(1,cuts.length,list,dp);
    }

    private int dp_mincost(int i, int j, ArrayList<Integer> cuts,int[][] dp){

        if (i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;


        for(int index=i;index<=j;index++){

            min =  Math.min(min, cuts.get(j+1) - cuts.get(i-1) +
                    dp_mincost(i,index-1,cuts,dp)+
                    dp_mincost(index+1,j,cuts,dp));
        }
        return dp[i][j] = min;
    }
}
