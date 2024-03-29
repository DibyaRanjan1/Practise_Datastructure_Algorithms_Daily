package Tree.MediumProblems;

public class TreeToDoublyList {
   private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node head = null;
    Node tail=null;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;

       treeToDoublyListUtil(root);
       tail.right =head;
       head.left = tail;
       return head;
    }

    public void treeToDoublyListUtil(Node node) {
     if(node==null) return ;

       treeToDoublyListUtil(node.left);
       if(head == null){
           head = node;
       }
       if(tail!=null){
           tail.right =node;
           node.left =tail;
       }
       tail =node;
       treeToDoublyListUtil(node.right);

    }
}
