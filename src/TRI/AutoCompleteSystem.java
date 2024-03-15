package TRI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AutoCompleteSystem {

    public TrieNode root;
    public TrieNode dummy;
    public TrieNode currentNode;
    StringBuilder currentSentence;

    public void AddTrieNode(String sentence, int count){
        TrieNode current = root;

        for(int i=0;i<sentence.length();i++){
          Character ch = sentence.charAt(i);

          if(!current.children.containsKey(ch)){
              current.children.put(ch,new TrieNode());
          }

          current = current.children.get(ch);
          current.sentences.put(sentence,current.sentences.getOrDefault(sentence,0)+count);
        }
    }

    public AutoCompleteSystem(String[] sentences, int[] times) {
     root = new TrieNode();
     dummy = new TrieNode();
     currentNode = root;
     currentSentence = new StringBuilder();

     for(int i=0;i< sentences.length;i++){
         AddTrieNode(sentences[i],times[i]);
     }
    }

    public List<String> input(char c) {

     if(c == '#'){

        AddTrieNode(currentSentence.toString(),1);
        currentSentence.setLength(0);
        currentNode =root;

         return new ArrayList<>();
     }

     currentSentence.append(c);
     if(!currentNode.children.containsKey(c)){
        currentNode =dummy;
        return new ArrayList<>();
     }

     currentNode = currentNode.children.get(c);
     List<String> sentences = new ArrayList<>(currentNode.sentences.keySet());

        Collections.sort(sentences,(a,b) ->{
            int hotA = currentNode.sentences.get(a);
            int hotB =currentNode.sentences.get(b);

            if(hotB == hotA) return a.compareTo(b);
            return hotB-hotA;
        });

        List<String> ans = new ArrayList<>();
       for(int i=0;i<Math.min(3,sentences.size());i++){
          ans.add(sentences.get(i));
       }
       return ans;
    }

    class TrieNode {
        public HashMap<Character,TrieNode> children;
        public HashMap<String,Integer> sentences;

        public TrieNode(){
            this.children = new HashMap<>();
            this.sentences = new HashMap<>();
        }
    }


}
