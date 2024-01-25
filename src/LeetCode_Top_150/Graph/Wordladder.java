package LeetCode_Top_150.Graph;

import java.util.*;

public class Wordladder {

    public static void main(String[] args) {


    }

    class Pair{
        String key;
        int value;

        public Pair(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean isWordPresent = false;
        for(String word:wordList){
            if(word.equals(endWord)){
                isWordPresent = true;
                break;
            }
        }

        if(!isWordPresent) return 0;

        Set<String> wordSets = new HashSet<>();
        for(String word:wordList){
            wordSets.add(word);
        }




        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
         wordSets.remove(beginWord);
        while (!queue.isEmpty()){

            Pair currentWordpair = queue.poll();

            String currentWord = currentWordpair.key;

            if(currentWord.equals(endWord)) return currentWordpair.value;

            for(int i=0;i<currentWord.length();i++){

                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray = currentWord.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(wordSets.contains(replacedWord)){
                        wordSets.remove(replacedWord);
                        queue.add(new Pair(replacedWord,currentWordpair.value++));
                    }
                }
            }
        }
return 0;
    }
}
