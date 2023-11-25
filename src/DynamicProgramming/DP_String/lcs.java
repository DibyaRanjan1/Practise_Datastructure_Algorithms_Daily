package DynamicProgramming.DP_String;

import java.util.Arrays;

public class lcs {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
     int m = text1.length();
     int n = text2.length();

     int[][] dp = new int[m+1][n+1];

     for(int i=0;i<=m;i++){
         Arrays.fill(dp[i],-1);
     }

   return   lcs_recur(m,n,text1,text2,dp);
    }

    private int lcs_recur(int index1, int index2,String text1, String text2,int[][] dp){
        if(index1 <0 || index2 <0){
            return 0;
        }

        if(dp[index1][index2] !=-1) return dp[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2] = 1 + lcs_recur(index1-1,index2-1,text1,text2,dp);
        }

        return dp[index1][index2] = Math.max(lcs_recur(index1,index2-1,text1,text2,dp),lcs_recur(index1-1,index2,text1,text2,dp));
    }

    public int longestCommonSubsequence_tabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }

}
