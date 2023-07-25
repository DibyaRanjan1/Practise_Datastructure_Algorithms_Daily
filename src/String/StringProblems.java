package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringProblems {
    public static void main(String[] args) {

    }

    int longestUniqueSubsttr(String S){

        Set<Character> set = new HashSet<>();
        int startIndex = 0;
        int endIndex =0;
        int length = 0;

       for( endIndex=0;endIndex< S.length();endIndex++){

           while (endIndex > startIndex && set.contains(S.charAt(endIndex))){

               set.remove(S.charAt(startIndex));
               ++ startIndex;
           }

           set.add(S.charAt(endIndex));

           length = Math.max(length,endIndex-startIndex+1);


       }
return length;

    }

    int longestUniqueSubStrOptimize(String S){

        int length = 0;
        int startIndex = 0;
        int endIndex = 0;

        HashMap<Character,Integer> hm = new HashMap<>();

        while (endIndex < S.length()){

            if(hm.containsKey(S.charAt(endIndex))) {
               startIndex = Math.max(hm.get(S.charAt(endIndex)) + 1,startIndex);
            }

            hm.put(S.charAt(endIndex),endIndex);
            length = Math.max(length,endIndex-startIndex+1);

            ++endIndex;
        }

        return length;
    }
}
