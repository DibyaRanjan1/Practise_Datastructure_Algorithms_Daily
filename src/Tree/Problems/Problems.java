package Tree.Problems;

import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Problems {

    static ArrayList < Integer > postOrderTrav(Node curr) {

        ArrayList< Integer > postOrder = new ArrayList < > ();
        if (curr == null) return postOrder;

        Stack< Node > s1 = new Stack < > ();
        Stack < Node > s2 = new Stack < > ();
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.peek();
            s1.pop();
            s2.push(curr);
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            postOrder.add(s2.peek().data);
            s2.pop();
        }
        return postOrder;
    }

   public static boolean isBalanced(Node root)
    {
      if(root ==null) return true;

      int leftHeight = heightOfTree(root.left);
      int rightHeight = heightOfTree(root.right);

      if(Math.abs(leftHeight-rightHeight) > 1){
          return false;
      }else {
          isBalanced(root.left);
          isBalanced(root.right);
      }
      return true;
    }

    public static boolean isBalancedOptimize(Node root){
        if(root ==null) return false;

        int result =  balancedUtility(root);

        if(result == -1) return false;
        return true;
    }

    public static int balancedUtility(Node root){
        if(root ==null) return 0;

        int lh = balancedUtility(root.left);
        if(lh ==-1) return -1;
        int rh = balancedUtility(root.right);
        if(rh ==-1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;

        return 1 + Math.max(lh,rh);
    }

    public static int diameterOfTreeUtility(Node root, int[] dia){

        if(root ==null) return 0;

        int ld = diameterOfTreeUtility(root.left,dia);
        int rd =  diameterOfTreeUtility(root.right,dia);

        dia[0] = Math.max(dia[0],ld+rd);

      return 1 + Math.max(ld,rd);
    }

    public static int diameterofTree(Node root){
        int[] dia = new int[1];

        diameterOfTreeUtility(root,dia);
       return dia[0];
    }

    public static int maxSumPathUtility(Node root,int[] maxSum){

        if(root == null) return 0;

       int leftSum =  Math.max(0,maxSumPathUtility(root.left,maxSum)) ;
       int rightSum = Math.max (0,maxSumPathUtility(root.right,maxSum));


        maxSum[0] = Math.max(maxSum[0], root.data+leftSum+rightSum);
        return root.data + Math.max(leftSum,rightSum);

    }

    public static int maxSumPath(Node root){

        int[] maxSum =new int[1];
        maxSum[0] = Integer.MIN_VALUE;

        maxSumPathUtility(root,maxSum);
        return maxSum[0];
    }

    public static int heightOfTree(Node root){

        if(root ==null) return 0;

        return 1+ Math.max(heightOfTree(root.left),heightOfTree(root.right)) ;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.right.right.right = new Node(78);
        root.right.right.right.right = new Node(9);



        //boolean result = isBalanced(root);

        Node root1 = new Node(-10);
        root1.left = new Node(-9);
        root1.right = new Node(-20);
        root1.right.left = new Node(-15);
        root1.right.right = new Node(-7);
       int result = maxSumPath(root1);

        ArrayList < Integer > postOrder = new ArrayList < > ();
        postOrder = postOrderTrav(root);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }
}
