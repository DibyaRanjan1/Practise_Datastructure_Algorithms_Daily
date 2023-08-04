package Graph;

import java.util.*;

public class Word_Ladder_Two {
    public static void main(String[] args) {

        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        Word_Ladder_Two two = new Word_Ladder_Two();
        ArrayList<ArrayList<String>> result = two.findSequences(startWord,targetWord,wordList);

    }


    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Queue<ArrayList<String>> queue = new LinkedList<ArrayList<String>>();
        int count=0;
        int level=0;

        Set words = new HashSet();

        for(int i=0;i<wordList.length;i++){
            words.add(wordList[i]);
        }
        ArrayList<String> lst = new ArrayList<>();
        lst.add(startWord);
        queue.add(lst);

        ArrayList<String> levelOrderedList = new ArrayList<>();
        levelOrderedList.add(startWord);

        while (!queue.isEmpty()){
           ++count;
            ArrayList<String> tempList = queue.poll();

            String word = tempList.get(tempList.size()-1);
              if(tempList.size() > level){
                  ++level;
                  for(String it: levelOrderedList){
                      words.remove(it);
                  }
              }

            if(word.equals(targetWord)){
                result.add(tempList);
            }

            for(int i=0;i<word.length();i++){

                for(char ch='a';ch < 'z';ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String newReplacedWord = new String(charArray);

                    if(words.contains(newReplacedWord)){
                         tempList.add(newReplacedWord);
                        levelOrderedList.add(newReplacedWord);

                        ArrayList<String> lst1 = new ArrayList<>(tempList);
                        queue.add(lst1);

                        tempList.remove(tempList.size()-1);
                    }
                }
            }
        }
        return result;
    }
}
