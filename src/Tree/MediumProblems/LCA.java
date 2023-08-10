package Tree.MediumProblems;

import java.util.Queue;

public class LCA {
    public static void main(String[] args) {

    }

    Node lca(Node root, int n1,int n2)
    {
   return lcaUtil(root,n1,n2);
    }

    public Node lcaUtil(Node root, int n1, int n2){
        if(root==null)  return null;

        if(root.data ==n1) return root;
        if(root.data ==n2) return root;

        Node leftNode = lcaUtil(root.left,n1,n2);
        Node rightnode = lcaUtil(root.right,n1,n2);

        if(leftNode ==null) return rightnode;
        if(rightnode ==null) return leftNode;

        if((leftNode.data ==n1 && rightnode.data ==n2) || leftNode.data ==n2 && rightnode.data ==n1){
            return root;
        }


          return root;
    }

}
