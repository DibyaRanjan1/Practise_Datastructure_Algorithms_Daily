package Revision.BackTrack.DP;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
     int n = word1.length();
     int m = word2.length();

     int[][] memo = new int[n][m];

     for(int i=0;i<n;i++){
         Arrays.fill(memo[i],-1);
     }
     return recur(n-1,word1,m-1,word2,memo);
    }

    private int recur(int index1, String word1, int index2, String word2, int[][] memo){

        if(index1<0) return index2+1;
        if(index2<0) return index1+1;

        if(memo[index1][index2]!=-1) return memo[index1][index2];

        if(word1.charAt(index1)==word2.charAt(index2)){
            return memo[index1][index2] = recur(index1-1,word1,index2-1,word2,memo);
        }

        return memo[index1][index2] = Math.min(1 + recur(index1,word1,index2-1,word2,memo),Math.min(recur(index1-1,word1,index2-1,word2,memo),recur(index1-1,word1,index2,word2,memo)));
    }
}
