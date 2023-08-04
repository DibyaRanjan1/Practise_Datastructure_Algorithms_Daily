package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_One {
    public static void main(String[] args) {

    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> hashSet = new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            hashSet.add(wordList[i]);
        }
        Queue<Pair> qPair = new LinkedList<>();

        qPair.add(new Pair(startWord,1));
        hashSet.remove(startWord);

        while (!qPair.isEmpty()){
            String currentVal = qPair.peek().first;
            int dis = qPair.peek().second;
            qPair.remove();

            if(currentVal.equals(targetWord)){
                return dis;
            }

            for(int i=0;i<currentVal.length();i++){
                char orginalLetter = currentVal.charAt(i);
                for(char j='a';j<= 'z';j++){
                    char[] replacedCharArray = currentVal.toCharArray();
                    replacedCharArray[i] = j;
                    String newReplacedString = new String(replacedCharArray);

                    if(hashSet.contains(newReplacedString)){
                        qPair.add(new Pair(newReplacedString,dis+1));
                        hashSet.remove(newReplacedString);
                    }
                }
            }
        }

return 0;
    }

    class Pair{
        public String first;
        public int second;

        public Pair(String first,int distance){
            this.first = first;
            this.second = distance;
        }
    }
}
