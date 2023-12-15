package TRI;

public class TrieNew {

    private static Node root;
    public static void main(String[] args) {

    }
    public TrieNew() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char c:word.toCharArray()){
            if(!node.containsKey(c)){
             Node newNode = new Node();
                node.put(newNode,c);
            }
            node = node.get(c);
        }

        node.setEnd();
    }

    public boolean search(String word) {

        Node node = root;
        for(char ch:word.toCharArray()){

            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
     return node.flag;
    }

    public boolean startsWith(String prefix) {

        Node node = root;

        for(char ch:prefix.toCharArray()){

            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

}
