package TRI;

public  class TrieNode {
    Boolean isEndOfWord ;
    TrieNode[] node = new TrieNode[26];

    public TrieNode(){
        isEndOfWord = false;
        for(int i=0;i< 26;i++){
            node[i] = null;
        }
    }
}
