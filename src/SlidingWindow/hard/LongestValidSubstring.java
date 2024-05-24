package SlidingWindow.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestValidSubstring {
    public static void main(String[] args) {
        LongestValidSubstring l = new LongestValidSubstring();
        String word = "cbaaaabc";
        List<String> forbidden = new ArrayList<String>();

        forbidden.add("aaa");
        forbidden.add("cb");

       int result = l.longestValidSubstring(word,forbidden);
    }

    public int longestValidSubstring(String word, List<String> forbidden) {

        Set<String> forbiddenSets = new HashSet<>();
        int maxForbiddenLength=0;

        for(String item:forbidden){
            forbiddenSets.add(item);
            maxForbiddenLength = Math.max(maxForbiddenLength,item.length());
        }

        int leftIndex=0;
        int rightIndex=0;

        int ans=0;
        int n = word.length();

        while (rightIndex < n){

            for(int k=rightIndex;k > rightIndex-maxForbiddenLength && k>=leftIndex ; k--){

                if(forbiddenSets.contains(word.substring(k,rightIndex+1))){
                    leftIndex = k+1;
                    break;
                }
            }
            ans = Math.max(rightIndex-leftIndex+1,ans);
            rightIndex++;
        }
        return ans;

    }
}
