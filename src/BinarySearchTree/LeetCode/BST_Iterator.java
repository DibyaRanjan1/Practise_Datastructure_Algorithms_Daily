package BinarySearchTree.LeetCode;

import java.util.Stack;

public class BST_Iterator {

    Stack<TreeNode> stack;
    boolean isReverse;

    public BST_Iterator(TreeNode root, boolean isReverse){
        this.isReverse = isReverse;
        this.stack = new Stack<TreeNode>();
        pushaAll(root);
    }

    public int next(){
        TreeNode node = stack.pop();
        int result = node.val;
        if(isReverse){
            pushaAll(node.left);
        }else {
            pushaAll(node.right);
        }
        return result;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public void pushaAll(TreeNode node){
        while (node!=null){
            if(isReverse){
                node = node.right;
            }else {
                node = node.left;
            }
        }
    }

}
