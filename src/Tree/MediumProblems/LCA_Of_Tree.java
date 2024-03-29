

import java.util.HashSet;
import java.util.Set;

public class LCA_Of_Tree {
    public static void main(String[] args) {

    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
         Set<Integer> sets = new HashSet<>();

         Node temp = q;
        while (temp!=null){
            sets.add(temp.val);
            temp = q.parent;
            q = q.parent;
        }
        temp = p;
        while (temp!=null){
            if(sets.contains(temp.val)) return temp;
            temp = p.parent;
            p =p.parent;
        }
        return null;
    }

    public Node lowestCommonAncestor_optimal(Node p, Node q) {
        Node a =p;
        Node b =q;

        while (a!=b){
            a = a==null ?q:a.parent;
            b = b==null?p:b.parent;
        }
        return a;
    }




}
