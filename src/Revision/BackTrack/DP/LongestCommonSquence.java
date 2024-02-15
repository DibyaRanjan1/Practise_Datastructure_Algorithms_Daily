package Revision.BackTrack.DP;

public class LongestCommonSquence {
    public static void main(String[] args) {
        LongestCommonSquence l = new LongestCommonSquence();
       int result = l.longestCommonSubsequence("abcde","ace");
    }

    public int longestCommonSubsequence(String text1, String text2) {
     return recur(text1.length()-1,text1,text2.length()-1,text2);
    }

    private int recur(int index1, String text1,int index2, String text2){

        if(index1 <0 || index2 <0 ) return 0;
        int take = 0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            take = 1 + recur(index1-1,text1,index2-1,text2);
        }
        int notTake = Math.max(recur(index1-1,text1,index2,text2),recur(index1,text1,index2-1,text2));

        return Math.max(take,notTake);
    }
}
