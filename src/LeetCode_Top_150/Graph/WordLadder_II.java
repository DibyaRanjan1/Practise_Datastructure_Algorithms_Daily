package LeetCode_Top_150.Graph;

import java.util.*;

public class WordLadder_II {
    public static void main(String[] args) {

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> ans = new ArrayList<>();

        Set<String> wordSets = new HashSet<>();
        for(String word:wordList){
            wordSets.add(word);
        }

        int level=0;

        Queue<ArrayList<String>> queue = new LinkedList<>();

        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        queue.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);


        while (!queue.isEmpty()){

           ArrayList<String> currentPopedList = queue.peek();
           queue.remove();

           if(currentPopedList.size() > level){
               ++level;
               for(String usesWord: usedOnLevel){
                   wordSets.remove(usesWord);
               }
           }

           String currentWord = currentPopedList.get(currentPopedList.size()-1);

            if(currentWord.equals(endWord)){
                if(ans.size()==0){
                    ans.add(currentPopedList);
                } else if (ans.get(0).size() == currentPopedList.size()) {
                    ans.add(currentPopedList);
                }
            }

           for(int i=0;i< currentWord.length();i++){

               for(char ch='a';ch<= 'z';ch++){

                   char[] wordInCharArray = currentWord.toCharArray();
                   wordInCharArray[i] = ch;

                   String newWord = new String(wordInCharArray);

                  

                   if(wordSets.contains(newWord)){
                       currentPopedList.add(newWord);

                       ArrayList<String> temp = new ArrayList<>(currentPopedList);
                       queue.add(temp);
                       usedOnLevel.add(newWord);

                       currentPopedList.remove(currentPopedList.size()-1);
                   }
               }
           }

        }

          return ans;
    }
}
