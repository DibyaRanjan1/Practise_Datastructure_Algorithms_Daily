package Design;

public class WordDictionary {

    public static void main(String[] args) {

        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("a");


      boolean ispresent =  w.search(".");
         ispresent =  w.search("a");
         ispresent =  w.search("aa");
         ispresent =  w.search("a");

        ispresent =  w.search(".a");
        ispresent =  w.search("a.");
    }

    Trie trie = null;

    public WordDictionary() {
       trie = new Trie();
    }

    public void addWord(String word) {
       trie.add(word);
    }

    public boolean search(String word) {
         return trie.search(word);
    }
}

class Trie {

    Node root = null;

    public Trie() {
        root = new Node();
    }

    public void add(String word) {

        Node node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                node.links[ch - 'a'] = new Node();
            }
            node = node.get(ch);
        }
        node.setEndFlag();
    }

    public boolean search(String word) {
        Node node = root;
    return searchUtil(word,node);
    }


    public boolean searchUtil(String word,Node node) {

        for(int i=0;i<word.length();i++){

            if(word.charAt(i) == '.' || !node.containsKey(word.charAt(i))){
                if(word.charAt(i) == '.'){

                    for (int j=0;j<node.links.length;j++){

                       if((node.links[j] != null) && searchUtil(word.substring(i+1),node.links[j]))
                       {
                           return true;
                       }
                    }
                }
               return false;
            }else {
                node = node.get(word.charAt(i));
            }
        }
        return node.isEndFlag;
    }
}

class Node{
    public Node[] links = new Node[26];
    public boolean isEndFlag=false;

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }

    public void setEndFlag(){
        this.isEndFlag = true;
    }

    public boolean getEndFlag(){
        return this.isEndFlag;
    }
}
