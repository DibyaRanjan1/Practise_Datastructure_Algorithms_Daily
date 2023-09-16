package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class Word_Pattern {
    public static void main(String[] args) {
    Word_Pattern w = new Word_Pattern();
    w.wordPattern("abba","dog cat cat dog");
    }

    // Failing testcases
    public boolean wordPattern(String pattern, String s) {
       String[] splitedArray =  s.split(" ");
       if(splitedArray.length != pattern.length()) return false;

        HashMap<Character,String> map = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i)))
            {
                map.put(pattern.charAt(i),splitedArray[i]);
            }else {
                String currentString = map.get(pattern.charAt(i));
                if(!currentString.equals(splitedArray[i])) return false;
            }
        }
        return true;
    }

    public boolean worldPattern1(String pattern, String s){
        String[] splitedArray = s.split(" ");
        if(splitedArray.length != pattern.length()) return false;

        HashMap map = new HashMap();

        for(int i=0;i< splitedArray.length;i++){
            char c = pattern.charAt(i);
            String word = splitedArray[i];
            if(!map.containsKey(c))
            {
                map.put(c,i);
            }
            if(!map.containsKey(word)){
                map.put(word,i);
            }

            if(map.get(c) !=map.get(word)) return false;
        }
        return true;


    }
}
