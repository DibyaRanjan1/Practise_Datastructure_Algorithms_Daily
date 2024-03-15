package Revision.BackTrack.DP.MCIM;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {

    }

    public static int mcm(int[] p){
     int[][] memo = new int[p.length][p.length];
     for(int i=0;i<p.length;i++){
         Arrays.fill(memo[i],-1);
     }

     return mac_memo(1,p.length-1,p,memo);
    }

    private static int mac_memo(int i,int j,int[] p,int[][] memo){
        if(i==j) return 0;

        if(memo[i][j]!=-1) return memo[i][j];

        int mini= (int)1e9;
        for(int k=i;k<j;k++){
            int steps =  p[i-1]*p[k]*p[j] + mac_memo(i,k,p,memo) + mac_memo(k+1,j,p,memo);
            if(steps < mini){
                mini = steps;
            }
        }
        return memo[i][j] =  mini;
    }
}
