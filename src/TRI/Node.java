package TRI;

public class Node {
    public  Node(){}

    Node links[] = new Node[26];
    boolean flag = false;

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(Node node, char ch){
        links[ch-'a'] = node;
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd(){
        flag = true;
    }
}
