package LeetCode_Top_150.SlidingWindow;

import java.util.*;

public class SubStringConcatAllWords {
    public static void main(String[] args) {

        SubStringConcatAllWords s = new SubStringConcatAllWords();
      List<Integer> result =  s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String,Integer> wordSets = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(String word:words){
            wordSets.put(word,wordSets.getOrDefault(word,0)+1);
        }

        int wordLength = words[0].length();
        int wordsLength = words.length;

        for(int i=0;i<s.length()- (wordLength*wordsLength)+1;i++){
            String currentSubWindow = s.substring(i,i+wordLength*wordsLength);
            if(isConcat(currentSubWindow,wordSets,wordLength)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isConcat( String currentSubWindow, HashMap<String,Integer> wordSets, int eachWordLength ){
        HashMap<String,Integer> seen = new HashMap<>();
        for(int i=0;i<currentSubWindow.length();i+=eachWordLength){
            String word = currentSubWindow.substring(i,i+eachWordLength);

            if(wordSets.containsKey(word)){
                seen.put(word,seen.getOrDefault(word,0)+1);
            }else {
                return false;
            }
        }
        return seen.equals(wordSets);
    }
}
