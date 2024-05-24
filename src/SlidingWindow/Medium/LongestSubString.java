package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
      LongestSubString longestSubString = new LongestSubString();
      longestSubString.lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
     int leftIndex=0;
     int rightIndex=0;
     int result=0;

        Map<Character,Integer> charCount = new HashMap<>();

     for(;rightIndex <s.length();rightIndex++){

         Character c = s.charAt(rightIndex);
         charCount.put(c,charCount.getOrDefault(c,0)+1);

         while (charCount.size() >2){
             Character currentChar = s.charAt(leftIndex);
             leftIndex++;
            int count = charCount.get(currentChar);
            if(count==1){
                charCount.remove(currentChar);
            }else {
                charCount.put(currentChar,--count);
            }
         }

         result = Math.max(result,rightIndex-leftIndex+1);

     }
     return result;

    }
}
