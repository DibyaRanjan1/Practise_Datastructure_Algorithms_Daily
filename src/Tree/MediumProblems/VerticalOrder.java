package Tree.MediumProblems;

import java.util.*;

public class VerticalOrder {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        verticalOrder(root);

    }

    static ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> lst = new ArrayList<>();

        if(root ==null) return lst;

        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        Queue<pair> q= new LinkedList<>();
        q.add(new pair(root,0));


        while (!q.isEmpty()){

            pair p = q.poll();

            if(map.containsKey(p.level)){
                ArrayList<Integer> lst1 = map.get(p.level);
                lst1.add(p.node.data);
                map.put(p.level,lst1);
            }else {
                ArrayList<Integer> lst1 = new ArrayList<>();
                lst1.add(p.node.data);
                map.put(p.level,lst1);
            }

            if(p.node.left!=null){
                q.add(new pair(p.node.left,p.level-1));
            }
            if(p.node.right!=null){
                q.add(new pair(p.node.right,p.level+1));
            }

        }

        for(Map.Entry<Integer,ArrayList<Integer>> map1: map.entrySet()){
            for(Integer it:map1.getValue()){
             lst.add(it);
            }
        }

        return lst;
    }


}

class pair{

    Node node;
    int level;

    public pair(Node node,int level){
        this.node = node;
        this.level = level;
    }
}
