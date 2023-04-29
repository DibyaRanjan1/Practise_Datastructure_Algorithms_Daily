package TRI;

public class Trie {
    static TrieNode root ;
    public static void main(String[] args) {
        String keys[] = {"the", "a"};

        root = new TrieNode();

        for(int i=0;i< keys.length;i++){
            Insert(keys[i]);
        }

        System.out.println(Search("the"));

    }

    public static  void Insert(String key){
        TrieNode curr = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i) - 'a';
            if(curr.node[index] ==null){
                curr.node[index] = new TrieNode();
            }
            curr = curr.node[index];
        }
        curr.isEndOfWord  = true;
    }

    public static boolean Search(String key){
        TrieNode curr = root;
        for(int i =0;i<key.length();i++){
            int index = key.charAt(i) - 'a';
            if(curr.node[index] ==null){
                return false;
            }
            curr = curr.node[index];
        }
        return (curr!=null && curr.isEndOfWord);
    }

    public static void Delete(String key){
        TrieNode curr = root;
        TrieNode prev = null;

        for(int i=0;i< key.length();i++){

            int index = key.charAt(i) - 'a';
            if(curr.node[index].isEndOfWord){
                curr.node = null;
            }
            prev = curr;
            curr = curr.node[index];
        }
    }
}
