package Revision.BackTrack.DP.MCIM;

import java.util.Arrays;

public class PalindromPartioning {
    public static void main(String[] args) {

    }

    public int minCut(String s) {
       int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return minCut(0,s,memo)-1;
    }

    private int minCut(int index,String s,int[] memo) {

        if(index == s.length()) return 0;

        if(memo[index]!=-1) return memo[index];

        int res = Integer.MAX_VALUE;
        for(int j=index;j<s.length();j++){
            if(isPalindrom(s,index,j)){
                int cost = 1 + minCut(j+1,s,memo);
                res = Math.min(res,cost);
            }
        }
        return memo[index] = res;
    }

    private boolean isPalindrom(String s,int i,int j){

        while (i<=j){
            if(s.charAt(i) !=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
