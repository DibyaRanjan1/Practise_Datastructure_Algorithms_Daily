package BinarySearchTree.LeetCode;

import BinarySearchTree.Node;

public class Largest_BST {
    static Node prev;
    static int count=0;
    static int max = 0;
    public static void main(String[] args) {


    }



    static int largestBst(Node root)
    {
        // Write your code here
        prev = new Node(Integer.MIN_VALUE);

        util(root);
        return max;


    }

    static void util(Node root){
        if(root==null) return;

        util(root.left);

        if(prev!=null &&  prev.key < root.key ){
            count++;
            if(count > max) max = count;
        }else {
            count =1;
        }
        prev = root;

        util(root.right);
    }
}
