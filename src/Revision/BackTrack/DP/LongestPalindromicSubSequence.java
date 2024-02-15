package Revision.BackTrack.DP;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {

        LongestPalindromicSubSequence l = new LongestPalindromicSubSequence();
       int res = l.longestPalindromeSubseq("bbbab");
    }

    public int longestPalindromeSubseq(String s) {
      int n = s.length();
      int[][] memo = new int[n][n];

      return recur(0,n-1,s,memo);

    }

    private int recur(int frontIndex, int backIndex, String s, int[][] memo){


        if(frontIndex > backIndex){
            return 0;
        }
        if(frontIndex == backIndex) return 1;

        if(memo[frontIndex][backIndex]!=0) return memo[frontIndex][backIndex];
        int take =0;
        if(s.charAt(frontIndex) == s.charAt(backIndex)){
            take = 2 + recur(frontIndex+1,backIndex-1,s,memo);
        }

        int notTake = Math.max(recur(frontIndex+1,backIndex,s,memo), recur(frontIndex,backIndex-1,s,memo));

        return memo[frontIndex][backIndex] =  Math.max(take,notTake);
    }


}
