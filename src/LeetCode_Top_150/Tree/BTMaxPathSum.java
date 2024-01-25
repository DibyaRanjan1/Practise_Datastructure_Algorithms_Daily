package LeetCode_Top_150.Tree;

import Tree.MediumProblems.TreeNode;

public class BTMaxPathSum {
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
      result = Integer.MIN_VALUE;
      util(root);
      return result;
    }
   private int result =0;
    public int util(TreeNode root){
        if (root == null) {
            return 0;
        }
      int gainFromLeft =  Math.max(util(root.left),0);
        int gainFromRight =  Math.max(util(root.right),0);

      result =  Math.max(result,gainFromLeft+gainFromRight+root.val);

       return Math.max(gainFromLeft+root.val,gainFromRight+root.val);
    }
}
