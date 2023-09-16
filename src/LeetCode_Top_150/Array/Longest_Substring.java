package LeetCode_Top_150.Array;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Substring {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {

        int result = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int length = s.length();


        //pwwkew
        while (right<length){
             Character currentChar = s.charAt(right);
             if(map.containsKey(currentChar)){
                 left = Math.max(left,map.get(currentChar));
             }

           result = Math.max(result,right-left+1);
           map.put(currentChar,right+1);
             ++right;
        }
        return result;
    }

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int left=0;
        int right=0;
        int length = s.length();

        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while (right<length){

            Character currentChar = s.charAt(right);

            map.put(currentChar,map.getOrDefault(currentChar,0)+1);

            while (map.get(currentChar)>1){
                 Character currentLeftChar = s.charAt(left);
                map.put(currentChar,map.get(currentLeftChar)-1);
                ++left;
            }

            result = Math.max(result,right-left+1);
            right++;

        }
        return result;
    }
}
