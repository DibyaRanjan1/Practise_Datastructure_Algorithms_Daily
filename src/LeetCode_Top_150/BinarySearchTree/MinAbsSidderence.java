package LeetCode_Top_150.BinarySearchTree;

import Tree.MediumProblems.TreeNode;

public class MinAbsSidderence {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

MinAbsSidderence m = new MinAbsSidderence();
int mindd =  m.getMinimumDifference(root);
    }

    int mini = Integer.MAX_VALUE;
    TreeNode prev =null;
    public int getMinimumDifference(TreeNode root) {
        util(root);
        return mini;
    }

    private void util(TreeNode root){
        if(root ==null) return;

        util(root.left);

        if(prev!=null){
            mini = Math.min(mini,root.val - prev.val);
        }
        prev = root;
        util(root.right);
    }


}
