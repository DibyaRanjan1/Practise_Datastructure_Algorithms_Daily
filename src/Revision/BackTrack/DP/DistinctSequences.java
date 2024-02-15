package Revision.BackTrack.DP;

import java.util.Arrays;

public class DistinctSequences {
    public static void main(String[] args) {
       DistinctSequences d = new DistinctSequences();
     int res = d.numDistinct_tabulation("rabbbit","rabbit");
    }

    public int numDistinct(String s, String t) {
      int[][] memo = new int[s.length()][t.length()];
      for(int i=0;i<s.length();i++){
          Arrays.fill(memo[i],-1);
      }

      return recur(s.length()-1,s,t.length()-1,t,memo);
    }

    private int recur(int index1, String s, int index2,String t,int[][] memo){

        if(index2<0) return 1;
        if(index1 <0) return 0;

        if(memo[index1][index2]!=-1) return memo[index1][index2];

        if(s.charAt(index1) == t.charAt(index2)){
            return memo[index1][index2] = recur(index1-1,s,index2-1,t,memo) + recur(index1-1,s,index2,t,memo);
        }

        return memo[index1][index2] = recur(index1-1,s,index2,t,memo);
    }

    public int numDistinct_tabulation(String s, String t) {
        int n=s.length();
        int m = t.length();
        int[][] memo = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            memo[i][0] = 1;
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1)==t.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
                }else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        return memo[n][m];

    }
}
