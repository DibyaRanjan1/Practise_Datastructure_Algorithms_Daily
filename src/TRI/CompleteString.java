package TRI;

public class CompleteString {
    public static void main(String[] args) {
    CompleteString.completeString(6,new String[]{"n", "ni", "nin", "ninj", "ninja", "ninga"});
    }

    public static String completeString(int n, String[] a) {

        TrieNew1 trieNew1 = new TrieNew1();
        for(String word: a){
                 trieNew1.insert(word);
        }
      String result = "";

      for(int i=0;i<a.length;i++){

         boolean isPresent = trieNew1.isExist(a[i]);
         if(!isPresent) continue;
         if(a[i].length() > result.length()){
             result = a[i];
         } else if (a[i].length() == result.length() && a[i].compareTo(result) < 0) {
             result = a[i];
         }
      }

      if(result =="" ){
          return "None";
      }
      return result;
    }
}

class TrieNew1{

    public static TrieNode1  root;
    public TrieNew1(){
       root = new TrieNode1();
    }

    public void insert(String word){

        TrieNode1 node = root;
        for(char ch:word.toCharArray()){

            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode1());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean isExist(String word){
        TrieNode1 node = this.root;

        for(char ch:word.toCharArray()){
          boolean isPresent =  node.get(ch).isEnd;
          if(!isPresent){
              return false;
          }
          node = node.get(ch);
        }
        return true;
    }
}

class TrieNode1{

    public TrieNode1(){}
   public TrieNode1[] links = new TrieNode1[26];
    public boolean isEnd = false;

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch, TrieNode1 node){
       links[ch-'a'] = node;
    }

    public TrieNode1 get(char ch){
        return links[ch-'a'];
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        this.isEnd = true;
    }
}
