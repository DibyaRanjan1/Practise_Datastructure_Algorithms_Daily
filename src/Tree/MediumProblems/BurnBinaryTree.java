package Tree.MediumProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnBinaryTree {
    public static void main(String[] args) {

    }

    public static int minTime(Node root, int target)
    {
        // Your code goes here

        if(root==null) return 0;
        Map<Node,Node> parentmap = new HashMap<>();

       Node targetNode =  getParent(root,parentmap,target);


        int count=-1;


         Map<Node,Boolean> visited = new HashMap<>();

         Queue<Node> q = new LinkedList<>();
         q.add(targetNode);
         visited.put(targetNode,true);

         while (!q.isEmpty()){
              count++;
             int size = q.size();

             for(int i=0;i<size;i++){
                 Node curr= q.poll();
                 Node parent = parentmap.get(curr);

                 if(curr.left!=null && visited.get(curr.left) == null){
                     q.add(curr.left);
                     visited.put(curr.left,true);
                 }

                 if(curr.right!=null && visited.get(curr.right) == null){
                     q.add(curr.right);
                     visited.put(curr.right,true);
                 }

                 if(parent!=null && visited.get(parent) == null){
                   visited.put(parent,true);
                   q.add(parent);
                 }
             }
         }

         return count;

    }

    private static Node getParent(Node root, Map<Node,Node> parentmap, int target ){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()){
            Node curr = q.poll();

            if(curr.data == target) {
                targetNode = curr;
            }
            if(curr.left!=null){
                q.add(curr.left);
                parentmap.put(curr.left,curr);
            }

            if(curr.right!=null){
                q.add(curr.right);
                parentmap.put(curr.right,curr);
            }
        }
        return targetNode;
    }
}
