package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Break {

    private String s;
    private List<String> wordDict;
    private int[] memo;
    public static void main(String[] args) {
        Word_Break w = new Word_Break();
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        w.wordBreak_optimize("leetcode",words);

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new int[s.length()+1];
        Arrays.fill(this.memo,-1);

        this.s = s;
        this.wordDict = wordDict;

       return dp(s.length()-1);

    }

    public boolean dp(int index){

        if(index<0) return true;
        if(memo[index] !=-1){
            return memo[index]==1;
        }
        for(String currentWord: wordDict){

            if(index-currentWord.length()+1 < 0){
                continue;
            }

            if(currentWord.equals(s.substring(index - currentWord.length()+1,index+1)) && dp(index-currentWord.length())){
             this.memo[index] = 1;
             return true;
            }

        }
        this.memo[index] = 0;
        return false;
    }

    public boolean wordBreak_optimize(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        for(int i=0;i<s.length();i++){
            for(String cuurentWord: wordDict){

                if(i < cuurentWord.length()-1){
                    continue;
                }

                if(i == cuurentWord.length()-1 || dp[i - cuurentWord.length()]){
                    if(s.substring((i-cuurentWord.length())+1, i+1).equals(cuurentWord)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()-1];
    }
}
