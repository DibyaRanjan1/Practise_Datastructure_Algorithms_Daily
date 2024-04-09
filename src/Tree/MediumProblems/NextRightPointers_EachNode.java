package Tree.MediumProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightPointers_EachNode {
    public static void main(String[] args) {

    }

   private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            Node currNode =null;
            Node prev=null;
            for(int i=0;i<size;i++){
               currNode =  queue.poll();
               if(prev!=null){
                   prev.next = currNode;
               }
                prev = currNode;

                if(currNode.left!=null) queue.add(currNode.left);
                if(currNode.right!=null) queue.add(currNode.right);
            }
            currNode.next =null;

        }
        return root;
    }

    public Node connect_Optimal(Node root) {
        if(root==null) return null;

        Node leftMost = root;

        while (leftMost.left!=null){

            Node curr = leftMost;

            while (curr!=null){

                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
